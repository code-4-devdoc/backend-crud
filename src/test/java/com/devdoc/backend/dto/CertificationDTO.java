package com.devdoc.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificationDTO {

    private Integer id;
    private String certificationName;
    private String issuer;
    private String issueDate;
}
