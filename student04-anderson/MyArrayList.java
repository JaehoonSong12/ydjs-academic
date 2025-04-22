/**
 * A simplified, ArrayList‐style resizable array implementation.
 * <p>
 * Internally uses a plain array to store elements, doubling its capacity
 * whenever more space is needed.
 *
 * @param <T> the type of elements held in this list
 */
public class MyArrayList<T> {
    /**
     * The array buffer into which the elements of the list are stored.
     * The capacity of the list is the length of this array buffer.
     */
    private T[] data;

    /**
     * The number of elements actually stored in this list.
     * Always non‐negative and never greater than {@link #data}.length.
     */
    private int size;

    /**
     * Constructs an empty list with an initial capacity of 10.
     * <p>
     * The list will grow automatically as elements are added.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        data = (T[]) new Object[10];
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     * <p>
     * If the internal array is full, its capacity is doubled
     * by invoking {@link #grow()} before appending.
     *
     * @param value element to be appended to this list
     */
    public void add(T value) {
        if (size == data.length) {
            grow();
        }
        data[size++] = value;
    }

    /**
     * Increases the capacity of the internal array.
     * <p>
     * Doubles the current capacity, copies all existing elements
     * into the new array, and replaces the old buffer.
     * This operation is <em>O(n)</em> in the current size of the list.
     *
     * @throws OutOfMemoryError if there is insufficient memory to allocate the new array
     */
    @SuppressWarnings("unchecked")
    private void grow() {
        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return; must be in the range {@code 0 <= index < size()}
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all of the elements from this list.
     * <p>
     * The list will be empty after this call returns,
     * but its capacity will remain unchanged.
     */
    public void clear() {
        // Optionally null out references for GC:
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace; must be in the range {@code 0 <= index < size()}
     * @param value element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    public T set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size);
        }
        T old = data[index];
        data[index] = value;
        return old;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index index of the element to be removed; must be in the range {@code 0 <= index < size()}
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size);
        }
        T removed = data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null; // clear to let GC do its work
        return removed;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code (o==null ? e==null : o.equals(e))}.
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null ? data[i] == null : o.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element
     *         in this list, or -1 if this list does not contain the element
     */
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null ? data[i] == null : o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns a string representation of this list. The string representation
     * consists of a list of the list’s elements in the order they are returned
     * by its iterator, enclosed in square brackets ("[]"). Adjacent elements
     * are separated by the characters ", " (comma and space).
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
