package ru.innopolis;


import ru.innopolis.repository.AppointmentRepository;
import ru.innopolis.repository.DoctorRepository;
import ru.innopolis.repository.PatientRepository;
import ru.innopolis.repository.PositionRepository;
import ru.innopolis.repository.impl.AppointmentRepoImpl;
import ru.innopolis.repository.impl.DoctorRepoImpl;
import ru.innopolis.repository.impl.PatientRepoImpl;
import ru.innopolis.repository.impl.PositionRepoImpl;

public class Main {

    private static final PatientRepository patientRepository = new PatientRepoImpl();

    private static final DoctorRepository doctorRepository = new DoctorRepoImpl();

    private static final AppointmentRepository appointmentRepository = new AppointmentRepoImpl();

    private static final PositionRepository positionRepository = new PositionRepoImpl();

    public static void main(String[] args) {

        // Для таблицы Positions

        System.out.println(positionRepository.allFind());

        positionRepository.update(1L, "Врач-андролог");

        positionRepository.addPos(6L, "Врач-нефролог");

        System.out.println(positionRepository.allFind());

        positionRepository.delete("Врач-нефролог");

        System.out.println(positionRepository.allFind());



    }
}