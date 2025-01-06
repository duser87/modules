package ru.innopolis;


import ru.innopolis.entity.WorkFiles;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        String[] reader = WorkFiles.readFileStream("input.txt");


        // 1 Часть
        // A

        List<Integer> intList  = new ArrayList<>();

        List<Integer> uniqueIntList  = new ArrayList<>();

        // B

        for (String s: reader){
            intList.add(Integer.parseInt(s));
        }

        WorkFiles.writeFileStream("output.txt", String.valueOf(intList));

        System.out.println(intList);

        // C

        Collections.sort(intList);

        WorkFiles.writeFileStream("output.txt", String.valueOf(intList));

        System.out.println(intList);

        // D

        Collections.reverse(intList);

        WorkFiles.writeFileStream("output.txt", String.valueOf(intList));

        System.out.println(intList);

        // E

        Collections.shuffle(intList);

        WorkFiles.writeFileStream("output.txt", String.valueOf(intList));

        System.out.println(intList);

        // F

        intList.addFirst(71);

        WorkFiles.writeFileStream("output.txt", String.valueOf(intList));

        System.out.println(intList);

        // H

        for(Integer i: intList){

            if(Collections.frequency(intList, i) > 1){

                uniqueIntList.add(i);

            }

        }

        WorkFiles.writeFileStream("output.txt", String.valueOf(uniqueIntList));

        System.out.println(uniqueIntList);

        // G

        HashSet<Integer> hashInt = new HashSet<>(intList);

        intList.clear();

        intList.addAll(hashInt);

        WorkFiles.writeFileStream("output.txt", String.valueOf(intList));

        System.out.println(intList);

        // I

        int[] intArr = intList.stream().mapToInt(i -> i).toArray();

        WorkFiles.writeFileStream("output.txt", Arrays.toString(intArr));

        System.out.println(Arrays.toString(intArr));

        // Часть 2
        // A

        String[] readerHash = WorkFiles.readFileStream("input2.txt");

        HashSet<String> hsReader = new HashSet<>(Arrays.asList(readerHash));

        // B

        hsReader.add("но, ");
        hsReader.add("солнце, ");
        hsReader.add("светило, ");
        hsReader.add("очень, ");
        hsReader.add("ярко");

        // C

        for(String s: hsReader){

            System.out.println(s);

        }

        // D

        hsReader.add("солнце, ");

        System.out.println(hsReader);

        // E

        boolean result = hsReader.contains("светило, ");

        System.out.println(result);

        // F

        hsReader.remove("светило, ");

        System.out.println(hsReader);

        // G

        int hsSize = hsReader.size();

        System.out.println(hsSize);

        // H

        hsReader.clear();

        System.out.println(hsReader);

        // I

        System.out.println(hsReader.isEmpty());



    }
}