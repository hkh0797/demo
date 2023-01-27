package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.SideDto;
import com.example.demo.entity.SideEntity;
import com.example.demo.entity.SideRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SideService {

    private final SideRepository sideRepository;

    /**
     * 게시글 목록 가져오기
     */
    public List<SideDto> getSideList() throws Exception {

        List<SideEntity> sideEntities = sideRepository.findAllByOrderByIdAsc();
        List<SideDto> dtos = new ArrayList<>();

        for (SideEntity entity : sideEntities) {
            SideDto dto = SideDto.builder()
                    .id(entity.getId())
                    .href(entity.getHref() == null ? null : entity.getHref())
                    .title(entity.getTitle())
                    .child(entity.getChild() == null ? null : entity.getChild())
                    .parentid(entity.getParentid() == null ? 0 : entity.getParentid())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
}
