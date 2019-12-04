package ua.kpi.tef.ti71.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;


public class CompressionDecorator extends DataSourceDecorator {
    private int compLevel = 6;

    private static Logger logger = LogManager.getLogger();

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public int getCompressionLevel() {
        return compLevel;
    }

    public void setCompressionLevel(int value) {
        compLevel = value;
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String stringData) {
        byte[] data = stringData.getBytes();

        ByteArrayOutputStream bout = Stream.of(new ByteArrayOutputStream(512))
                .map(res -> {
                    try (DeflaterOutputStream dos = new DeflaterOutputStream(res, new Deflater(compLevel))) {
                        dos.write(data);
                    } catch (IOException e) {
                        logger.error("IO", e);
                    }

                    return res;
                })
                .collect(Collectors.toList()).get(0);
        return Base64.getEncoder().encodeToString(bout.toByteArray());
    }

    private String decompress(String stringData) {
        byte[] data = Base64.getDecoder().decode(stringData);

        try (ByteArrayOutputStream bout = new ByteArrayOutputStream(512)) {
            InflaterInputStream iin = Stream.of(new ByteArrayInputStream(data))
                    .map(InflaterInputStream::new).collect(Collectors.toList()).get(0);

            int b;

            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            return new String(bout.toByteArray());
        } catch (IOException e) {
            logger.error(e);
        }

        return "No such file";
    }
}
