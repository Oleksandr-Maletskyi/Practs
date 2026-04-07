package Assignment5;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class StatusFile {

    public static void updateStatus(Path file, long index, byte status) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file.toFile(), "rw");
             FileChannel channel = raf.getChannel()) {

            channel.position(index);

            ByteBuffer buffer = ByteBuffer.allocate(1);
            buffer.put(status);

            buffer.flip();

            channel.write(buffer);
        }
    }

    public static byte readStatus(Path file, long index) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file.toFile(), "r");
             FileChannel channel = raf.getChannel()) {

            channel.position(index);

            ByteBuffer buffer = ByteBuffer.allocate(1);
            int bytesRead = channel.read(buffer);

            if (bytesRead == -1) {
                throw new IOException("Кінець файлу. Індекс виходить за межі!");
            }

            buffer.flip();
            return buffer.get();
        }
    }
}
