package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Test
    public void shouldCreateStudent() throws Exception {
        Student student = new Student();
        student.setEmail("test@gmail.com");
		Student after = this.service.create(student);
		assertEquals(2,after.getId());
    }

}