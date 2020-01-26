package Folder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCreator {

    public static void main(String[] args) throws IOException {
        for (int i = 3; i < 101; i++) {
            String fileName = String.format("%03dout.pas", i);
            File file = new File("src/Tests/" + fileName);

            try {
                //проверяем, что если файл не существует то создаем его
                if (!file.exists()) {
                    file.createNewFile();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
