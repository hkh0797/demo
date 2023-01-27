package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TreeDto;
import com.example.demo.service.TreeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class TreeController {

    private final TreeService Service;

    @PostMapping("tree/list")
    public List<TreeDto> demoList() throws Exception {
        return Service.getDemoList();
    }

}
