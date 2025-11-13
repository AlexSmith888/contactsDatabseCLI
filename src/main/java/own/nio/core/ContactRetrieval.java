package own.nio.core;

import own.nio.utilities.Validation;

import java.util.HashMap;

public class ContactRetrieval implements Command{
    @Override
    public void fulfill(String[] args, HashMap<String, String> database)
            throws IllegalArgumentException {

        String comm = args[0].trim();

        if (Commands.GET.getCommand().equals(comm)) {
            String key = args[1].trim();
            if (!database.containsKey(key)) {
                IO.println("The name does not exist in the database");
                return;
            }
            System.out.format("The row in the database : %s - %s"
                    , key, database.get(key));
            IO.println("\n");
        }
    }
}
