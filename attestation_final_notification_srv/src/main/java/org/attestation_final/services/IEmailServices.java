package org.attestation_final.services;

public interface IEmailServices {
    void send(String to, String subject, String body);
}
