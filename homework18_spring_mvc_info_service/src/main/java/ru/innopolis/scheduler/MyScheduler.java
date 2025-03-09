package ru.innopolis.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.innopolis.clients.InfoClient;
import ru.innopolis.clients.InfoStudentClient;
import ru.innopolis.dto.CourseResponse;
import ru.innopolis.dto.ListCoursesStudentResponse;
import ru.innopolis.mail.MyMailSender;
import ru.innopolis.models.InfoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class MyScheduler {

    @Autowired
    MyMailSender mailSender;
    @Autowired
    InfoClient infoClient;
    @Autowired
    InfoStudentClient studentClient;

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void printMessage(){
        log.info("Zdarova, drugi");
        List<InfoEntity> listInfo = new ArrayList<>();
        try{
            var courses = infoClient.getListCourses();
            var students = studentClient.getListStudent();
            var listCourses = studentClient.getListCoursesStudent();

            log.info(courses.toString());
            log.info(students.toString());
            log.info(listCourses.toString());

            var listNoActivityCourse = courses.stream().filter( x-> x.getActivity().equals(false)).toList();
            if(!listNoActivityCourse.isEmpty()){
                for(int i=0; i<students.size(); i++){
                    SimpleMailMessage mailMessage = new SimpleMailMessage();
                    mailMessage.setTo("duser87@yandex.ru");
                    mailMessage.setText(listNoActivityCourse.toString());
                    mailMessage.setSubject("Не активные курсы");
                    mailSender.send(mailMessage);
                }
            }
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
        log.info("----> scheduler");
    }

}
