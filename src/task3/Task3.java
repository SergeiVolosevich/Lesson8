package task3;


//� ������ ������ ����� �����, ������������ � ������� �����.

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String string = read().toString().toLowerCase();

        System.out.println("������ �������� �� �����");

        String regex = "\\b[����������]+[�-�]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        LinkedList<String> linkedList = new LinkedList<>();

        while (matcher.find()) {
            linkedList.add(matcher.group());
        }

        writeFile(linkedList);
        System.out.println("���� �������.");
    }

    public static StringBuffer read() {
        String str;

        StringBuffer sb = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\newFolder\\task3.txt"))) {
            while ((str = reader.readLine()) != null) {
                sb.append(str).append(" ");
            }
        } catch (IOException exc) {
            System.out.println("������ ������ �����.");
        }
        return sb;
    }


    public static void writeFile(LinkedList<String> string) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\newFolder\\resulttask3.txt"))) {

            Iterator<String> iterator = string.iterator();
            while (iterator.hasNext()) {
                writer.write(iterator.next() + System.getProperty("line.separator"));
            }
        } catch (IOException exc) {
            System.out.println("������ ������ � ����");
        }
    }
}
