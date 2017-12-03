package Ass4.hashMap;

public class Tester {
    public static void main(String[] args) {
        HashLinkedList<Integer, Integer> list = new HashLinkedList<>();
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);
        list.add(4, 5);
        System.out.println(list.toString());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.remove(2));
    }
}
