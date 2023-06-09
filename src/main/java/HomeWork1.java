import java.util.Arrays;
import java.util.Random;

//1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
// Пункты реализовать в методе main
// *Пункты реализовать в разных методах
//
// int i = new Random().nextInt(k); //это кидалка случайных чисел!)

public class HomeWork1 {
    public static void main(String[] args) {

        int i = getRandomInt(2000);

        System.out.print(i + " ");
        System.out.println(Integer.toBinaryString(i));
        int n = getMSb3(i);
        System.out.print(n + " ");
        System.out.println(Integer.toBinaryString(n));

        System.out.println(Short.MAX_VALUE);
        int[] m1 = getMultiples(i, Short.MAX_VALUE, n);
        System.out.println(Arrays.toString(m1));

        System.out.println(Short.MIN_VALUE);
        int[] m2 = getNotMultiples(Short.MIN_VALUE, i, n);
        System.out.println(Arrays.toString(m2));

    }

    public static int getMSb(int number) {
        String numString = Integer.toBinaryString(number);
        StringBuilder sb = new StringBuilder(numString);

        for (int i = 1; i < sb.length(); i++) sb.setCharAt(i, '0');

        return Integer.parseInt(sb.toString(), 2);
    }

    public static int getMSb2(int number) {
        int numberOfBits = Integer.toBinaryString(number).length();
        int testMSb = 1 << numberOfBits; //сдвигаем 1 на количество максимальных разрядов побитово
        while (testMSb > number) testMSb >>= 1; //пока сдвинутое число больше i сдвигаем по 1 биту
        return testMSb;
    }

    public static int getMSb3(int number) {
//        заменяем все последующие биты на 1
        number |= number >> 1;
        number |= number >> 2;
        number |= number >> 4;
        number |= number >> 8;
        number |= number >> 16;
        return number - (number >> 1); // вычитаем от полученного результата сдвинутый на 1 бит получаем MSb
    }

    public static int getRandomInt(int maxValue) {
        return new Random().nextInt(maxValue);
    }


    public static int[] getMultiples(int beginNum, int endNum, int divider) {
        int i = beginNum;
        while (i % divider != 0) i++; // находим пераое кратное число

        int count = (endNum - beginNum) / divider; // находим количество вхождений делителя

        if (beginNum < 0 && endNum > 0) count++;

        int[] numArr = new int[count];
        int tmp = i;
        for (i = 0; i < count; i++) {
            numArr[i] = tmp;
            tmp += divider;
        }

        return numArr;
    }

    public static int[] getNotMultiples(int beginNum, int endNum, int divider) {
        int[] mults = getMultiples(beginNum, endNum, divider);
        int size = endNum - beginNum - mults.length;

        int[] newArr = new int[size];

        int i = 0;
        int k = 0;
        for (int mult : mults) {
            for (k = beginNum; k < mult; k++) {
                try {
                    newArr[i] = k;
                    i++;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
            beginNum = k + 1;
        }

        for (k = beginNum; k < endNum ; k++) {
            try {
                newArr[i] = k;
                i++;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return newArr;
    }


//    public static void bits() {
//        int a = 3;
//        int b = 6;
//        int c = a | b;
//        int d = a & b;
//        int e = a ^ b;
//        int f = ~b;
//        System.out.println("a = " + Integer.toBinaryString(a));
//        System.out.println("b = " + Integer.toBinaryString(b));
//        System.out.println("a | b = " + Integer.toBinaryString(c));
//        System.out.println("a & b = " + Integer.toBinaryString(d));
//        System.out.println("a ^ b = " + Integer.toBinaryString(e));
//        System.out.println("~ b = " + Integer.toBinaryString(f));
//    }
}
