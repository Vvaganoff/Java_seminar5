package org.example.Ex1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1) Подсчитать количество вхождения каждого слова
 * Пример:
 * Россия идет вперед всей планеты. Планета — это не Россия.
 * toLoverCase().
 * (Усложнение - игнорировать пунктуацию)*
 */
public class Ex1 {

    public static void main(String[] args) {
        System.out.println("Введите фразу:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.trim();
        str = str.toLowerCase();
        String[] strArray = str.split("[,.:;— ]");

        System.out.println("Введите искомое слово:");
        String strTarget = scanner.nextLine();
        strTarget = strTarget.trim();
        strTarget = strTarget.toLowerCase();
        scanner.close();
        System.out.println(FindResult(StrMap(strArray), strTarget));


    }

    static Map StrMap(String[] array) {
        Map<String, Integer> strMap = new HashMap<>();
        Integer count = 0;
        for (String s : array) {
            if (!s.equals(" ") && !s.equals("")) {
                if (strMap.containsKey(s)) {
                    count = strMap.get(s) + 1;
                    strMap.put(s, count);
                } else {
                    strMap.put(s, 1);
                }
            }
        }
        return strMap;
    }

    static String FindResult(Map sMap, String sToFind) {
        if (sMap.containsKey(sToFind)) {
            return "Слово " + "\"" + sToFind + "\" " + "встречается в тексте " + sMap.get(sToFind) + " раз.";
        }
        return "Такого слова в тексте не найдено.";
    }
}
