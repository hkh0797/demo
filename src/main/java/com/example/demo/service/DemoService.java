package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DemoDto;
import com.example.demo.entity.DemoEntity;
import com.example.demo.entity.DemoRepository;
import com.example.demo.model.Header;
import com.example.demo.model.Pagination;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DemoService {

    private final DemoRepository demoRepository;

    /**
     * 게시글 페이징
     */
    public Header<List<DemoDto>> getDemoList(Pageable pageable) {
        List<DemoDto> dtos = new ArrayList<>();

        Page<DemoEntity> boardEntities = demoRepository.findAllByOrderByIdxDesc(pageable);
        for (DemoEntity entity : boardEntities) {
            DemoDto dto = DemoDto.builder()
                    .idx(entity.getIdx())
                    .author(entity.getAuthor())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .createdAt(entity.getCreatedAt() == null ? null// null 처리
                            : entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();

            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) boardEntities.getTotalElements(), pageable.getPageNumber() + 1, pageable.getPageSize(), 10);

        return Header.OK(dtos, pagination);
    }

    /**
     * 게시글 목록 가져오기
     */
    public List<DemoDto> getDemoList() {

        List<DemoEntity> demoEntities = demoRepository.findAll();
        List<DemoDto> dtos = new ArrayList<>();

        for (DemoEntity entity : demoEntities) {
            DemoDto dto = DemoDto.builder()
                    .idx(entity.getIdx())
                    .author(entity.getAuthor())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .createdAt(entity.getCreatedAt() == null ? null
                            : entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }

    /**
     * 게시글 가져오기
     */
    public DemoDto getBoard(Long id) {
        DemoEntity entity = demoRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return DemoDto.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .author(entity.getAuthor())
                .createdAt(entity.getCreatedAt() == null ? null// null 처리
                        : entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();
    }

    /**
     * 게시글 등록
     */
    public DemoEntity create(DemoDto dto) {
        DemoEntity entity = DemoEntity.builder()
                .title(dto.getTitle())
                .contents(dto.getContents())
                .author(dto.getAuthor())
                .createdAt(LocalDateTime.now())
                .build();
        return demoRepository.save(entity);
    }

    /**
     * 게시글 수정
     */
    public DemoEntity update(DemoDto dto) {
        DemoEntity entity = demoRepository.findById(dto.getIdx())
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setTitle(dto.getTitle());
        entity.setContents(dto.getContents());
        return demoRepository.save(entity);
    }

    /**
     * 게시글 삭제
     */
    public void delete(Long id) {
        DemoEntity entity = demoRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        demoRepository.delete(entity);
    }

}
