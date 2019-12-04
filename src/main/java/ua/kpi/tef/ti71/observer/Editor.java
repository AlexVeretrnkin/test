package ua.kpi.tef.ti71.observer;

public class Editor {
    private static EventManager events = new EventManager("open", "save");

    public Editor() {
        // It's empty
    }

    public void openFile() {
        events.notify("open");
    }

    public void saveFile() {
        events.notify("save");
    }

    public EventManager getEvents() {
        return events;
    }
}
