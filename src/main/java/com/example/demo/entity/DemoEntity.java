package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "BOARD", schema = "hkh0797dev")
@Entity
@SequenceGenerator(name = "BOARD_SEQ", sequenceName = "BOARD_SEQ", initialValue = 0, allocationSize = 1)
public class DemoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ")
    private Long idx;
    private String title;
    private String author;
    private String contents;
    private LocalDateTime createdAt;
}
