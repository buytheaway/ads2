interface MyList<T> {
    void add(T element);
    T get(int index);
    T remove(int index);
    boolean isEmpty();
    int size();
    void clear();
}
public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) elements[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        T oldElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return oldElement;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[2 * size];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
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
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}

