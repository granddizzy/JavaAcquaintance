import java.util.Scanner;

public class SimpleNumbers {
    public static void main(String[] args) {

        System.out.print("Введите число: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for (int i = 1; i < num; i++) {
            if (isItSimple(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    static boolean isItSimple(int num) {
//        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97

        return (num == 2 || num % 2 != 0) && (num == 3 || num % 3 != 0) && (num == 5 || num % 5 != 0) && (num == 7 || num % 7 != 0);
    }
}
