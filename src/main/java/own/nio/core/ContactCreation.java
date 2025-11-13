package own.nio.core;

import own.nio.utilities.PhoneValidation;
import own.nio.utilities.Validation;

import java.util.HashMap;

public class ContactCreation implements Command{
    @Override
    public void fulfill(String[] args, HashMap<String, String> database) throws IllegalArgumentException {
        String comm = args[0].trim();
        if (Commands.ADD.getCommand().equals(comm)) {
            String key = args[1].trim();
            String value = args[2].trim();

            database.put(key, value);
            System.out.format("Added %s to the database " +
                    "with the telephone number %s", key, value);
            System.out.println("\n");
        }
    }
}
