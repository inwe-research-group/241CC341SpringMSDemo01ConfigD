package uni.isw.ms.student.service;

import uni.isw.ms.student.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    List<Student> findByCourseId(Long courseId);
}
