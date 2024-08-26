package com.example.demo.service;

import com.example.demo.dto.StudentsDto;

import java.util.List;

public interface StudentsService {
    StudentsDto createStudents(StudentsDto studentsDto);

    StudentsDto getStudentsById(Long studentsId);

    List<StudentsDto> getAllStudents();

    StudentsDto updateStudents(Long studentsId, StudentsDto updatedStudents);

    void deleteStudents(Long studentsId);
}
