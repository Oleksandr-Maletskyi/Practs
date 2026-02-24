package Assignment3;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptWriter implements AutoCloseable {

    private final FileWriter writer;

    public ReceiptWriter(String fileName) throws IOException {
        this.writer = new FileWriter(fileName);
        System.out.println("ReceiptWriter opened");
    }

    public void write(String content) throws IOException {
        writer.write(content);
    }

    @Override
    public void close() throws IOException {
        System.out.println("ReceiptWriter closed");
        writer.close();
    }
}