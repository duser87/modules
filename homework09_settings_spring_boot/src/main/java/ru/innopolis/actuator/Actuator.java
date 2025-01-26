package ru.innopolis.actuator;

import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Actuator {
    @Bean
    public MeterBinder method1(){
        return meterRegistry -> meterRegistry.gauge("method_note_1", 1);
    }

    @Bean
    public MeterBinder method2(){
        return meterRegistry -> meterRegistry.gauge("method_note_2", 2);
    }
}
