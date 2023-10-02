package PhoneBook;

import java.io.Console;
import java.util.*;

public class PhoneBook {
    private static Map<String, List<String>> phoneBook = new HashMap<>();

    static {
        phoneBook.put("Иванов И.И.", Arrays.asList("+8 800 2000 500", "+8 800 200 600"));
        phoneBook.put("Петров П.П.", Arrays.asList("+8 800 2000 700"));
        phoneBook.put("Сидоров С.С.", Arrays.asList("+8 800 2000 800", "+8 800 2000 900", "+8 800 2000 000"));
    }

    public static void main(String[] args) {
        String fio = readFio();
        printPhones(fio);
    }

    static String readFio() {
        String fio = "", encoding;
        Console console = System.console();
        if (console != null) {
            encoding = "cp866";
        } else {
            encoding = "utf-8";
        }
        Scanner in = new Scanner(System.in, encoding);
        boolean isValidFio = false;
        do {
            System.out.print("Введите ФИО: ");
            fio = in.nextLine();
            //System.out.println(fio);
            isValidFio = phoneBook.containsKey(fio);
            if (!isValidFio) {
                System.out.println("ФИО не найдено в базе");
            }
        }
        while (!isValidFio);
        return fio;
    }

    static void printPhones(String fio) {
        for (String phone : phoneBook.get(fio)
        ) {
            System.out.println(String.format("%s", phone));
        }
    }
}
