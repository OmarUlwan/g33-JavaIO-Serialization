package se.lexicon.omar;

import se.lexicon.omar.model.*;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ClassWrite fw = new ClassWrite();
        ClassRead fr = new ClassRead();
        Serializing ser = new Serializing();
        JsonIO jIO = new JsonIO();

        // 1. Create a text file (.txt) and fill it with some text content.
        System.out.println("Practice 1. ========================================");
        File practice1 = new File("./src/main/java/se/lexicon/omar/files/Practice-1.txt");
        String string = "Hello World!\nJava I/O: FileWriter.\nJava I/O: FileReader.";
        fw.fileWrite(practice1, string);
        System.out.println("Successful operation");

        // a. Read in a String from file.
        System.out.println("Practice 1.a. ========================================");
        String s1 = fr.fileReader(practice1);
        System.out.println(s1);

        // 2. Create a text file (.txt) and fill it with lines of names.
        System.out.println("Practice 2. ========================================");
        File practice2 = new File("./src/main/java/se/lexicon/omar/files/Practice-2.txt");
        String namesString = "Simon.\nLexicon.\nOmar.";
        fw.fileWrite(practice2, namesString);
        System.out.println("Successful operation");

        //2.a. Read in the lines.
        System.out.println("Practice 2.a. ========================================");
        for (String s2 : fr.BReader(practice2)) {
            System.out.println(s2);
        }

        //3. In Java create a Collection that contains at least five String objects.
        System.out.println("Practice 3. & 3.a. ========================================");
        File practice3 = new File("./src/main/java/se/lexicon/omar/files/Practice-3.txt");
        List<String> stringArray = Arrays.asList("The beginning",
                "Inside us there is something that has no name, that something is what we are.",
                "The sky, at sunset, looked like a flower.",
                "Sea and sky were a single thing.",
                "The sands of the beach, which on nights glimmered like powered light.",
                "The End.");

        //3.a. Write each String object from the collection into a text file.
        fw.coWrite(practice3, stringArray);

        System.out.println("Successful operation");

        //4. Copy a file using both BufferedInputStream and BufferedOutputStream.
        System.out.println("Practice 4. ========================================");
        File sourcePractice4 = new File("./src/main/java/se/lexicon/omar/files/Practice-3.txt");
        File destinationPractice4 = new File("./src/main/java/se/lexicon/omar/files/Practice-4.txt");
        fw.bufferedCopy(sourcePractice4, destinationPractice4);
        System.out.println("Successful operation");

        //5.a. Create a List of Cars and add some objects into it.
        System.out.println("Practice 5.a && 5.b. ========================================");
        List<Car> cars = Arrays.asList(new Car("AbC123", "Audi", "A6", LocalDate.parse("2011-01-01"), "Simon"),
                new Car("BXX334", "BMW", "X5", LocalDate.parse("2019-05-01"), "Lexicon"));

        //5.b. Save the List of Cars to a file using ObjectOutputStream.
        File practice5 = new File("./src/main/java/se/lexicon/omar/files/Practice-5.ser");
        ser.saveList(practice5, cars);
        System.out.println("Successful operation");

        //5.c.Read the List of Cars from file using ObjectInputStream.
        System.out.println("Practice 5.c ========================================");
        List<Car> printCars = ser.readSerFile(practice5);
        for (Car car : printCars) {
            System.out.println("Car ID: " + car.getCarID() + "\nBrand: " + car.getBrand()
                    + "\nModel: " + car.getModel() + "\nRegNumber: " + car.getRegNumber() + "\nDate: " + car.getRegDate()
                    + "\nOwner: " + car.getOwner());
        }

        //6.D. Create two collections, one for Cars and the other for Owners.
        List<Car> collectionCars = Arrays.asList(
                new Car("FFF333", "Audi", "A4", LocalDate.parse("2017-12-01"), "Kimi Eklund"),
                new Car("CCC999", "Volvo", "V40", LocalDate.parse("2019-01-01"), "Xander Ekström"),
                new Car("DDD777", "Volvo", "V80", LocalDate.parse("2020-09-01"), "Filiph Lundberg")
        );
        List<Owner> collectionOwner = Arrays.asList(
                new Owner(1,"Kimi Eklund", LocalDate.parse("1990-01-01")),
                new Owner(2, "Xander Ekström", LocalDate.parse("1977-05-01")),
                new Owner(3, "Filiph Lundberg", LocalDate.parse("1987-09-01"))
        );

        //6.e. Create functionality to serialize the collections to JSON files.
        System.out.println("Practice 6.e. ========================================");
        File practice6Car = new File("./src/main/java/se/lexicon/omar/files/Practice-6-collectionCars.json");
        File practice6Owner = new File("./src/main/java/se/lexicon/omar/files/Practice-6-collectionOwners.json");
        jIO.serializeToJson(practice6Car,collectionCars);
        jIO.serializeToJson(practice6Owner,collectionOwner);
        System.out.println("Successful operation");

        //6.f. Create functionality to deserialize the JSON files to it’s resepective Collection.
        System.out.println("Practice 6.f. ========================================");
        List<Car> deserializedCars = jIO.deserializeCars(practice6Car);
        List<Owner> deserializedOwner = jIO.deserializeOwner(practice6Owner);
        System.out.println("Print Cars List. 6.f. ========================================");
        for (Car car : deserializedCars) {
            System.out.println("Car ID: " + car.getCarID() + "\nBrand: " + car.getBrand()
                    + "\nModel: " + car.getModel() + "\nRegNumber: " + car.getRegNumber() + "\nDate: " + car.getRegDate()
                    + "\nOwner: " + car.getOwner());
        }
        System.out.println("Print Owner List. 6.f. ========================================");
        for (Owner owner : deserializedOwner) {
            System.out.println("Owner ID: " + owner.getOwnerID() + "\nName: " + owner.getName()
                    + "\nBirthday: " + owner.getBirthdate());
        }
    }

}
