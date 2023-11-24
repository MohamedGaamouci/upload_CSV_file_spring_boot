package com.monsif_team.spring_boot_upload_files.Student;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

}
