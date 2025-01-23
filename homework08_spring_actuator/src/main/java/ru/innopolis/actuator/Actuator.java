package ru.innopolis.actuator;

import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.innopolis.repository.OrderRepository;

@Component
public class Actuator {

    @Bean
    public MeterBinder binder(OrderRepository orderRepository){
        return meterRegistry -> meterRegistry.gauge("Bla-bla-bla--->>>>>>>>>", orderRepository.getCountOrders());
    }

}
