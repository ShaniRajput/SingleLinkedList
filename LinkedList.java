public class LinkedList {
    Node head;

    void insertStart(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node temp = new Node(value);
            temp.next = head;
            head = temp;
        }
    }

    void insertByPosition(int value, int position) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node temp = head;
            if (position == 1) {
                insertStart(value);
            } else if (size() >= position) {
                for (int i = 1; i < position - 1; i++) {
                    temp = temp.next;
                }
                Node new_node = new Node(value);
                new_node.next = temp.next;
                temp.next = new_node;
            } else {
                insertEnd(value);
            }
        }
    }

    void insertEnd(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(value);
        }
    }

    void removeByValue(int value) {
        if (head.value == value) {
            head = head.next;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.value == value) {
                temp.next = temp.next.next;
            }
            if (temp.next != null) {
                temp = temp.next;
            }
        }
    }

    void removeByPosition(int position) {
        if (position == 1) {
            head = head.next;
        } else {
            Node temp = head;
            if (size() >= position) {
                for (int i = 1; i < position - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
        }
    }

    void show() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.value + " => ");
            temp = temp.next;
        }
        System.out.print(temp.value);
        System.out.println();
    }

    int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}