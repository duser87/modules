package org.attestation_final.services;

public interface IKafkaProducer {
    void sendMessage(String str);
}
