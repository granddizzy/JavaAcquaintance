import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PolynomialSum {
    public static void main(String[] args) throws Exception {
        //        Задана натуральная степень k. Сформировать случайным
        //        образом список коэффициентов (значения от 0 до 100)
        //        многочлена многочлен степени k.
        //*Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0

        //        Даны два файла, в каждом из которых находится запись
        //        многочлена. Сформировать файл содержащий сумму
        //        многочленов.

        Scanner scan = new Scanner(System.in);

        int koef = 0;
        boolean scanRes = false;
        while (!scanRes) {

            System.out.print("Введите коэффициент: ");
            scan = new Scanner(System.in);
            scanRes = scan.hasNextInt();
        }
        koef = scan.nextInt();
        scan.close();

        String polynomial1 = generatePolynomial(koef);
        String filePath1 = "first_polynomial";
        savePolynomial(polynomial1, filePath1);

        String polynomial2 = generatePolynomial(koef);
        String filePath2 = "second_polynomial";
        savePolynomial(polynomial2, filePath2);

        polynomial1 = loadPolynomial(filePath1);
        polynomial2 = loadPolynomial(filePath2);
        String polysum = polinomialSum(polynomial1, polynomial2);

        System.out.println(polynomial1);
        System.out.println(polynomial2);
        System.out.println(polysum);
    }

    static String polinomialSum(String polynomial_1, String polynomial_2) {
        String polynomial = "";
        String[] poly1 = polynomial_1.replace(" = 0", "").replace("^", "").split(" [+-] ");
        String[] poly2 = polynomial_2.replace(" = 0", "").replace("^", "").split(" [+-] ");

        int max_length = Math.max(poly1.length, poly2.length);

        int koef = 0;
        for (int i = 0; i < max_length; i++) {
            koef = 0;
            if (i < poly1.length) {
                String[] data = poly1[i].split("[*]");

                if (data.length == 2) {
                    koef = Integer.parseInt(data[0]);
                } else {
                    int a = 1;
                }
            }

            if (i < poly2.length) {
                String[] data = poly2[i].split("[*]");

                if (data.length == 2) {
                    koef = koef + Integer.parseInt(data[0]);
                } else {
                    int a = 1;
                }
            }

            polynomial = polynomial + (i > 0 ? " + " : "") + koef + "*x" + (max_length - i > 1 ? "^" + (max_length - i) : "");
        }

        polynomial = polynomial + " = 0";
        return polynomial;
    }

    static String loadPolynomial(String file_path) throws Exception {
        String polynomial = "";
        BufferedReader br = new BufferedReader(new FileReader(file_path));
        String str;
        while ((str = br.readLine()) != null) {
            polynomial = polynomial + str;
        }
        br.close();
        return polynomial;
    }

    static void savePolynomial(String polynomial, String file_path) {
        int a = 1;
        try (FileWriter fw = new FileWriter(file_path, false)) {
            fw.write(polynomial);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    static int randint(int min, int max) {
        return min + (int) (Math.random() * (max + 1));
    }

    static String generatePolynomial(int koef) {
        String polynomial = "";

        for (int i = koef; i >= 2; i--) {
            polynomial = polynomial + (i == koef ? "" : " + ") + randint(0, 100) + "*x^" + i;
        }

        int random_num = randint(0, 100);
        polynomial = polynomial + " + " + (random_num == 0 ? "" : random_num + "*") + "x = 0";

        return polynomial;
    }
}





