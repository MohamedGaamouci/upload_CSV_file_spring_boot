package com.monsif_team.spring_boot_upload_files.Student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/uploadStudent" ,consumes = {"multipart/form-data"})
    private ResponseEntity<Integer> uploadStudent(){
        return ResponseEntity.ok(1);
    }
}
