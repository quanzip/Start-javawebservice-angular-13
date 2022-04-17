package com.example.backend.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class PeopleDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String passWord;
    private int pNumber;
    private int isActived;
}

