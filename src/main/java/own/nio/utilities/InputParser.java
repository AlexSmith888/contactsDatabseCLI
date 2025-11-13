package own.nio.utilities;

public class InputParser implements Parser{
    @Override
    public String[] parse(Object entity) {
        String text = (String) entity;
        if (!text.contains(" ")) {
            return new String[]{text};
        }
        if (!text.contains("\"")) {
            return new String[]{};
        }

        String[] line = text.split(" ");
        String name = "";

        name = text.substring(text.indexOf("\"") + 1
                , text.lastIndexOf("\""));

        return new String[]{line[0], name, line[line.length - 1]};
    }
}
