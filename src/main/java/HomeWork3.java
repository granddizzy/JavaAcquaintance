//Задание
//
// Пусть дан произвольный список целых чисел.
//
// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

import org.w3c.dom.ls.LSOutput;

import javax.swing.text.MaskFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class HomeWork3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = listGenerator(10);
        System.out.println(arrList);

        delEven(arrList);
        System.out.println(arrList);

        System.out.println(getMin(arrList));
        System.out.println(getMax(arrList));
        System.out.println(getAverage(arrList));
        System.out.println(getAverage2(arrList));
    }

    public static Double getAverage(ArrayList<Integer> list) {
        // среднее арифметическое
        long sum = 0;
        for (int num : list) {
            sum += num;
        }
        return list.size() > 0 ? (double) sum / list.size() : 0;
    }

    public static Integer getAverage2(ArrayList<Integer> list) {
        //средний по значению элемент
        if (list.size() < 3) {
            return 0;
        }

        Collections.sort(list);
        System.out.println(list);

        if (list.size() % 2 != 0) {
            return list.get(list.size() / 2);
        } else {
            int index = list.size() / 2;
            double middle = (double) (Collections.max(list) + Collections.min(list)) / 2;
            if (middle - list.get(index - 1) < list.get(index) - middle) {
                return list.get(index -1 );
            } else {
                return list.get(index);
            }
        }
    }

    public static Integer getMin(ArrayList<Integer> list) {
        return Collections.min(list);
    }

    public static Integer getMax(ArrayList<Integer> list) {
        return Collections.max(list);
    }

    public static void delEven(ArrayList<Integer> list) {
//        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
//            if (it.next() % 2 == 0) {
//                it.remove();
//            }
//        }

        list.removeIf(num -> num % 2 == 0);
    }

    public static ArrayList<Integer> listGenerator(int size) {
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size - 1; i++) {
            list.add(new Random().nextInt(0, 100));
        }

        return list;
    }


}
