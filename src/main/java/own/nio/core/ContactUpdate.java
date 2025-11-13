package own.nio.core;

import own.nio.utilities.PhoneValidation;
import own.nio.utilities.Validation;

import java.util.Arrays;
import java.util.HashMap;

public class ContactUpdate implements Command{
    @Override
    public void fulfill(String[] args, HashMap<String, String> database) throws IllegalArgumentException {

        String command = args[0].trim();

        if (Commands.UPDATE.getCommand().equals(command)) {
            String key = args[1].trim();
            String value = args[2].trim();
            if (!database.containsKey(key)) {
                IO.println("The requested contact does not exist");
                IO.println("Use \"ls\" command to figure out the name");
                return;
            }
            String previous = database.get(key);
            database.put(key, value);
            System.out.format("Has been changed from %s to %s", previous, value + "\n");
        }
    }
}
