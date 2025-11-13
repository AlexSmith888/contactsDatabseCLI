package own.nio.core;

import own.nio.utilities.Validation;

import java.util.HashMap;

public class ContactRemoval implements Command{
    @Override
    public void fulfill(String[] args, HashMap<String, String> database) throws IllegalArgumentException {

        String command = args[0].trim();

        if (Commands.DELETE.getCommand().equals(command)) {
            String key = args[1].trim();
            if (!database.containsKey(key)) {
                IO.println("The contact does not exist or is incorrect");
                return;
            }
            database.remove(key);
            System.out.format("%s Successfully removed from the database", key);;
            IO.println("\n");;
        }
    }
}
