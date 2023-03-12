
/*1. Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет строку длины N, которая состоит из
        чередующихся символов c1 и c2, начиная с c1. (6, 'a', 'b') -> "ababab"*//*
2. Создать файл с названием file.txt. Если файл уже есть, то создавать не надо Записать в него Слово "TEXT" 100 раз*/
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
public class Homework2 {
    public static void main(String[] args) {

        System.out.println(buildString());

        try {
            saveFile(buildString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(buildStringHundredTimes());

        try {
            saveFileSS(buildStringHundredTimes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static String buildString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) sb.append('a');
            else sb.append('b');
        }
        return sb.toString();
    }

    static void saveFile(String createdString) throws Exception {
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file_ab.txt");
            File file = new File(pathFile);

            if (file.createNewFile()) {
                System.out.println("file.created");
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(createdString);
                fileWriter.flush();
                fileWriter.close();
            } else {
                System.out.println("file.existed");
            }
        } finally {
            System.out.println(createdString);
        }
    }

    static String buildStringHundredTimes() {
        return "Text".repeat(100);
    }

    static void saveFileSS(String createdString) throws Exception {
        Path of = Path.of("file.txt");

        if (!Files.exists(of)) {
            System.out.println("file.created");
            Files.createFile(of);
            Files.writeString(of,createdString);
        } else {
            System.out.println("file.existed");
        }
    }
}
