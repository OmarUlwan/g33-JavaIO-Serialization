package se.lexicon.omar.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRead {

    //1.a. In Java create a method that read in a String from file and return the String using FileReader.
    public String fileReader(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fr = new FileReader(file)){
            int i;
            while ((i=fr.read())!=-1){
                char letter=(char) i;
                stringBuilder.append(letter);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /* In Java create a method that read in the lines into a Collection using BufferedReader.
     One line for each element in the Collection.*/
    public List<String> BReader(File file){
        List<String> strings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line=br.readLine())!=null){
                strings.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings;
    }

}
