package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TreeDto;
import com.example.demo.entity.TreeEntity;
import com.example.demo.entity.TreeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TreeService {

    private final TreeRepository treeRepository;

    /**
     * 게시글 목록 가져오기
     */
    public List<TreeDto> getDemoList() throws Exception {

        List<TreeEntity> demoEntities = treeRepository.findAllByOrderByIdAsc();
        List<TreeDto> dtos = new ArrayList<>();

        for (TreeEntity entity : demoEntities) {
            TreeDto dto = TreeDto.builder()
                    .id(entity.getId())
                    .orderseq(entity.getOrderseq())
                    .address(entity.getAddress() == null ? null : entity.getAddress())
                    .text(entity.getText())
                    .children(entity.getChildren() == null ? null
                            : Arrays.asList(entity.getChildren().replace(" ", "").split(",")))
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
}
