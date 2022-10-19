import java.util.Scanner;

public class Main {
    //111
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        char action;
        String[] data = exp.split(" ");
        if (exp.length() > 10) {
            throw new Exception("длина строки больше 10 символов");
        }
        if (!data[0].contains("\"") && !data[2].contains("\"")) {
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[2]);
            if (a > 10 || b > 10) {
                throw new Exception("цифра больше 10");
            }

        }
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
            printInQuotes(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                printInQuotes(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                printInQuotes(result);
            }
        } else {
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, newLen);
            printInQuotes(result);
        }
    }

    static void printInQuotes(String text) {
        System.out.println("\"" + text + "\"");
    }
}