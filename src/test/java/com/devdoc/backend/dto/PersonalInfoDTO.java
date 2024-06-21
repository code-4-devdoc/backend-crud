package com.devdoc.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoDTO {

    private Integer id;
    private String photo;
    private String name;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private String blog;
    private String introduction;
}
