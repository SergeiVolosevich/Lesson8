import java.io.*;


//� ������ ������ ����� � ������� �������� ���������.

public class Task1 {
    public static void main(String[] args) {
        String string;
        String stringdelete = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("������ ���������, ������� ������ �������:");
        try {
            stringdelete = reader.readLine();
        } catch (IOException exc) {
            System.out.println("������ ����� ���������.");
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
        System.out.println("������� ������ ��� ������ � ����, ��� ������� \"exit\", ��� ������");
        try {
            str = reader.readLine();
        } catch (IOException e) {
            System.out.println("������ �����.");
        }
        return str;
    }

    public static void recording(String str) {
        try (FileWriter fr = new FileWriter("C:\\newFolder\\text.txt", true)) {
            str = str + "\r\n";
            fr.write(str);
        } catch (IOException exc) {
            System.out.println("������ ������.");
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
            System.out.println("������ ������ �����.");
        } catch (IOException exc) {
            System.out.println("������ ������ �����.");
        }
    }
}
