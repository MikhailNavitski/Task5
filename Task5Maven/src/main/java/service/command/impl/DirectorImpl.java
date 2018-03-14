package service.command.impl;

import service.command.Command;
import service.command.Director;
import service.impl.ServiceDOMParser;
import service.impl.ServiceSAXParser;
import service.impl.ServiceStAXParser;

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
        map.put("DOM", new ServiceDOMParser());
        map.put("SAX", new ServiceSAXParser());
        map.put("StAX", new ServiceStAXParser());
    }

    @Override
    public Command getCommand(String name) {
        Command command;
        command = map.get(name);
        return command;
    }
}
