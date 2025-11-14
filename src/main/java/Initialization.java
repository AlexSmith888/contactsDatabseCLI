import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;

public class Initialization {
    public static HashMap<String, String> launch (
            HashMap<String, String> contacts, Path path) {
        IO.println("Loading database into main memory ... ");
        try {
            List<String> lines = Files.readAllLines(path);
            for (var line : lines) {
                if (line.isBlank()) {
                    continue;
                }
                String[] arr = line.split(" ");
                StringBuffer name = new StringBuffer();
                for (int i = 0; i < arr.length - 1; i++) {
                    name.append(arr[i]);
                    name.append(" ");
                }
                contacts.put(name.toString().trim(), arr[arr.length - 1]);
            }
        } catch (IOException e) {
            IO.println("Failed to load the database ... ");
            IO.println("Exiting ... ");
            System.exit(-1);
        }

        IO.println("Load completed ... ");
        return contacts;
    }
    public static void shutDown (HashMap<String, String> mapa, Path database) throws IOException {
        IO.println("Flushing data on the disk ... ");

        Files.delete(database);
        Files.createFile(database);

        for (var pair : mapa.entrySet()) {
            Files.writeString(database, pair.getKey()
                    + " " + pair.getValue(), StandardOpenOption.APPEND);
            Files.writeString(database,"\n", StandardOpenOption.APPEND);
        }

        IO.println("Successfully flushed ... ");
    }
    public static void showRules(){
        System.out.println("\n");
        System.out.println("It is necessary to use double quotes for names : ");
        System.out.println("It is necessary not to use whitespaces for numbers");
        System.out.println(" \"John Dow\" \" Spider-Man\" ");
        System.out.println("Empty lines are treated as a word delimiter, be careful");
        System.out.println("Use \"add\" to add a new contact");
        System.out.println("Use \"del\" to remove a contact");
        System.out.println("Use \"upd\" to change a " +
                "contact {existing contact - new telephone number}");
        System.out.println("Use \"list\" to list all contacts");
        System.out.println("Use \"get\" to retrieve information about a contact");
        System.out.println("Example : add \"John Dow\" 999-000-444");
        System.out.print('>');
    }
}
