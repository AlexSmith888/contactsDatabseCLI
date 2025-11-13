package own.nio.utilities;

public class PhoneValidation implements Validation{

    @Override
    public void processData(Object entity) throws IllegalArgumentException {
        String[] arr = (String[]) entity;
        if (arr.length < 2) {
            throw new IllegalArgumentException("A telephone " +
                    "number should be provided");
        }
    }
}
