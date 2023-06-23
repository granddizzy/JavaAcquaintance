//создать класс имитирующий работу hashSet

import java.util.*;

public class seminar6 {
    public static void main(String[] args) {
        SetImitation<Integer> set = new SetImitation<>();
        System.out.println(set.add(9));
        System.out.println(set.add(9));
        System.out.println(set.add(7));
        System.out.println(set.del(9));
        System.out.println(set.del(9));
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains(7));

        for (int i = 0; i < 20; i++) {
            set.add(new Random().nextInt(1000));
        }

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.println(set.getElement(5));
        System.out.println(Arrays.toString(set.toArray()));
        System.out.println(set);
    }
}

class SetImitation<E> {
    private HashMap<E, Object> map = new HashMap<>();

    private static final Object Obj = new Object();

    public boolean add(E el) {
        return map.put(el, Obj) == null;
    }

    public boolean del(E el) {
        return map.remove(el, Obj);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.size() == 0;
    }

    public boolean contains(Object el) {
        return map.containsKey(el);
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    public E getElement(int index) {
        return (E) map.keySet().toArray()[index];
    }

    public E[] toArray() {
        return (E[]) map.keySet().toArray();
    }

    public String toString() {
        return map.keySet().toString();
    }
}