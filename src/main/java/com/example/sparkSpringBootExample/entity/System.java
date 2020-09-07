package com.example.sparkSpringBootExample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class System {
    @Id
    private Long id;
    private RecordStatus status;
    private SystemType type;
    private String name;
    private String description;
    private SystemStatus systemStatus;
    private String smId;
    @DBRef
    private System parent;
    private BusinessLine businessLine;
    private String archEa;
    private String archSa;
    private String businessAdmin;
    private String supportAdmin;
    private String devAdmin;
    private SolutionStatus solutionStatus;
    private Priority priority;
    private LocalDate solDate;
    private LocalDate eolDate;
    private List<String> tags;
    private List<String> altNames;
}
