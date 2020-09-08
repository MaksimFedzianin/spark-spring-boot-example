package com.example.sparkSpringBootExample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicElement {
    @Id
    private Long id;
    private String name;
    private String type;
    private String description;
    private String status;
    private String smId;
    private String parentName;
    private String businessLine;
    private String archEa;
    private String archSa;
    private String businessAdmin;
    private String supportAdmin;
    private String devAdmin;
    private String replaceOn;
    private String solutionStatus;
    private String lifecycleState;
    private String priority;
    private String place;
    private String solDate;
    private String eolDate;
    private String applicationServer;
    private String applicationServerOperatingSystem;
    private String dbServer;
    private String dbServerOperatingSystem;
    private String clientLanguage;
    private String serverLanguage;
    private String vendor;
}
