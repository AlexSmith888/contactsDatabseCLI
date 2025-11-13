package own.nio.core;

import own.nio.utilities.Validation;

import java.util.HashMap;

public interface Command {
    public void fulfill(String[] args, HashMap<String, String> database) throws IllegalArgumentException;
}
