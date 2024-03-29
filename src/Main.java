import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner enter = new Scanner(System.in);
        System.out.println("Введите выражение (например 3 - 2 или III - II)");
        String expression = enter.nextLine();
        System.out.println(Calculator.calc(expression));
    }
}

class Calculator {
    public static String calc(String input) {
        int number1;
        int number2;
        String exception = "throw exception";
        boolean isRome;
        char operator;
        int answer = 0;
        String result = null;
        String[] split = input.split(" ");
        if (split.length != 3) {
        }

        if (Rome.isRome(split[0]) && Rome.isRome(split[2])) {
            number1 = Rome.convertRomeToArab(split[0]);
            number2 = Rome.convertRomeToArab(split[2]);
            isRome = true;
        } else if (!Rome.isRome(split[0]) && !Rome.isRome(split[2])) {
            number1 = Integer.parseInt(split[0]);
            number2 = Integer.parseInt(split[2]);
            isRome = false;
        } else {
            return exception;
        }

          if (number1 < 0 || number1 > 10 || number2 < 0 || number2 > 10) {
            return exception;
        }

        operator = split[1].charAt(0);

        switch (operator){
            case '+' :
                answer = number1 + number2;
                break;
            case '-' :
                answer = number1 - number2;
                break;
            case '*' :
                answer = number1 * number2;
                break;
            case '/' :
                answer = number1 / number2;
        }

        if (isRome){
            result = Rome.convertArabToRome(answer);
        } else {
            result = Integer.toString(answer);
        }

        return result;
    }
}

class Rome {
    static String[] romeMassiv = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    static boolean isRome(String num) {
        for (int i = 0; i < romeMassiv.length; i++) {
            if (num.equals(romeMassiv[i])) {
                return true;
            }
        }
        return false;
    }

    static int convertRomeToArab(String rome) {
        for (int i = 0; i < romeMassiv.length; i++) {
            if (rome.equals(romeMassiv[i])) {
                return i;
            }
        }
        return -1;
    }

    static String convertArabToRome(int arab){
        return romeMassiv[arab];
    }


}