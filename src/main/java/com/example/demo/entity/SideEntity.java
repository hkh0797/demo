package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "NAVI", schema = "hkh0797dev")
@Entity
public class SideEntity {
    @Id
    private Integer id;
    private String href;
    private String title;
    private String child;
    private Integer parentid;
    // private String state;
}
