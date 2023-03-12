
/*1. Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет строку длины N, которая состоит из
        чередующихся символов c1 и c2, начиная с c1. (6, 'a', 'b') -> "ababab"*//*
2. Создать файл с названием file.txt. Если файл уже есть, то создавать не надо Записать в него Слово "TEXT" 100 раз*/
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
public class Homework2 {
    public static void main(String[] args) {

        System.out.println(buildString(6, 'a', 'b'));

        saveFile(buildString(6, 'a', 'b'));

        System.out.println(buildStringHundredTimes("Text", 100));

        saveFileSS(buildStringHundredTimes("Text", 100));
    }
    static String buildString(int n, char c1, char c2) {
        if (n % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) sb.append(c1);
                else sb.append(c2);
            }
            return sb.toString();
        } else return "n not even. Exit program.";
    }

    static void saveFile(String createdString) {
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
        } catch (Exception e) {
            e.getMessage();
        } finally {
            System.out.println(createdString);
        }
    }

    static String buildStringHundredTimes(String s , int n) {
        return s.repeat(n);
    }

    static void saveFileSS(String createdString) {
        try {
            Path of = Path.of("file.txt");

            if (!Files.exists(of)) {
                System.out.println("file.created");
                Files.createFile(of);
                Files.writeString(of,createdString);
            } else {
                System.out.println("file.existed");
            }
        } catch (Exception e){
            e.getMessage();
        }
    }
}
