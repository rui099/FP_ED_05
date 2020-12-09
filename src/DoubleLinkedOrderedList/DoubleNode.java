/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedOrderedList;

/**
 *
 * @author Paulo
 */
/**
 * DoubleNode represents a node in a doubly linked list.
 *
 * @param <T>
 */
public class DoubleNode<T> {

    private DoubleNode<T> next;
    private T element;
    private DoubleNode<T> previous;

    public DoubleNode() {
        next = null;
        element = null;
        previous = null;
    }

    public DoubleNode(T elem) {
        next = null;
        element = elem;
        previous = null;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

}
