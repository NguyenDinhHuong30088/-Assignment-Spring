package com.example.hellospring.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private String rollNumber;
    private String fullname;
    private String email;
    private String address;
    private int status;

    public Student(String rollNumber, String fullname) {
        this.rollNumber = rollNumber;
        this.fullname = fullname;
    }
}
