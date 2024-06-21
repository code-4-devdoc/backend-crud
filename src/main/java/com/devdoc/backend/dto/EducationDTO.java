package com.devdoc.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDTO {

    private int id;
    private String schoolName;
    private String major;
    private String enrollmentPeriod;
    private String status;
}
