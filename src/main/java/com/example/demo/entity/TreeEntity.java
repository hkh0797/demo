package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TREE", schema = "hkh0797dev")
@Entity
public class TreeEntity {
    @Id
    private BigDecimal id;
    private BigDecimal orderseq;
    private String address;
    private String text;
    private String children;
    private String state;
}
