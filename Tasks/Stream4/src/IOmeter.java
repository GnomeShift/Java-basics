import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class IOmeter {
    private static void readWriteIO(String filename, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static void readWriteNIO(String filename, String resultFilename) throws IOException {
        try (FileChannel inChannel = FileChannel.open(Paths.get(filename), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(resultFilename), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "Tasks/Stream4/text.txt";
        String resultFilename = "Tasks/Stream4/IOmeterResult.txt";

        long ioStart = System.nanoTime();
        readWriteIO(filename, resultFilename);
        long ioEnd = System.nanoTime();
        long ioDuration = ioEnd - ioStart;

        long nioStart = System.nanoTime();
        readWriteNIO(filename, resultFilename);
        long nioEnd = System.nanoTime();
        long nioDuration = nioEnd - nioStart;

        System.out.println("Время IO: " + ioDuration + " мс");
        System.out.println("Время NIO: " + nioDuration + " мс");

        if (nioDuration < ioDuration) {
            System.out.println("NIO быстрее IO");
        }
        else {
            System.out.println("IO быстрее NIO");
        }
    }
}