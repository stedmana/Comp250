package Ass4.hashMap;

public class Tester {
    public static void main(String[] args) {
        HashLinkedList<Integer, Integer> list = new HashLinkedList<>();
        HashLinkedList<Integer, Song> songList = new HashLinkedList<>();
        Song s1 = new Song("hello","adelle", 1969);
        Song s2 = new Song("Goodbye", "Emperoro", 2100);
        songList.add(s1.getTitle().hashCode(),s1);
        songList.add(s2.getTitle().hashCode(),s2);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);
        list.add(4, 5);

        System.out.println(list.toString());
        //System.out.println(list.removeFirst());
        System.out.println(list.remove(2));
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.remove(2));
    }
}
