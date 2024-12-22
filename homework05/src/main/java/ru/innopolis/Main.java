package ru.innopolis;


import ru.innopolis.figure.Circle;
import ru.innopolis.figure.Ellipse;
import ru.innopolis.figure.Rectangle;
import ru.innopolis.figure.Square;

public class Main {


    public static void main(String[] args) {


        Ellipse ellipse = new Ellipse(10.0f, 20.0f, 5.0f, 5.0f);

        Rectangle rectangle = new Rectangle(5.0f, 8.0f, 2.0f, 7.0f);

        Circle circle = new Circle(5.0f, 6.0f, 9.0f);

        Square square = new Square(12.0f, 10.0f, 8.0f);

        App app= new App(ellipse, rectangle, circle, square);

        System.out.println("Координаты Ellipse X: " + ellipse.getX());

        System.out.println("Координаты Ellipse Y: " + ellipse.getY());

        System.out.println("Координаты Circle X: " + circle.getX());

        System.out.println("Координаты Circle Y: " + circle.getY());

        app.fileWrite("/app/test.txt");

        System.out.println(app.fileRead("/app/test.txt"));

        circle.setX(11.0f);

        circle.setY(17.5f);

        app.fileWrite("/app/text.txt");

        System.out.println("Координаты Circle X: " + circle.getX());

        System.out.println("Координаты Circle Y: " + circle.getY());

    }
}