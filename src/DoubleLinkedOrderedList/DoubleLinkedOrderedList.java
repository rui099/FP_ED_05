/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedOrderedList;

import Interfaces.OrderedListADT;
import javax.activation.UnsupportedDataTypeException;

/**
 *
 * @author Paulo
 * @param <T>
 */
public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {

    @Override
    public void add(T element) throws UnsupportedDataTypeException {
        if (!(element instanceof Comparable)) {
            throw new UnsupportedDataTypeException();
        }

        DoubleNode<T> newElement = new DoubleNode<>(element);

        if (this.isEmpty()) {
            this.front = this.rear = newElement;
        } else {

            if (((Comparable) element).compareTo(this.front.getElement()) < 0) {
                newElement.setNext(this.front);
                this.front.setPrevious(newElement);
                newElement.setPrevious(null);
                this.front = this.front.getPrevious();
            } else if (((Comparable) element).compareTo(this.rear.getElement()) > 0) {
                newElement.setPrevious(this.rear);
                this.rear.setNext(newElement);
                newElement.setNext(null);
                this.rear = this.rear.getNext();
            } else {
                DoubleNode<T> current = this.front;

                while (current != null && ((Comparable) element).compareTo(current.getElement()) > 0) {
                    current = current.getNext();
                }

                newElement.setNext(current.getNext());
                newElement.setPrevious(current);
                current.getNext().setPrevious(newElement);
                current.setNext(newElement);
            }
        }

        this.count++;

        this.modCount++;
    }

}
