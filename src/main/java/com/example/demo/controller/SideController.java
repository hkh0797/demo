package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SideDto;
import com.example.demo.service.SideService;

// import flexjson.JSONSerializer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class SideController {

    private final SideService Service;

    @PostMapping("nav/list")
    public List<SideDto> sideList() throws Exception {

        List<SideDto> sList = Service.getSideList();

        Map<String, Object> maps = null;
        List<Object> lists = new ArrayList<>();
        List<Object> lists2 = new ArrayList<>();
        List<Object> lists3 = new ArrayList<>();

        for (int i = 0; i < sList.size(); i++) {
            maps = new HashMap<String, Object>();
            if (sList.get(i).getParentid() == 0) {
                maps.put("id", sList.get(i).getId());
                maps.put("href", sList.get(i).getHref());
                maps.put("title", sList.get(i).getTitle());
                if (sList.get(i).getId() == 1) {
                    maps.put("child", lists2);
                }
                lists.add(maps);
            } else if (sList.get(i).getParentid() == 1) {
                maps.put("id", sList.get(i).getId());
                maps.put("href", sList.get(i).getHref());
                maps.put("title", sList.get(i).getTitle());
                if (sList.get(i).getId() == 3) {
                    maps.put("child", lists3);
                }
                lists2.add(maps);
            } else if (sList.get(i).getParentid() == 3) {
                maps.put("id", sList.get(i).getId());
                maps.put("href", sList.get(i).getHref());
                maps.put("title", sList.get(i).getTitle());
                lists3.add(maps);
            }
        }

        // JSONSerializer serializer = new JSONSerializer();
        // System.out.println(serializer.include("parentid").serialize(sList));

        return sList;
    }
}
