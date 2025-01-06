package ru.innopolis;


import ru.innopolis.entity.WorkFiles;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        // A

        String[] reader = WorkFiles.readFileStream("homework05.2/output.txt");

        List<Integer> intList  = new ArrayList<>();

        List<Integer> uniqueIntList  = new ArrayList<>();

        Integer[] intArr = new Integer[reader.length - 1];

        int count = reader.length - 1;

        Integer intBuff;

        // B

        for (String s: reader){
            intList.add(Integer.parseInt(s));
        }

        WorkFiles.writeFileStream("homework05.2/input.txt", String.valueOf(intList));

        System.out.println(intList);

        // C

        Collections.sort(intList);

        WorkFiles.writeFileStream("homework05.2/input.txt", String.valueOf(intList));

        System.out.println(intList);

        // D

        intList.sort(Comparator.reverseOrder());

        WorkFiles.writeFileStream("homework05.2/input.txt", String.valueOf(intList));

        System.out.println(intList);

        // E

        for(Integer i: intList){

            if(Collections.frequency(intList, i) > 1){

                uniqueIntList.add(i);

            }

        }

        System.out.println(uniqueIntList);

        WorkFiles.writeFileStream("homework05.2/input.txt", String.valueOf(uniqueIntList));


        Map<String, String> map = new HashMap<>();

        map.put("Str", "String");

        map.put("int", "int");

        if(map.containsKey("Str")){

            String newStr = (String) map.get("Str") + ", string2";

            map.put("Str", newStr);

        }

        System.out.println(map.keySet());

        map.remove("int");

        System.out.println(map.toString());


    }
}