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

        int i = new Random().nextInt(2000);

        System.out.println(i + " ");
        int n = getNumberMSb(i);
        System.out.println(n);

//        int[] m1 = getMultiples(i, Short.MAX_VALUE, n);
        int[] m1 = getMultiples(1000, 2000, 10);
        System.out.println(Arrays.toString(m1));

        int[] m2 = getNotMultiples(Short.MIN_VALUE, i, n);
        System.out.println(Arrays.toString(m2));

    }

    public static int getNumberMSb(int number) {
        return Integer.toBinaryString(Math.abs(number)).length();
    }

    public static int[] getMultiples(int beginNum, int endNum, int divider) {
        int i = beginNum;
        while (i % divider != 0) i++; // находим первое кратное число

        int arrLength = (endNum - beginNum) / divider + 1;

        int[] numArr = new int[arrLength];

//        добавляем числа кратные делителю
        int tmp = i;
        for (i = 0; i < arrLength; i++) {
            numArr[i] = tmp;
            tmp += divider;
        }

        return numArr;
    }

    public static int[] getNotMultiples(int beginNum, int endNum, int divider) {
        int NumberOfMultiples = (endNum - beginNum) / divider - 1;

        int size = endNum - beginNum - NumberOfMultiples; //вычисляем размер масива некратных за вычетом количества кратных

        int[] newArr = new int[size];

        int i = 0; // индексация массива

        int endMultNum = beginNum + NumberOfMultiples * divider;

//        находим первое вхождение кратного числа
        while (beginNum % divider != 0) {
            newArr[i] = beginNum;
            i++;
            beginNum++;
        }

        //заполняем массив некратных диапазоном между кратными
        int k = 0;
        for (int j = beginNum; j < endMultNum; j += divider) {
            for (k = j + 1; k < j + divider; k++) {
                newArr[i] = k;
                i++;
            }
        }

        for (k = k + 1; k <= endNum; k++) {
            newArr[i] = k;
            i++;
        }

        return newArr;
    }
}
