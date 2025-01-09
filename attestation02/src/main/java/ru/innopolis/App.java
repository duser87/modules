package ru.innopolis;

import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Appointment;
import ru.innopolis.repository.AppointmentRepository;
import ru.innopolis.repository.implementation.AppointmentRepoImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class App {

    static AppointmentRepository appointmentRepository = new AppointmentRepoImpl();

    public static void main(String[] args){


//        Optional<Appointment> app = appointmentRepository.findById(5L);
//
//        if(app.isPresent()){
//
//            System.out.println("Объект - " + app.getClass().toString() + " не пустой");
//
//        }
//        else{
//
//            throw new Exception(app.orElseThrow());
//
//        }
//
//        String s = appointmentRepository.update(7L, "Иванова Инна Ивановна", "Сидоров Сидор Сидорович", "20.01.2025", "qqqq");
//
//        System.out.println(s);


//        try{
//
//            String result = appointmentRepository.deleteById(8L);
//
//            System.out.println(result);
//
//        }
//        catch (Exception e){
//
//            System.out.println(e.toString());
//
//        }

  //      System.out.println(appointmentRepository.countByNameDoc(1L));

        try {

            // Создание записив таблице Appointments

           /* appointmentRepository.create(9L, "Иванова Инна Ивановна", "Сидоров Сидор Сидорович", "11.01.2025", "qqqq"); */

            // Получение объект Appointment по ID

           /* Optional<Appointment> app = appointmentRepository.findById(51L);

            System.out.println(app.orElseThrow(() -> new NoRecordRowDB("-!- Объект с заданым ID не существует"))); */

            // Получить список всех записей таблицы Appointments

           /* System.out.println(appointmentRepository.findAll()); */

            // Обновление данных в таблице Appointments

           System.out.println(appointmentRepository.update(9L, "Иванова Инна Ивановна", "Сидоров Сидор Сидорович", "19.01.2025", "qqqq"));


           // Удаление записи в таблице Appointments по ID

            //System.out.println(appointmentRepository.deleteById(19L));

            // Получение количества записей в таблице Appointments по ID врача

            //System.out.println(appointmentRepository.countByNameDoc(1L));

        }
//        catch (NoRecordRowDB ex){
//
//            System.out.println(ex);
//
//        }
//        catch (ErrorWritingDbById /*| NoRecordRowDB*/ ex){
//
//            System.out.println(ex.getMessage());
//
//        }
        catch (IllegalArgumentException ex){

            System.out.println(ex);

        }


    }
}