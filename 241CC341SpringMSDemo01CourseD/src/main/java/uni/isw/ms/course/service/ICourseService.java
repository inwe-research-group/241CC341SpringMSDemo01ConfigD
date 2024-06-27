package uni.isw.ms.course.service;

import uni.isw.ms.course.model.Course;
import uni.isw.ms.course.http.response.StudentByCouseResponse;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);
    StudentByCouseResponse findStudentsByCourseId(Long courseId);
}
