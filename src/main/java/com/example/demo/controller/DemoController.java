package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DemoDto;
import com.example.demo.entity.DemoEntity;
import com.example.demo.model.Header;
import com.example.demo.service.DemoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class DemoController {

    private final DemoService demoService;

    @PostMapping("demo/list")
    public List<DemoDto> demoList() {
        return demoService.getDemoList();
    }

    @GetMapping("/demo/list")
    public Header<List<DemoDto>> boardList(
            @PageableDefault(sort = { "idx" }) Pageable pageable) {
        return demoService.getDemoList(pageable);
    }

    @GetMapping("/demo/{id}")
    public DemoDto getBoard(@PathVariable Long id) {
        return demoService.getBoard(id);
    }

    @PostMapping("/demo")
    public DemoEntity create(@RequestBody DemoDto dto) {
        return demoService.create(dto);
    }

    @PatchMapping("/demo")
    public DemoEntity update(@RequestBody DemoDto dto) {
        return demoService.update(dto);
    }

    @DeleteMapping("/demo/{id}")
    public void delete(@PathVariable Long id) {
        demoService.delete(id);
    }
}
