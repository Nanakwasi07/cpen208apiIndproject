package com.example.demo.mapper;

import com.example.demo.dto.StudentsDto;
import com.example.demo.entity.Students;

public class StudentsMapper {

    public static StudentsDto mapToStudentsDto(Students students){
        return new StudentsDto(
                students.getId(),
                students.getName(),
                students.getEmail()
        );
    }

    public static Students mapToDto(StudentsDto studentsDto){
        return new Students(
                studentsDto.getId(),
                studentsDto.getName(),
                studentsDto.getEmail()

        );
    }

}
