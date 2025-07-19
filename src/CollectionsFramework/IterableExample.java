package CollectionsFramework;

import java.util.Iterator;

// every implementation of DS in Collections extend this interface, so let's look
// how it works, by creating our own implementation, this can be helpful if we want
// to create our own Data Structure, for example.
public class IterableExample<T> implements Iterable<T>{
    private T[] items;
    private int size;

    public IterableExample() {
        size = 0;
        items = (T[]) new Object[10];
    }

    public void add(T item) {
        items[size++] = item;
    }

    public T getItem(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new OurGenericListIterator(this);
    }

    private class OurGenericListIterator implements Iterator<T> {

        private IterableExample<T> list;
        private int index = 0;

        public OurGenericListIterator(IterableExample<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return size < items.length;
        }

        @Override
        public T next() {
            return list.items[index];
        }
    }
}
