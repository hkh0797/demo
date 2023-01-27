package com.example.demo.dto;

import java.io.Serializable;
// import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SideDto implements Serializable {
    private Integer id;
    private String href;
    private String title;
    private String child;
    private Integer parentid;
    // private Map<String, Object> state;
}
