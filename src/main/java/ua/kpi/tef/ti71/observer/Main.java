package ua.kpi.tef.ti71.observer;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.getEvents().subscribe("open", new SaveListener());
        editor.getEvents().subscribe("save", new EmailNotificationListener("admin@example.com"));

        editor.openFile();
        editor.saveFile();
    }
}
