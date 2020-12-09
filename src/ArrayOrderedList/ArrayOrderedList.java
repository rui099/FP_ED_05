/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayOrderedList;

import Interfaces.OrderedListADT;
import javax.activation.UnsupportedDataTypeException;

/**
 *
 * @author Paulo
 * @param <T>
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    @Override
    public void add(T element) throws UnsupportedDataTypeException {
        if (!(element instanceof Comparable)) {
            throw new UnsupportedDataTypeException();
        }
        
        if (this.rear == this.array.length) {
            this.expandCapacity();
        }
        
        int i = 0;

        while (i < this.rear && ((Comparable) element).compareTo(this.array[i]) > 0) {
            i++;
        }
        
        int rearCopy = this.rear;
        
        while (rearCopy > i) {
            this.array[rearCopy] = this.array[rearCopy - 1];
            rearCopy--;
        }

        this.array[i] = element;

        this.rear++;

        this.modCount++;
    }

    private void expandCapacity() {
        T[] expandStack = (T[]) (new Object[(this.array.length * 2)]);

        for (int i = 0; i < this.array.length; i++) {
            expandStack[i] = this.array[i];
        }

        this.array = expandStack;
    }

}
