/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import PackagesExeptions.ElementNotFoundException;
import javax.activation.UnsupportedDataTypeException;

/**
 *
 * @author Paulo
 * @param <T>
 */
public interface UnorderedListADT<T> extends ListADT<T> {

    public void addToFront(T element) throws UnsupportedDataTypeException;

    public void addToRear(T element) throws UnsupportedDataTypeException;

    public void addAfter(T element, T target) throws UnsupportedDataTypeException, ElementNotFoundException;
}
