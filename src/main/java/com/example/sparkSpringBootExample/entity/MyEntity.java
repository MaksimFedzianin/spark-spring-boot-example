package com.example.sparkSpringBootExample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyEntity {
    @Id
    private Integer id;
    private String name;
    private String column;
}
