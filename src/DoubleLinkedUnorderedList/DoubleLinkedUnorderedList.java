/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedUnorderedList;

import Interfaces.UnorderedListADT;
import PackagesExeptions.ElementNotFoundException;
import javax.activation.UnsupportedDataTypeException;

/**
 *
 * @author Paulo
 * @param <T>
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

    @Override
    public void addToFront(T element) throws UnsupportedDataTypeException {

        DoubleNode<T> newElement = new DoubleNode<>(element);

        if (this.isEmpty()) {
            this.front = this.rear = newElement;
        } else {
            newElement.setNext(this.front);
            this.front.setPrevious(newElement);
            newElement.setPrevious(null);
            this.front = this.front.getPrevious();
        }

        this.count++;

        this.modCount++;
    }

    @Override
    public void addToRear(T element) throws UnsupportedDataTypeException {

        DoubleNode<T> newElement = new DoubleNode<>(element);

        if (this.isEmpty()) {
            this.front = this.rear = newElement;
        } else {
            newElement.setPrevious(this.rear);
            this.rear.setNext(newElement);
            newElement.setNext(null);
            this.rear = this.rear.getNext();
        }

        this.count++;

        this.modCount++;
    }

    @Override
    public void addAfter(T element, T target) throws UnsupportedDataTypeException, ElementNotFoundException {

        DoubleNode<T> newElement = new DoubleNode<>(element);

        if (this.isEmpty()) {
            this.front = this.rear = newElement;
        } else {

            DoubleNode<T> current = this.front;

            while (current != null && !(target.equals(current.getElement()))) {
                current = current.getNext();
            }

            if (current != null) {
                newElement.setNext(current.getNext());
                newElement.setPrevious(current);
                current.getNext().setPrevious(newElement);
                current.setNext(newElement);
            } else {
                throw new ElementNotFoundException();
            }

        }

        this.count++;

        this.modCount++;
    }

}
