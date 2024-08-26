package com.example.demo.service.impl;

import com.example.demo.dto.StudentsDto;
import com.example.demo.entity.Students;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.StudentsMapper;
import com.example.demo.repository.StudentsRepository;
import com.example.demo.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class StudentsServiceImpl implements StudentsService {

    private StudentsRepository studentsRepository;

    @Override
    public StudentsDto createStudents(StudentsDto studentsDto) {

        Students students = StudentsMapper.mapToDto(studentsDto);
        Students savedStudents = studentsRepository.save(students);
        return StudentsMapper.mapToStudentsDto(savedStudents);
    }

    @Override
    public StudentsDto getStudentsById(Long studentsId) {
        Students students = studentsRepository.findById(studentsId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student does not exist with given id:" + studentsId));

        return StudentsMapper.mapToStudentsDto(students);
    }

    @Override
    public List<StudentsDto> getAllStudents() {
        List <Students> students = studentsRepository.findAll();
        return students.stream().map((student) -> StudentsMapper.mapToStudentsDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentsDto updateStudents(Long studentsId, StudentsDto updatedStudents) {

        Students students = studentsRepository.findById(studentsId).orElseThrow(
                () -> new ResourceNotFoundException("Student does not exist with given Id: " + studentsId)
        );

        students.setName(updatedStudents.getName());
        students.setEmail(updatedStudents.getEmail());

        Students updatedStudentsObj = studentsRepository.save(students);

        return StudentsMapper.mapToStudentsDto(updatedStudentsObj);
    }

    @Override
    public void deleteStudents(Long studentsId) {

        Students students = studentsRepository.findById(studentsId).orElseThrow(
                () -> new ResourceNotFoundException("Student does not exist with given Id: " + studentsId)
        );

        studentsRepository.deleteById(studentsId);

    }


}
