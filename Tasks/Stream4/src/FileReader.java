import java.io.*;

public class FileReader {

    public static void main(String[] args) {
        String filename = "Tasks/Stream4/text.txt";
        String resultFilename = "Tasks/Stream4/result.txt";

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(resultFilename))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }
            System.out.println("Готово!");

        } catch (FileNotFoundException e) {
            System.err.println("А нет такого файла: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}