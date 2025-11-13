package own.nio.utilities;

import own.nio.core.Commands;

public class InputValidation implements Validation{

    @Override
    public void processData(Object entity) throws IllegalArgumentException {
        String [] obj = (String []) entity;
        if (obj.length == 0) {
            throw new IllegalArgumentException("Input Data are incorrect");
        }
        if ((obj[0].equals(Commands.ADD.getCommand())
                || obj[0].equals(Commands.UPDATE.getCommand()))
                && obj.length < 3) {
            throw new IllegalArgumentException("Both a name " +
                    "and a telephone num should be provided");
        }
        if ((obj[0].equals(Commands.GET.getCommand())
                || obj[0].equals(Commands.DELETE.getCommand()))
                && obj.length < 2) {
            throw new IllegalArgumentException("A contact name should be provided");
        }
    }
}
