package com.monsif_team.spring_boot_upload_files.Student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/Student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/uploadStudent" ,consumes = {"multipart/form-data"})
    private ResponseEntity<Integer> uploadStudent(
            @RequestPart("file")MultipartFile file
            ) throws IOException {
        return ResponseEntity.ok(studentService.uploadStudents(file));
    }
}
