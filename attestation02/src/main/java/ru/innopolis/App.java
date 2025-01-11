package ru.innopolis;

import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Appointment;
import ru.innopolis.repository.AppointmentRepository;
import ru.innopolis.repository.implementation.AppointmentRepoImpl;
import java.util.Optional;

public class App {

    static AppointmentRepository appointmentRepository = new AppointmentRepoImpl();

    public static void main(String[] args){

        try {

            // Создание записи в таблице Appointments

            appointmentRepository.create(11L, "Иванова Инна Ивановна", "Сидоров Сидор Сидорович", "11.01.2025", "qqqq");

            // Получение объект Appointment по ID

            Optional<Appointment> app = appointmentRepository.findById(110L);

            System.out.println(app.orElseThrow(() -> new NoRecordRowDB("-!- Объект с заданым ID не существует")));

            // Получить список всех записей таблицы Appointments

            System.out.println(appointmentRepository.findAll());

            // Обновление данных в таблице Appointments

            System.out.println(appointmentRepository.update(11L, 23, "Сидоров Сидор Сидорович", "19.01.2025", "qqqq"));

           // Удаление записи в таблице Appointments по ID

            System.out.println(appointmentRepository.deleteById(358L));

            // Получение количества записей в таблице Appointments по ID врача

            System.out.println(appointmentRepository.countByNameDoc(1L));

            // Удаление всех записей в таблице Appointments

            appointmentRepository.deleteAll();

        }
        catch (NoRecordRowDB | IllegalArgumentException | ErrorWritingDbById ex){

            System.out.println(ex.getMessage());

        }


    }
}