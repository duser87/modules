package ru.innopolis;


import ru.innopolis.utils.WorkFiles;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        String[] arrStr = WorkFiles.readFileStream("/app/output.txt");

        List<String> listKey = new ArrayList<>();

        Map<String, String> mapStr = new HashMap<String, String>();

        System.out.println(Arrays.toString(arrStr));

        WorkFiles.writeFileStream("/app/input.txt", String.valueOf(Arrays.toString(arrStr)));

        for(int i=0; i<=arrStr.length-1; i++){

            String[] s = arrStr[i].split(":");

            mapStr.put(s[0], s[1]);

        }

        WorkFiles.writeFileStream("/app/input.txt", String.valueOf(mapStr));

        mapStr.forEach((key, value) -> { System.out.println(key + ":" + value); });

        System.out.println(mapStr);

        // B

        mapStr.put("4", "string4");
        mapStr.put("5", "string5");
        mapStr.put("6", "string6");
        mapStr.put("7", "string7");
        mapStr.put("1", "string1");

        WorkFiles.writeFileStream("/app/input.txt", String.valueOf(mapStr));

        // C

        for(Map.Entry<String, String> entry : mapStr.entrySet()){

            System.out.println(entry.getKey() + ":" + entry.getValue());

        }

        // D

        mapStr.put("7", "NEWstring7");

        WorkFiles.writeFileStream("/app/input.txt", String.valueOf(mapStr));

        // E

        for(Map.Entry<String, String> entry : mapStr.entrySet()){

            listKey.add(entry.getKey());

        }

        WorkFiles.writeFileStream("/app/input.txt", String.valueOf(listKey));

        // F

        Set<Map.Entry<String, String>> setColl = mapStr.entrySet();

        System.out.println(setColl);

        WorkFiles.writeFileStream("/app/input.txt", String.valueOf(setColl));

        // G

        System.out.println(mapStr.containsKey("4"));

        // H

        System.out.println(mapStr.containsValue("string5"));

        // I

        System.out.println(mapStr.size());

        // J

        mapStr.remove("5");

        System.out.println(mapStr);

        System.out.println(mapStr);

        WorkFiles.writeFileStream("/app/input.txt", String.valueOf(mapStr));

    }
}