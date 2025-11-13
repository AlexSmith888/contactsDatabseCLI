import own.nio.core.Command;
import own.nio.core.CommandDispatcher;
import own.nio.core.Commands;
import own.nio.utilities.InputParser;
import own.nio.utilities.InputValidation;
import own.nio.utilities.PhoneValidation;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static void main() throws URISyntaxException, IOException {
        var database = new HashMap<String, String>();
        URL resourceUrl =
                Main.class.getClassLoader().getResource("database.txt");
        if (resourceUrl == null) {
            throw new IllegalArgumentException(
                    "The Database file should persist on the disk");
        }

        Path path = Paths.get(resourceUrl.toURI());
        Initialization.launch(database, path);

        CommandDispatcher receiver = new CommandDispatcher();
        Scanner scanner = new Scanner(System.in);
        String text;

        while (true) {
            Initialization.showRules();
            text = scanner.nextLine().trim();

            if (text.equals("exit")) {
                break;
            }

            if (text.isBlank()) {
                IO.println("Type something ... ");
                continue;
            }

            String[] arr = (String[]) new InputParser().parse(text);

            try {
                new InputValidation().processData(arr);
            } catch (IllegalArgumentException e) {
                System.out.println("Try again");
                continue;
            }
            receiver.fulfillCommand(arr, database);
        }
        scanner.close();
        Initialization.shutDown(database, path);
    }
}
