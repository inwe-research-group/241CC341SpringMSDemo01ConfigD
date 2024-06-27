package uni.isw.ms.course.service;

import uni.isw.ms.course.client.StudentClient;
import uni.isw.ms.course.controller.dto.StudentDTO;
import uni.isw.ms.course.model.Course;
import uni.isw.ms.course.http.response.StudentByCouseResponse;
import uni.isw.ms.course.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCouseResponse findStudentsByCourseId(Long courseId) {

        // Consultar si existe el curso
        Course course = courseRepository.findById(courseId).orElse(new Course());

        // Obtener los estudiantes
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(course.getId());

        return StudentByCouseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }

}
