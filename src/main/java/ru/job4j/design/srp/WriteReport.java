package ru.job4j.design.srp;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WriteReport implements Write {
    private PrintWriter printWriter;
    private String file;

    public WriteReport(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    @Override
    public void write(String str, String file) {
        try {
            printWriter = new PrintWriter(file, "UTF-8");
            printWriter.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}