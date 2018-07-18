package task4;


//����� � ������� ����� ������, ��� ������� ��������� ����� ������ ����� ��������� � ������ ������ ���������� �����.


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {

        String string = read().toString().toLowerCase();

        System.out.println("������ �������� �� �����");

//        String [] str = string.split("[�]");
//        for (String s:str
//             ) {
//            System.out.println(s);
//        }

        String regex = "\\b[�-�]+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }

        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i).charAt(arrayList.get(i).length() - 1) == arrayList.get(i + 1).charAt(0)) {
                linkedList.add(arrayList.get(i));
            }
        }

        writeFile(linkedList);

        System.out.println("���� �������.");
    }

    public static StringBuffer read() {
        String str;

        StringBuffer sb = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\newFolder\\task4.txt"))) {
            while ((str = reader.readLine()) != null) {
                sb.append(str).append(" ");
            }
        } catch (IOException exc) {
            System.out.println("������ ������ �����.");
        }
        return sb;
    }


    public static void writeFile(LinkedList<String> string) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\newFolder\\resulttask4.txt"))) {
            Iterator<String> iterator = string.iterator();
            while (iterator.hasNext()) {
                writer.write(iterator.next() + System.getProperty("line.separator"));
            }
        } catch (IOException exc) {
            System.out.println("������ ������ � ����");
        }
    }
}
