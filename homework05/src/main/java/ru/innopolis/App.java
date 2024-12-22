package ru.innopolis;

import lombok.*;
import ru.innopolis.figure.Circle;
import ru.innopolis.figure.Ellipse;
import ru.innopolis.figure.Square;
import ru.innopolis.figure.Rectangle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

@Data
public class App {

    private Ellipse ellipse;
    private Rectangle rectangle;
    private Circle circle;
    private Square square;

    App(Ellipse ellipse, Rectangle rectangle, Circle circle, Square square){

        this.ellipse = ellipse;
        this.rectangle = rectangle;
        this.circle = circle;
        this.square = square;

    }

    public void fileWrite(String str){

        try{

            FileWriter fileWriter = new FileWriter(str);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(ellipse.toString());
            bufferedWriter.newLine();

            bufferedWriter.write(rectangle.toString());
            bufferedWriter.newLine();

            bufferedWriter.write(circle.toString());
            bufferedWriter.newLine();

            bufferedWriter.write(square.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();


        }
        catch (Exception e){

            throw new RuntimeException(e);

        }

    }

    public String fileRead(String str){

        String line;

        try{

            FileReader fileReader = new FileReader(str);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null){

                System.out.println(line);


            }

            bufferedReader.close();
            fileReader.close();

            return line;

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }






}
