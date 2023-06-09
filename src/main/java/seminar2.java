import java.util.Scanner;

public class seminar2 {
    public static void main(String[] args) {
        stringReverse();
    }

    public static void stringContaint() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String firstString = scan.nextLine();

        System.out.print("Введите вторую строку: ");
        String secondString = scan.nextLine();

        if (firstString.contains(secondString)) {
            System.out.println("Строка содержит");
        }
        else {
            System.out.println("Строка не содердит");
        }
    }

    public static void stringReverse() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String firstString = scan.nextLine();

        System.out.print("Введите вторую строку: ");
        String secondString = scan.nextLine();

        if ((firstString.equals(new StringBuffer(secondString).reverse().toString()))) {
            System.out.println("Данные строки являются вращением друг друга.");
        }
        else {
            System.out.println("Данные строки НЕ являются вращением друг друга.");
        }
    }
}
