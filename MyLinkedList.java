public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;

        MyNode(T element, MyNode next, MyNode prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private MyNode head, tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        MyNode newNode = new MyNode(element, null, tail);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode.prev != null) {
            currentNode.prev.next = currentNode.next;
        } else {
            head = currentNode.next;
        }
        if (currentNode.next != null) {
            currentNode.next.prev = currentNode.prev;
        } else {
            tail = currentNode.prev;
        }
        size--;
        return currentNode.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }
}
