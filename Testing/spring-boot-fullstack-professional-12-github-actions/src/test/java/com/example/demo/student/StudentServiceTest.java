package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
@Mock
    private StudentRepository studentRepository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {

        underTest = new StudentService(studentRepository);
    }

    @Test
    void getAllStudents() {
        //when
        underTest.getAllStudents();
        //then
        verify(studentRepository).findAll();
    }

    @Test
    void canAddStudent() {
        //given
        String email = "cole@gmail.com";
        Student student = new Student(
                "Cole",
                email,
                Gender.FEMALE
        );

        //when
        underTest.addStudent(student);

        //then
        ArgumentCaptor<Student> studentArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);

        verify(studentRepository)
                .save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(student);
    }
    @Test
    void willThrowWhenEmailIsTaken() {
        //given
        String email = "cole@gmail.com";
        Student student = new Student(
                "Cole",
                email,
                Gender.FEMALE
        );
        given(studentRepository.selectExistsEmail(student.getEmail()))
                .willReturn(true);

        //when
        //then
        assertThatThrownBy(() ->underTest.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");

        verify(studentRepository,never()).save(any());

    }

    @Test
    @Disabled
    void deleteStudent() {
        //given
        Student student = new Student(
                1L,
                "Cole",
                "cole@gmail.com",
                Gender.FEMALE
        );
        List<Student> studentList = underTest.getAllStudents();
        underTest.deleteStudent(student.getId());
        System.out.println(student.getId());
        //when

        //then
        ArgumentCaptor<Student> studentArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);

        verify(studentRepository)
                .delete(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        verify(capturedStudent).getId().;
    }
}