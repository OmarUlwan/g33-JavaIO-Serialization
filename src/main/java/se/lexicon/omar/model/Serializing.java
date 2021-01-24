package se.lexicon.omar.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Serializing {

    //5.b. Save the List of Cars to a file using ObjectOutputStream.
    public void saveList(File file, List<Car> list) {
        try (ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(file))) {
            oops.writeObject(list);
            oops.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //5.c. Read the List of Cars from file using ObjectInputStream.
    public List<Car> readSerFile(File file) {
        List<Car> serCars = new ArrayList<>();
        try (ObjectInputStream oips = new ObjectInputStream(new FileInputStream(file))) {
            serCars = (List<Car>) oips.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return serCars;
    }
}
