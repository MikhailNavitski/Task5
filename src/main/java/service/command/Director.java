package service.command;


public interface Director {
    Command getCommand(String name);
}
