package own.nio.utilities;

public class InputParser implements Parser{
    @Override
    public String[] parse(Object entity) {
        String text = (String) entity;
        text = text.trim();

        if (!text.contains(" ")) {
            return new String[]{text};
        }
        if (text.contains(" ") && !text.contains("\"")) {
            return new String[]{};
        }
        if (text.indexOf("\"") == text.lastIndexOf("\"")) {
            return new String[]{};
        }

        String[] line = text.split(" ");
        String name = "";

        name = text.substring(text.indexOf("\"") + 1
                , text.lastIndexOf("\""));

        return new String[]{line[0], name, line[line.length - 1]};
    }
}
