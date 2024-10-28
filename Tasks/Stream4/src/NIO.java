import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NIO {

    public static void main(String[] args) {
        String filename = "Tasks/Stream5/text.txt";
        String resultFilename = "Tasks/Stream5/NIOresult.txt";

        try {
            copy(Path.of(filename), Path.of(resultFilename));
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void copy(Path filename, Path resultFilename) throws IOException {
        try (FileChannel file = FileChannel.open(filename, StandardOpenOption.READ);
             FileChannel dest = FileChannel.open(resultFilename, StandardOpenOption.CREATE,
                     StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            System.out.println("Скопировал " + file.toString() + " в " + dest.toString());
        }
    }
}