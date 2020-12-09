/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedUnorderedList;

import PackagesExeptions.ElementNotFoundException;
import PackagesExeptions.EmptyCollectionException;
import Interfaces.ListADT;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo
 * @param <T>
 */
public class DoubleLinkedList<T> implements ListADT<T> {

    protected DoubleNode<T> front, rear;

    protected int count, modCount;

    public DoubleLinkedList() {
        this.front = null;
        this.rear = null;
        this.count = this.modCount = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        T element = this.front.getElement();

        this.front = this.front.getNext();
        this.front.setPrevious(null);

        this.count--;

        this.modCount++;

        return element;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        T element = this.rear.getElement();

        this.rear = this.rear.getPrevious();
        this.rear.setNext(null);

        this.count--;

        this.modCount++;

        return element;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("List");
        }

        boolean found = false;
        DoubleNode<T> previous = null;
        DoubleNode<T> current = this.front;

        while (current != null && !found) {
            if (element.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            throw new ElementNotFoundException("List");
        }

        if (this.size() == 1) {
            this.front = this.rear = null;
        } else if (current.equals(this.front)) {
            this.front = current.getNext();
        } else if (current.equals(this.rear)) {
            this.rear = previous;
            this.rear.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }

        this.count--;
        this.modCount++;

        return current.getElement();
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        return this.front.getElement();
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException();
        }

        return this.rear.getElement();
    }

    @Override
    public boolean contains(T target) {
        DoubleNode<T> current = this.front;
        boolean found = false;

        while (!found && current != null) {
            if ((current.getElement()).equals(target)) {
                found = true;
            }
        }

        return found;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        String lista = "";
        DoubleNode<T> current = this.front;
        int i = 0;

        while (current != null) {
            lista = lista + "Posição " + i + ": " + current.getElement().toString() + "\n";
            current = current.getNext();
            i++;
        }

        return lista;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<>();
    }

    private class BasicIterator<E> implements Iterator<T> {

        private DoubleNode<T> current;
        private int expectedModCount;
        private boolean okToRemove;

        public BasicIterator() {
            this.current = front;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public T next() {
            if (this.expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException();
            }

            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            this.current = this.current.getNext();

            this.okToRemove = true;

            if (this.current != null) {
                return this.current.getPrevious().getElement();
            } else {
                return rear.getElement();
            }

        }

        @Override
        public void remove() {
            if (this.expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException();
            }

            if (!okToRemove) {
                throw new IllegalStateException();
            }

            try {
                T element = null;

                if (this.current != null) {
                    element = this.current.getPrevious().getElement();
                } else {
                    element = rear.getElement();
                }

                DoubleLinkedList.this.remove(element);

                this.okToRemove = false;

            } catch (EmptyCollectionException | ElementNotFoundException ex) {
                Logger.getLogger(DoubleLinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.expectedModCount = DoubleLinkedList.this.modCount;
        }

    }

}
