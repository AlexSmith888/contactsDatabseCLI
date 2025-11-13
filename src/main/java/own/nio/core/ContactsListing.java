package own.nio.core;

import own.nio.utilities.Validation;

import java.util.HashMap;

public class ContactsListing implements Command{
    @Override
    public void fulfill(String[] args, HashMap<String, String> database)
            throws IllegalArgumentException {

        String comm = args[0].trim();

        if (Commands.LIST.getCommand().equals(comm)) {
            for (var name : database.entrySet()) {
                System.out.format("The name is %s, the telephone number is %s"
                        , name.getKey(), name.getValue());
                IO.println("\n");
            }
        }
        if (database.isEmpty()) {
            System.out.println("Nothing to Show !!! ");
        }
    }
}
