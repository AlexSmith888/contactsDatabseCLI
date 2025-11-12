import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
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
                String[] arr = line.split(" ");
                contacts.put(arr[0], arr[1]);
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
            Files.writeString(database, pair.getKey() + " " + pair.getValue());
        }

        IO.println("Successfully flushed ... ");
    }
}
