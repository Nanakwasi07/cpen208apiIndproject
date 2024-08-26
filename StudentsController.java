package com.example.demo.controller;

import com.example.demo.dto.StudentsDto;
import com.example.demo.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private StudentsService studentsservice;

    // Build Add Students REST API
    @PostMapping
    public ResponseEntity<StudentsDto> createStudents(@RequestBody StudentsDto studentsDto){
        StudentsDto savedStudents = studentsservice.createStudents(studentsDto);
        return new ResponseEntity<>(savedStudents, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<StudentsDto> getStudentsById(@PathVariable("id") Long studentsId) {
        StudentsDto studentsDto = studentsservice.getStudentsById(studentsId);
        return ResponseEntity.ok(studentsDto);
    }

    // Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<StudentsDto>> getAllStudents(){
        List<StudentsDto> students = studentsservice.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Build Students REST API
    @PutMapping("{id}")
    public ResponseEntity<StudentsDto> updateStudents(@PathVariable("id") Long studentsId,
                                                      @RequestBody StudentsDto updateStudents){
        StudentsDto studentsDto = studentsservice.updateStudents(studentsId, updateStudents);
        return ResponseEntity.ok(studentsDto);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudents(@PathVariable("id") Long studentsId){
        studentsservice.deleteStudents(studentsId);
        return ResponseEntity.ok("Student deleted successfully!");

    }
}
