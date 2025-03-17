package ru.innopolis.functional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.innopolis.kafka.KafkaProducer;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaHandler {
    private final KafkaProducer produser;

    public Mono<ServerResponse> sendMessageToKafka(ServerRequest serverRequest){
        var count = Integer.valueOf(serverRequest
                .queryParam("count")
                .orElse("10"));

        return produser.sendMessage(count).then().flatMap(x -> ServerResponse.ok().body(Mono.just("Отправлено сообщение "), String.class));
    }
}
