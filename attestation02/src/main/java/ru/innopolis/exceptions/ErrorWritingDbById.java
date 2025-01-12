package ru.innopolis.exceptions;

import org.springframework.dao.DuplicateKeyException;

public class ErrorWritingDbById extends Exception{

    public ErrorWritingDbById(String s){

        super(s);

    }

}
