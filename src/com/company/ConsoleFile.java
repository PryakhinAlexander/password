package com.company;

import java.io.*;

public class ConsoleFile {
    private static String PATH = "/Users/alexandrpryakhin/passwordGenerator.txt";

    public static void deleteContentFile() {
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}

    }

    public static void toWrite(){
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        try {
            System.out.println("Enter password...");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String content = bufferedReader.readLine();
            fileWriter = new FileWriter(PATH, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            System.out.println("...Ready");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void toRead(){
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));
            String currentLine;
            while((currentLine = bufferedReader.readLine())!=null){
                System.out.println("file read: " +currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
                if(fileReader!=null){
                    fileReader.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
