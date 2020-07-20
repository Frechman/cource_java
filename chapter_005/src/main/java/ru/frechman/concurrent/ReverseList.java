package ru.frechman.concurrent;

public class ReverseList {

    static class Node<T> {
        private Node<T> next;
        private T value;

        public Node(Node<T> next, T value) {
            this.next = next;
            this.value = value;
        }
    }

    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    static <T> void printList(Node<T> node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> list =
                new Node<>(new Node<>(new Node<>(new Node<>(null, 4),3),2), 1);

        System.out.println("Given Linked list");
        printList(list);
        Node<Integer> head = reverse(list);
        System.out.println("");
        System.out.println("Reversed linked list ");
        printList(head);
    }
}
