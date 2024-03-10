package org.example.event.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DateFormat;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Event {
         private int id;
        private String description;
        private int capacity;

        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate startDate;

        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate endDate;
}
