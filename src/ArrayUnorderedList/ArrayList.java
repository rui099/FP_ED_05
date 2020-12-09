/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayUnorderedList;

import Interfaces.ListADT;
import PackagesExeptions.EmptyCollectionException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo
 * @param <T>
 */
public class ArrayList<T> implements ListADT<T> {

    private final int DEFAULT_CAPACITY = 100;

    protected int rear;
    protected int modCount;

    protected T[] array;

    public ArrayList() {
        this.modCount = this.rear = 0;
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        this.modCount = this.rear = 0;
        this.array = (T[]) new Object[initialCapacity];
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        T element = this.array[0];

        this.array[0] = null;

        for (int i = 0; i < this.rear; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.rear--;

        this.modCount++;

        return element;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        T element = this.array[this.rear];

        this.array[this.rear] = null;

        this.rear--;

        this.modCount++;

        return element;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        if (element == this.array[0]) {
            return this.removeFirst();
        }

        if (element == this.array[this.rear]) {
            return this.removeLast();
        }

        for (int i = 0; i < this.rear; i++) {
            if (element == this.array[i]) {
                for (int j = i; j < this.rear; j++) {
                    this.array[j] = this.array[j + 1];
                }
            }
        }

        this.rear--;

        this.modCount++;

        return element;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        return this.array[0];
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        return this.array[this.rear - 1];
    }

    @Override
    public boolean contains(T target) {
        int i = 0;
        boolean found = false;

        while (!found && i < this.array.length) {
            if (target.equals(this.array[i])) {
                found = true;
            }
        }

        return found;
    }

    @Override
    public boolean isEmpty() {
        return this.rear == 0;
    }

    @Override
    public int size() {
        return this.rear;
    }

    @Override
    public String toString() {
        String list = "\n";

        for (int i = 0; i < this.rear; i++) {
            list = list + "Posição " + i + ": " + this.array[i] + "\n";
        }

        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator();
    }

    private class BasicIterator implements Iterator {

        private int current;
        private int expectedModCount;
        private boolean okToRemove;

        public BasicIterator() {
            this.current = 0;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return this.current != size();
        }

        @Override
        public T next() {
            if (this.expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException();
            }

            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            this.current++;

            this.okToRemove = true;

            return (T) array[this.current - 1];
        }

        @Override
        public void remove() {
            if (this.expectedModCount != ArrayList.this.modCount) {
                throw new java.util.ConcurrentModificationException();
            }

            if (!this.okToRemove) {
                throw new IllegalStateException();
            }

            try {
                this.current--;

                ArrayList.this.remove(ArrayList.this.array[this.current]);

                this.okToRemove = false;

            } catch (EmptyCollectionException ex) {
                Logger.getLogger(ArrayList.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.expectedModCount = ArrayList.this.modCount;
        }

    }

}
