package com.jaewa;

public class ConcreteObserver  implements Observer {
    private String name;
    private String message;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        System.out.println(name + " ha ricevuto l'aggiornamento: " + message);
    }

    public String getMessage() {
        return message;
    }
}
