package com.company;

import java.io.*;

    public class Main {
        private static String path1 = "/Users/alexandrpryakhin/passwordGenerator.txt";
        private static String path2 = "/Users/alexandrpryakhin/Desktop/writeFile.txt";

        public static void main(String[] args) throws IOException {

            InternalFile.createFile();
            while (true) {
                ConsoleFile.toWrite();
                ConsoleFile.toRead();
                String res1 = usingBufferedReader(path1);
                String res2 = usingBufferedReader(path2);

                if (res1.equals(res2)) {
                    System.out.println("password is true");
                    System.out.println("Console password: " + res1);
                    System.out.println("Internal password: " + res2);
                    ConsoleFile.deleteContentFile();
                    break;
                }
                System.out.println("password is false");
                System.out.println("Console password: " + res1);
                System.out.println("Internal password: " + res2);
                ConsoleFile.deleteContentFile();

            }

        }

        private static String usingBufferedReader(String filePath) {
            StringBuilder contentBuilder = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    contentBuilder.append(sCurrentLine).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return contentBuilder.toString();
        }
    }

