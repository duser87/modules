package ru.innopolis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  Класс контроллера для работы с сущностью Student
 * @author Шумилов С.П.
 * @version v_1.0
 */
@SpringBootApplication
public class Main {
    /**
     * Это основной метод программы
     * @param args аргументы коммандной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}