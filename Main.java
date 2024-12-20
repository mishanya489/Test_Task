import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                System.out.println(calc(input));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) {
        String result = null;
        try {
            String[] elements = input.split(" ");

            Exception exception = checkInput(elements);
            if (exception != null) {
                throw exception;
            }

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

            result = String.valueOf(num1);

        } catch (Exception e) {
            result = e.toString();
        }
        return result;
    }

    private static Exception checkInput(String[] elements) {
        if (elements.length != 3) {
            return new Exception("Неправильное количество введенных элементов!");
        }

        double num1 = Integer.parseInt(elements[0]);
        double num2 = Integer.parseInt(elements[2]);

        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
            return new Exception("Неправильное значение одного из чисел!");
        }

        ArrayList<String> operations = new ArrayList<>(List.of("+", "-", "*", "/"));
        if (!operations.contains(elements[1])) {
            return new Exception("Неправильная операция!");
        }
        return null;
    }
}