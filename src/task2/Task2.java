package task2;


//� ������ ������ ������������� ����� � �������� �������� ��������� �� ��������� ���� �����.

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        String string = null;
        String substring = null;

        try {
            substring = subString();
            string = read().toString();
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String regex = ("\\b" + substring + "\\b");
        String str = string.replaceAll(regex, "������");

        writeFile(str);
    }

    public static StringBuffer read() throws IOException {
        String str;

        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\newFolder\\poem.txt"));

        while ((str = reader.readLine()) != null) {
            sb.append(str).append(" ");
        }
        return sb;
    }

    public static String subString() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("������� ������, ������� ������ ��������:");

        String str = bf.readLine();

        System.out.print("������, ������� ������ ��������: " + str + "\n");

        return str;
    }

    public static void writeFile(String string) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\newFolder\\resulttask2.txt"))) {

            writer.write(string);

        } catch (IOException exc) {
            System.out.println("������ ������ � ����");
        }
    }
}

