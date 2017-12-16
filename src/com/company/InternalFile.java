package com.company;

import java.io.*;

public class InternalFile {

    public static void createFile() throws IOException {

        InputStream inputStream = InternalFile.class.getResourceAsStream("/password.txt");
        getFileContent(inputStream);
    }

    public static void getFileContent(InputStream inputStream) throws IOException {

        byte[] buffer = new byte[1024];
        String filename = "writeFile.txt";
        File directory = new File("/Users/alexandrpryakhin/Desktop");
        if (!directory.exists()) {
            directory.mkdir();
        }
        File file = new File(directory, filename);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for (int len; (len = inputStream.read(buffer)) != -1; ) {
            fileOutputStream.write(buffer, 0, len);
        }

        inputStream.close();
        fileOutputStream.close();
    }
}