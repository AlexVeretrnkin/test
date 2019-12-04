package ua.kpi.tef.ti71.decorator;

public class DataSourceDecorator implements DataSource {
    private DataSource wrappee;

    DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    public void writeData(String data) {
        wrappee.writeData(data);
    }

    public String readData() {
        return wrappee.readData();
    }
}
