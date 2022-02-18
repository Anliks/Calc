package com.calc.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ConsoleInWriteInOut {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String consoleWrite() throws Exception {
        System.out.println("Введите ваше уравнение");
        return reader.readLine();
    }
      public void outInConsole(Double message) {
          System.out.println("Результат = " + message);
      }
}
