package com.example.sparkSpringBootExample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Component {
    @Id
    private Long id;
    private RecordStatus status;
    private ComponentType type;
    private String name;
    private String description;
    private ComponentStatus componentStatus;
    @DBRef
    private System system;
    @DBRef
    private Component parent;
    private List<String> tags;
    private Platform platform;
    private OperatingSystem operatingSystem;
    private DevelopmentLanguage developmentLanguage;
    private Vendor vendor;
    private Network network;
}