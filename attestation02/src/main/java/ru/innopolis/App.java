package ru.innopolis;

import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Position;
import ru.innopolis.repository.AppointmentRepository;
import ru.innopolis.repository.DoctorRepository;
import ru.innopolis.repository.PatientRepository;
import ru.innopolis.repository.PositionRepository;
import ru.innopolis.repository.implementation.AppointmentRepoImpl;
import ru.innopolis.repository.implementation.DoctorRepoImpl;
import ru.innopolis.repository.implementation.PatientRepoImpl;
import ru.innopolis.repository.implementation.PositionRepoImpl;

import java.util.Optional;

public class App {

    private static final PositionRepository positionRepository = new PositionRepoImpl();
    private static final PatientRepository patientRepository = new PatientRepoImpl();
    private static final DoctorRepository doctorRepository = new DoctorRepoImpl();
    private static final AppointmentRepository appointmentRepository = new AppointmentRepoImpl();

    public static void main(String[] args){
        try {

            // Создание записи в таблице Positions

            positionRepository.create(6L, "Врач-андролог");

            // Получение объект Positions по ID

            Optional<Position> app = positionRepository.findById(6L);

            System.out.println(app.orElseThrow(() -> new NoRecordRowDB("-!- Объект с заданым ID не существует")));

            // Получить список всех записей таблицы Positions

            System.out.println(positionRepository.findAll());

            // Обновление данных в таблице Positions

            System.out.println(positionRepository.update(6L, "Врач-сурдролог"));

            // Удаление записи в таблице Positions по ID

            System.out.println(positionRepository.deleteById(6L));

            // Получение количества записей в таблице Positions

            System.out.println(positionRepository.count());

            // Удаление всех записей в таблице Positions

            //System.out.println(positionRepository.deleteAll());

        }

        catch (NoRecordRowDB | IllegalArgumentException | ErrorWritingDbById ex){

            System.out.println(ex.getMessage());

        }


    }
}