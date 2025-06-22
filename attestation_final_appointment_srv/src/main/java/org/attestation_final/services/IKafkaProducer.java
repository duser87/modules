package org.attestation_final.services;

/**
 * Интерфейс, реализующий метод отправки сообщения в топик брокера сообщений
 */
public interface IKafkaProducer {
    void sendMessage(String str);
}
