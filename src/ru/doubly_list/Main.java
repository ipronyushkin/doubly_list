package ru.doubly_list;

class Main {
    public static void main(String[] args){
        int last;
        DoublyList test = new DoublyList();
        test.add(10);
        test.add(9);
        test.add(11);
        last = test.size() - 1;
        test.set(last, 8);
        //test.printList();
        test.add(0, 11);
        test.remove(0);
        test.printList();
        System.out.println(test.get(0));
    }
}
