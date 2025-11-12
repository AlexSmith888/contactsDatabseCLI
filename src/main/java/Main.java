import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {
    static void main() throws URISyntaxException, IOException {
        HashMap<String, String> database = new HashMap<>();

        URL resourceUrl =
                Main.class.getClassLoader().getResource("database.txt");
        if (resourceUrl == null) {
            throw new IllegalArgumentException(
                    "The Database file should persist on the disk");
        }

        Path path = Paths.get(resourceUrl.toURI());
        Initialization.launch(database, path);

        System.out.println(database.get("Sasha"));

        Initialization.shutDown(database, path);
    }
}
