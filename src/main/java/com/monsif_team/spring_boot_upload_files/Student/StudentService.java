package com.monsif_team.spring_boot_upload_files.Student;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Integer uploadStudents(MultipartFile file) throws IOException {
        Set<Student> students = parseCsv(file);
        studentRepo.saveAll(students);
        return students.size();
    }

    private Set<Student> parseCsv(MultipartFile file) throws IOException {

        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<StudentCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();

            strategy.setType(StudentCsvRepresentation.class); // define the strategy

            CsvToBean<StudentCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<StudentCsvRepresentation>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();

            return csvToBean.parse().stream()
                    .map(csvline ->Student.builder()
                                    .firstname(csvline.getFname())
                                    .lastname(csvline.getLname())
                                    .age(csvline.getAge())
                                    .build()
                    ).collect(Collectors.toSet());
        }
    }
}
