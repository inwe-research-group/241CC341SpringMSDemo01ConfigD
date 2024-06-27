package uni.isw.ms.course.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uni.isw.ms.course.controller.dto.StudentDTO;

@FeignClient(name = "241CC341SpringMSDemo01StudentD", url = "localhost:8090")
public interface StudentClient {
    
    @GetMapping("/api/student/search-by-course/{courseId}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long courseId);
    
}
