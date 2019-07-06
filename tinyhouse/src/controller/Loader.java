package controller;

import model.Aplikacija;

import java.io.*;

public class Loader {

    public static String path = "./data.thd";

    public static void load(){
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Aplikacija.setInstance((Aplikacija) in.readObject());
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.err.println("Neuspešno učitavanje");
            System.err.println(i.getMessage());
            return;
        } catch (ClassNotFoundException c) {
            System.err.println("Nije pronađena klasa");
            return;
        }
    }

    public static void save(){
        Aplikacija a = Aplikacija.getInstance();
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(a);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            System.err.println("Neuspešno čuvanje");
            System.err.println(i.getMessage());
        }
    }
}
