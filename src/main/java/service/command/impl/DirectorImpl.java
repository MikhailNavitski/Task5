package service.command.impl;

import service.command.Command;
import service.command.Director;
import service.impl.ServiceDOM;
import service.impl.ServiceSAX;
import service.impl.ServiceStAX;

import java.util.HashMap;
import java.util.Map;

public class DirectorImpl implements Director {

    private final static DirectorImpl instance = new DirectorImpl();


    public static DirectorImpl getInstance() {
        return instance;
    }

    private static Map<String, Command> map = new HashMap<>();

    private DirectorImpl() {
    }

    public void addMap() {
        map.put("DOM", new ServiceDOM());
        map.put("SAX", new ServiceSAX());
        map.put("StAX", new ServiceStAX());
    }

    @Override
    public Command getCommand(String name) {
        Command command;
        command = map.get(name);
        return command;
    }
}
