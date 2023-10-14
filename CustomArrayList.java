public class CustomArrayList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] array;
    private int size;

    public CustomArrayList() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        return (T) array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Element 1");
        customArrayList.add("Element 2");
        customArrayList.add("Element 3");
        String elem2 = customArrayList.get(1);
        System.out.println(elem2);
        customArrayList.remove(1);
        System.out.println(customArrayList.size());
        
    }
}