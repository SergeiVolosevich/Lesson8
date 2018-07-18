import java.io.*;


//В каждой строке найти и удалить заданную подстроку.

public class Task1 {
    public static void main(String[] args) {
        String string;
        String stringdelete = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ведите подстроку, которую хотите удалить:");
        try {
            stringdelete = reader.readLine();
        } catch (IOException exc) {
            System.out.println("Ошибка ввода подстроки.");
        }

        while ((string = getString()).compareTo("exit") != 0) {
            recording(string);
        }

        recording("");

        readAndWrite(stringdelete);
    }


    public static String getString() {
        String str = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку для записи в файл, или введите \"exit\", для выхода");
        try {
            str = reader.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка ввода.");
        }
        return str;
    }

    public static void recording(String str) {
        try (FileWriter fr = new FileWriter("C:\\newFolder\\text.txt", true)) {
            str = str + "\r\n";
            fr.write(str);
        } catch (IOException exc) {
            System.out.println("Ошибка записи.");
        }
    }

    public static void readAndWrite(String stringdel) {
        String str;
        String str1;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\newFolder\\text.txt"))) {
            while (!(str = reader.readLine()).equals("")) {
                str1 = str.replaceAll(stringdel, "");
                recording(str1);
            }

        } catch (FileNotFoundException exc) {
            System.out.println("Ошибка чтения файла.");
        } catch (IOException exc) {
            System.out.println("Ошибка записи файла.");
        }
    }
}
