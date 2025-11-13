package own.nio.core;

import own.nio.utilities.Validation;

import java.util.HashMap;

public class CommandDispatcher{

    Command command;
    Command command1;
    Command command2;
    Command command3;
    Command command4;

    public CommandDispatcher(){
        command = new ContactCreation();
        command1 = new ContactRemoval();
        command2 = new ContactRetrieval();
        command3 = new ContactsListing();
        command4 = new ContactUpdate();
    }
    public void fulfillCommand(String[] args, HashMap<String, String> database) throws IllegalArgumentException {
        command.fulfill(args, database);
        command1.fulfill(args, database);
        command2.fulfill(args, database);
        command3.fulfill(args, database);
        command4.fulfill(args, database);
    }
}
