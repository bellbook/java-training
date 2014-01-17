package ch01.ex01_16;

import java.io.IOException;

@SuppressWarnings("serial")
public class BadDataSetException extends Exception {

    public String name;
    public IOException e = new IOException();

}
