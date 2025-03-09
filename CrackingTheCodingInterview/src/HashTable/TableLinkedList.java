package HashTable;

import java.util.ArrayList;
import java.util.LinkedList;

public class TableLinkedList {
    public static void main(String[] args) {

        int number = 10;

        myHash(number);
        add(number);
        remove((Integer)3);
        System.out.println(search(10));
        printTable();
    }
    public static ArrayList<LinkedList<Integer>> table;

    public static int BUCKET = 7;

    public static void myHash(int number){
        int bucket = number;
        table = new ArrayList<LinkedList<Integer>>(10);

        for (int i = 0; i < 10; i++) {
            table.add(new LinkedList<>());
        }
        System.out.println(table.toString());
    }

    public static void printTable(){
        System.out.println(table.toString());
    }

    public static void remove(int number){
        int i = number % BUCKET;
        table.get(i).remove((Integer) i );
        //here we type-casted because the remove function has two variations,
        //if number is used, it removes the item at index number, and when integer object is passed that item is searched and removed.
    }

    public static void add(int number){
        int i = number % BUCKET;
        table.get(i).add( number );
    }

    public static boolean search(int number){
        int i = number % BUCKET;
        return table.get(i).contains( number );
    }
}
