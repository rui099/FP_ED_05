/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedUnorderedList;

import Interfaces.UnorderedListADT;
import PackagesExeptions.ElementNotFoundException;
import java.util.Iterator;
import javax.activation.UnsupportedDataTypeException;

/**
 *
 * @author Paulo
 */
public class Ex05 {

    /**
     * @param args the command line arguments
     * @throws javax.activation.UnsupportedDataTypeException
     * @throws PackagesExeptions.ElementNotFoundException
     */
    public static void main(String[] args) throws UnsupportedDataTypeException, ElementNotFoundException {
        UnorderedListADT<Integer> lista = new DoubleLinkedUnorderedList<>();

        lista.addToFront(1);
        lista.addToRear(2);
        lista.addToFront(0);
        lista.addToRear(3);
        lista.addToRear(4);
        lista.addToRear(5);
        lista.addAfter(7, 1);

        Iterator<Integer> itr = lista.iterator();

        while (itr.hasNext()) {
            itr.next();

            itr.remove();
        }

        System.out.println(lista.toString());
    }

}
