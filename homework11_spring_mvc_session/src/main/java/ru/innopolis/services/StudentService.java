package ru.innopolis.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.ListRecordsStudentCourses;
import ru.innopolis.dto.StudentRequest;
import ru.innopolis.dto.StudentResponse;
import ru.innopolis.models.Course;
import ru.innopolis.models.ListCourses;
import ru.innopolis.models.Student;
import ru.innopolis.repositories.CourseRepository;
import ru.innopolis.repositories.ListCoursesRepository;
import ru.innopolis.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ListCoursesRepository listCoursesRepository;

    public Student create(Student student, HttpSession session){
        Student std = new Student();
        Object obj = session.getAttribute("STUDENT_REG");
        Long resultId = studentRepository.findId(student.getFio()).orElse(0L);
        System.out.println(resultId);

        if(resultId == 0L){
            session.setAttribute("STUDENT_REG", student.getEmail() );
            Long id = studentRepository.findMaxId();
            studentRepository.create(id + 1L, student.getFio(), student.getEmail());
            std.setFio(student.getFio() + " ---> пользователь создан и авторизирован!");
        }
        else{
            std.setFio(student.getFio() + " ---> такой пользователь уже зарегистрированы.");
        }

        std.setEmail(student.getEmail());
        return std;
    }

    public Student update(Student student, HttpSession session){
        Long id = studentRepository.findMaxId();
        studentRepository.update(id + 1L, student.getFio(), student.getEmail());
        Optional<Student> result = studentRepository.findByFio(student.getFio());
        session.setAttribute("STUDENT_REG", student.getEmail());
        return result.orElseThrow();
    }

    public String delete(Long id, HttpSession session){
        session.invalidate();
        listCoursesRepository.delete(id);
        studentRepository.delete(id);
        return "Запись с ID=" + id + " удалена!";
    }

    public Student findByFio(String fio){
        return studentRepository.findByFio(fio).orElseThrow();
    }

    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow();
    }


    public StudentResponse recordOnCourse(StudentRequest request, HttpSession session) {

        StudentResponse response = new StudentResponse();
        List<ListCourses> result = listCoursesRepository.findListCourses(request.getId_student());
        Student student = studentRepository.findById(request.getId_student()).orElseThrow();
        Course course = courseRepository.findById(request.getId_course()).orElseThrow();
        Long id = listCoursesRepository.findMaxId();
        response.setFio(student.getFio());
        response.setCourse(course.getName());

        Object obj = session.getAttribute("STUDENT_REG");
        if((obj != student.getEmail()) & (obj == null)) {
            response.setMessage(" ---> Что бы записаться на курс нужна авторизация!");
        }
        else {
            boolean resultRecord = result.stream().anyMatch(p -> p.getId_course().equals(request.getId_course()));
            if (!resultRecord){
                listCoursesRepository.create(id + 1L, request.getId_student(), request.getId_course());
                response.setMessage(" ---> Запись прошла успешно!");
            }
            else {
                response.setMessage(" ---> пользователь уже записаны на данный курс! Выберите другое направление!");
            }
        }
        return response;
    }

    public ListRecordsStudentCourses getListStudentCourses(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        List<ListCourses> listCourses = listCoursesRepository.findListCourses(id);
        ListRecordsStudentCourses studentCourses = new ListRecordsStudentCourses();
        studentCourses.setFio(student.getFio());
        String[] list = new String[listCourses.size()];

        for(int i=0; i<listCourses.size(); i++){
            var nameCourse = courseRepository.findById(listCourses.get(i).getId_course());
            list[i] = nameCourse.get().getName();
        }

        studentCourses.setListCourses(list);
        return studentCourses;
    }

    public StudentResponse authorizationStudent(Long id, HttpSession session){
        StudentResponse response = new StudentResponse();
        Student student = studentRepository.findById(id).orElseThrow();
        session.setAttribute("STUDENT_REG", student.getEmail());
        response.setFio(student.getFio());
        response.setCourse("");
        response.setMessage(" ---> Авторизован!");
        return response;
    }


}
