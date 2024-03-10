package org.example.student.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private String name;
    private int age;
    private String degree;
    private String status;

}
