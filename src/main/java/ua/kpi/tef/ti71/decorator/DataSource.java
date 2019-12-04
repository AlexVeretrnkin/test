package ua.kpi.tef.ti71.decorator;

public interface DataSource {
    void writeData(String data);

    String readData();
}
