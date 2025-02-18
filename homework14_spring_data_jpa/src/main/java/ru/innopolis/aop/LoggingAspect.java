package ru.innopolis.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

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
    public void logMethodeStartedTimeNow(JoinPoint joinPoint){
        timeNow = Instant.now();
        log.info(" >>> Начало выполнения метода: {}, время: {}", joinPoint.toString(), timeNow);
    }

    @Profile("prod")
    @After("logPointcut()")
    public void logMethodeFinishTimeNow(JoinPoint joinPoint){
        timeEnd = Instant.now();
        log.info(" >>> Окончание выполнения метода: {}, время: {}", joinPoint.toString(), timeEnd);
        Duration timeResult = Duration.between(timeNow, timeEnd);
        log.info(" >>> Время выполнение метода: {}ms", timeResult.toMillis());
    }

    @Profile("debug")
    @After("logPoint()")
    public void loggerDebug(JoinPoint joinPoint){
        log.debug(" -> Вызов метода: {}", joinPoint.toString());
    }
}
