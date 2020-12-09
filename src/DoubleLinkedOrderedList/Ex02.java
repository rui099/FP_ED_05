/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedOrderedList;

import Interfaces.OrderedListADT;
import PackagesExeptions.ElementNotFoundException;
import PackagesExeptions.EmptyCollectionException;
import java.util.Iterator;
import javax.activation.UnsupportedDataTypeException;

/**
 *
 * @author Paulo
 */
public class Ex02 {

    /**
     * @param args the command line arguments
     * @throws javax.activation.UnsupportedDataTypeException
     * @throws PackagesExeptions.EmptyCollectionException
     * @throws PackagesExeptions.ElementNotFoundException
     */
    public static void main(String[] args) throws UnsupportedDataTypeException, EmptyCollectionException, ElementNotFoundException {
        OrderedListADT<Integer> lista = new DoubleLinkedOrderedList<>();

        lista.add(2);
        lista.add(3);
        lista.add(1);
        lista.add(5);
        lista.add(-1);
        lista.add(1);

//        System.out.println(lista.toString());
//        System.out.println("Método size()1: " + lista.size());
//        System.out.println("Método first()1: " + lista.first());
//        System.out.println("Método last()1: " + lista.last());
//        lista.removeFirst();
//        System.out.println(lista.toString());
//        System.out.println("Método size()2: " + lista.size());
//        System.out.println("Método first()2: " + lista.first());
//        System.out.println("Método last()2: " + lista.last());
//        lista.removeLast();
//        System.out.println(lista.toString());
//        System.out.println("Método size()3: " + lista.size());
//        System.out.println("Método last()3: " + lista.last());
//        lista.remove(3);
//        System.out.println(lista.toString());
//        System.out.println("Método size(): " + lista.size());
//        System.out.println("Método last(): " + lista.last());
        Iterator<Integer> itr = lista.iterator();

        while (itr.hasNext()) {
            itr.next();

            itr.remove();
        }

        System.out.println(lista.toString());
    }

}
