package own.nio.core;

public enum Commands {
      ADD("add")
    , DELETE("del")
    , UPDATE("upd")
    , LIST("ls")
    , GET("get");
      private final String command;
    Commands(String command) {
        this.command = command;
    }
    public String getCommand(){
        return command;
    }
}
