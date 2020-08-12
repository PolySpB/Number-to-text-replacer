import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел от 1 до 12 на слова
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()) {
            String[] line = fileReader.readLine().trim().split(" ");

            for (int i=0; i<line.length; i++) {
                Pattern pattern = Pattern.compile("\\b[0-9]{1,2}\\b");
                Matcher matcher = pattern.matcher(line[i].trim());

                while (matcher.find()) {
                    int number = Integer.parseInt(matcher.group());
                    if (map.containsKey(number)) {
                        line[i] = matcher.replaceFirst(map.getOrDefault(number, ""));
                    }
                }

                System.out.print(line[i] + " ");
            }

            System.out.println();
        }

        fileReader.close();

    }
}
