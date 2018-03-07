package service;


import service.impl.ServiceCommand;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final service.Service service = new ServiceCommand();

    private ServiceFactory() {
    }

    public Service getService() {

        return service;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

}
