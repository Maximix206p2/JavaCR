package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExps {

    public static void main(String[] args) throws IOException {
        /* String s1 = ".", s2 = "ab";
        Pattern pattern = Pattern.compile(".");
        Matcher matcher = pattern.matcher(s2); */
        //System.out.println(matcher.matches());

        //Строка содержит только один символ
        check(".", " ", "ab");
        //Строка содержит дофига символов
        check(".{5}", "12345", "234");
        //Строка содержит одну или более букву "a", а за ней одну букву "b"
        check("a+b", "aab", "abb");
        //Строка содержит несколько или ни одной буквы "a", а за ней одну букву "b"
        check("a*b", "b", "abb");
        //Слово состоит из двух букв, первая из которых "a"
        check("a.", "ab", "sa");
        //Последняя буква в строке — "a"
        check(".*a", "a", "luna");
        //Третий символ — "a"
        check(".{2}a.*", "sla", "lnast");
        //Первый и последний символ — "a"
        check("a.*a", "asla", "lnast");
        //Первый и последний символ одинаковый
        check("(.).*\\1", "acba", "abb");
        //Строка не должна начинаться с "a" или "b"
        check("[^ab].*", "ccba", "abb");
        //Чётные символы — "a"
        check("(.a)+", "caba", "abb");
        //Первый и последний символ не одинаковый
        //check("(.).*\\1", "acba", "abb");
        //В строке должно присутствовать по крайней мере 3 одинаковых символа
        //check("[ {2}]+", "ac b a", "cbb");
        //Строка не содержит букву "a"
        check("[^a]+", "acba", "cbb");
        //Строка содержит букву "a"
        check("[a-zA=Z]*a[a-zA-Z]*", "bacbc", "bcbb");
        //В строке содержатся цифры
        check("[a-zA=Z]*\\d[a-zA-Z]*", "ba2cbc", "bcbb");
        //Строка содержит только цифры
        check("\\d+", "1", "b32cdd");
        //Строка является вещественным числом с фиксированной точкой
        check("[+-]?\\d+[.]?\\d*?", "-1.23", "b32cdd");
        //Проверить написание номера телефона в формате 8(023)-123-45-67
        check("8\\(\\d{3}\\)-\\d{3}-\\d{2}-\\d{2}", "8(023)-123-45-67", "8(023)-123-45-673");

        TextFileReader textFileReader = new TextFileReader("src/com/company/data/vocab");
        ArrayList list = (ArrayList) textFileReader.getList();
        System.out.println(list.toString());
        //Только слова, подходящие под шаблон
        for (var str : list) {
            if (check1("s.+b(.+)?", str.toString()))
                System.out.println(str.toString());
        }

    }
    public static boolean check1(String pattern, String s1) {
        boolean b1 = Pattern.compile(pattern).matcher(s1).matches();
        return b1;
    }

    public static void check(String pattern, String s1, String s2) {
        boolean b1 = Pattern.compile(pattern).matcher(s1).matches();
        boolean b2 = Pattern.compile(pattern).matcher(s2).matches();
        System.out.println(b1 + " " + b2);
    }

    //Из текстового файла-словаря извлекаются слова в массив строк
    static class TextFileReader {
        String fileName;
        private List<String> list = new ArrayList<String>();

        TextFileReader(String fileName) throws IOException {
            this.fileName = fileName;
            StringBuilder sb;
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    if (!line.equals(""))
                        list.add(line);
                    line = br.readLine();
                }
            }
        }

        public List<String> getList() {
            return list;
        }
    }
}
