import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(calc(bufferedReader.readLine()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) {
        String[] elements = input.split(" ");

        checkInput(elements);

        int num1 = Integer.parseInt(elements[0]);
        int num2 = Integer.parseInt(elements[2]);
        String operation = elements[1];

        switch (operation) {
            case "+":
                num1 += num2;
                break;
            case "-":
                num1 -= num2;
                break;
            case "*":
                num1 *= num2;
                break;
            case "/":
                num1 /= num2;
                break;
        }
        return String.valueOf(num1);
    }

    private static void checkInput(String[] elements) {
        try {
            if (elements.length != 3) {
                throw new Exception("Неправильное количество введенных элементов!");
            }

            double num1 = Integer.parseInt(elements[0]);
            double num2 = Integer.parseInt(elements[2]);

            if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
                throw new Exception("Неправильное значение одного из чисел!");
            }

            ArrayList<String> operations = new ArrayList<>(List.of("+", "-", "*", "/"));
            if (!operations.contains(elements[1])) {
                throw new Exception("Неправильная операция!");
            }
        } catch (Exception e) {
            System.err.println(e.fillInStackTrace());
            System.exit(1);
        }
    }
}