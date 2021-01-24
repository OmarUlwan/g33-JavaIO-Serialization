package se.lexicon.omar.model;

import java.io.*;
import java.util.List;

public class ClassWrite {

    // 1. In Java create a method that write in a String in file.
    public void fileWrite(File file, String string) {
        try (FileWriter fw = new FileWriter(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw.write(string);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //3. Create a method that write each String object from the collection into a textfile.
    public void coWrite(File file, List<String> stringArray) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            for (String toWrite : stringArray){
                br.write(toWrite);
                br.newLine();
            }
            br.flush();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //4. Create a method that can copy a file using both BufferedInputStream and BufferedOutputStream.
    public void bufferedCopy(File source, File destination){
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream(destination))){
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead=bis.read(buffer))>0){
                bos.write(buffer,0,bytesRead);
                bos.flush();
            }
            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
