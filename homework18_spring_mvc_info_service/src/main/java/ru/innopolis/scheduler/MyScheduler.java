package ru.innopolis.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.innopolis.clients.InfoClient;
import ru.innopolis.clients.InfoStudentClient;
import ru.innopolis.mail.MyMailSender;
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
                    log.info(students.get(i).getFio() + " уведомление о курсе/ах " + listNoActivityCourse);
                }
            }
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
    }

}
