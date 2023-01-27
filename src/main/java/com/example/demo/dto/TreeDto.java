package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TreeDto implements Serializable {
    private BigDecimal id;
    private BigDecimal orderseq;
    private String address;
    private String text;
    private List<String> children;
    private Map<String, Object> state;
}
