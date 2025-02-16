package ru.innopolis.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    Instant timeNow, timeEnd;

    @Pointcut("@annotation(Log)")
    public void logPointcut(){}
    @Pointcut("@annotation(LogDebug)")
    public void logPoint(){}

    @Profile("prod")
    @Before("logPointcut()")
    public void logMethodeStartedTimeNow(){
        timeNow = Instant.now();
        System.out.println(timeNow + " - Начало выполнения метода");
    }

    @Profile("prod")
    @After("logPointcut()")
    public void logMethodeFinishTimeNow(){
        timeEnd = Instant.now();
        System.out.println(timeEnd + " - Окончание выполнения метода");
        Duration timeResult = Duration.between(timeNow, timeEnd);
        System.out.println("Время выполнение метода: " + timeResult.toMillis() + "мс");
    }

    @Profile("debug")
    @After("logPoint()")
    public void logger(JoinPoint joinPoint){
        log.info(" -> Вызов метода: {}", joinPoint.toString());
    }
}
