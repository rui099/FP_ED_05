/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayUnorderedList;

import Interfaces.UnorderedListADT;
import PackagesExeptions.ElementNotFoundException;
import javax.activation.UnsupportedDataTypeException;

/**
 *
 * @author Paulo
 * @param <T>
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    @Override
    public void addToFront(T element) throws UnsupportedDataTypeException {
        if (this.rear == this.array.length) {
            this.expandCapacity();
        }

        int i = this.rear;

        while (i > 0) {
            this.array[i] = this.array[i - 1];
            i--;
        }

        this.array[0] = element;

        this.rear++;

        this.modCount++;
    }

    @Override
    public void addToRear(T element) throws UnsupportedDataTypeException {
        if (this.rear == this.array.length) {
            this.expandCapacity();
        }

        this.array[this.rear] = element;

        this.rear++;

        this.modCount++;
    }

    @Override
    public void addAfter(T element, T target) throws UnsupportedDataTypeException, ElementNotFoundException {
        if (this.rear == this.array.length) {
            this.expandCapacity();
        }

        int i = 0;
        int afterTarget = 1;

        while (i < this.rear && !(target.equals(this.array[i]))) {
            i++;
            afterTarget++;
        }

        if (i != this.rear) {
            int j = this.rear;

            while (j > afterTarget) {
                j--;
                this.array[j + 1] = this.array[j];
            }

            this.array[afterTarget] = element;

            this.rear++;

            this.modCount++;
        } else {
            throw new ElementNotFoundException();
        }

    }

    private void expandCapacity() throws UnsupportedDataTypeException {
        T[] expandStack = (T[]) (new Object[(this.array.length * 2)]);

        for (int i = 0; i < this.array.length; i++) {
            expandStack[i] = this.array[i];
        }

        this.array = expandStack;
    }

}
