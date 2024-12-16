package ru.innopolis;

import ru.innopolis.repository.AppointmentRepository;
import ru.innopolis.repository.ClientRepository;
import ru.innopolis.repository.DoctorRepository;
import ru.innopolis.repository.impl.AppointmentRepositoryImpl;
import ru.innopolis.repository.impl.ClientRepositoryImpl;
import ru.innopolis.repository.impl.DoctorRepositoryImpl;

public class Main {

    private static final ClientRepository clientRepository = new ClientRepositoryImpl();

    private static final DoctorRepository doctorRepository = new DoctorRepositoryImpl();

    private static final AppointmentRepository appointmentRepository = new AppointmentRepositoryImpl();

    public static void main(String[] args) {


        // Для таблицы Doctor

        System.out.println(doctorRepository.getAll());

        doctorRepository.updateDoctor("Врач-терапевт", "+79870001245", "Мирнова Мира Мировна");

        doctorRepository.addDoctor(6L, "Врач-хирург", "+79871234578", "Иванов Иван Петрович");

        doctorRepository.deleteDoctor("Мирнова Мира Мировна");

        System.out.println(doctorRepository.getAll());


        // Для таблицы Client

        System.out.println(clientRepository.getAll());

        clientRepository.updateClient("+79870001245", "ул.Первомая, д.7", "Сидоров Сидор Сидорович");

        clientRepository.addClient(6L, "Дмитриев Дмитрий Дмитриевич", "+79871009977", "ул.Лучарского, д.4");

        clientRepository.deleteCLient("Иванов Иван Иванович");

        System.out.println(clientRepository.getAll());


        // Для таблицы Appointment

        System.out.println(appointmentRepository.getAll());

        appointmentRepository.updateAppointment("11.01.2025", "Повторный прием", "Петров Петр Петрович");

        appointmentRepository.addAppoint(6L, "Иванова Алена Ивановна", "Сидоров Сидор Сидорович", "15.01.2025", "Жалобы на здоровье");

        appointmentRepository.deleteAppoint("Иванов Сергей Сергеевич");

        System.out.println(appointmentRepository.getAll());


    }
}