package ru.innopolis.utils;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class WorkFiles{

    static public String[] readFileStream(String path){

        String str;
        String[]  arrStr;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            str = bufferedReader.readLine();

            arrStr = str.split(", ");

        }
        catch (IOException e){

            throw new RuntimeException(e);

        }

        return arrStr;

    }


    static public void writeFileStream(String pathFile, String str){

        try (FileWriter writer =  new FileWriter(pathFile, true)){

            writer.write(str);
            writer.append('\n');

            writer.flush();

        }
        catch (IOException e){

            throw new RuntimeException(e);

        }

    }

}
