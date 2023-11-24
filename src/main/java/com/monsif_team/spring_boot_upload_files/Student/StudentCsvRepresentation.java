package com.monsif_team.spring_boot_upload_files.Student;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCsvRepresentation { // to represent the csv header

    @CsvBindByName(column = "firstname")
    private String fname;

    @CsvBindByName(column = "lastname")
    private String lname;

    @CsvBindByName(column = "age")
    private int age;

}
