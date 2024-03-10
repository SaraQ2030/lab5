package org.example.tracker2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Tracker {
    private String id;
    private String title;
    private String description;
    private String status;
    private String companyName;
}
