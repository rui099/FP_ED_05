/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayOrderedList;

import Interfaces.OrderedListADT;
import PackagesExeptions.ElementNotFoundException;
import PackagesExeptions.EmptyCollectionException;
import java.util.Iterator;
import javax.activation.UnsupportedDataTypeException;

/**
 *
 * @author Paulo
 */
public class Ex01 {

    /**
     * @param args the command line arguments
     * @throws javax.activation.UnsupportedDataTypeException
     * @throws PackagesExeptions.EmptyCollectionException
     * @throws PackagesExeptions.ElementNotFoundException
     */
    public static void main(String[] args) throws UnsupportedDataTypeException, EmptyCollectionException, ElementNotFoundException {
//        OrderedListADT<Integer> lista = new ArrayOrderedList<>();
//
//        lista.add(3);
//
//        System.out.println("Adicionando um elemento :");
//        System.out.println(lista.toString());
//
//        lista.add(5);
//
//        System.out.println("Adicionando um elemento a frente :");
//        System.out.println(lista.toString());
//
//        lista.add(2);
//
//        System.out.println("Adicionando um elemento atraz :");
//        System.out.println(lista.toString());
//
//        lista.add(6);
//
//        System.out.println("Adicionando um elemento a frente do da frente :");
//        System.out.println(lista.toString());
//
//        lista.add(1);
//
//        System.out.println("Adicionando um elemento atraz do de atraz :");
//        System.out.println(lista.toString());
//
//        lista.add(4);
//
//        System.out.println("Adicionando um elemento no meio :");
//        System.out.println(lista.toString());
//
////        System.out.println(lista.toString());
////        System.out.println("Método size()1: " + lista.size());
////        System.out.println("Método first()1: " + lista.first());
////        System.out.println("Método last()1: " + lista.last());
////        lista.removeFirst();
////        System.out.println(lista.toString());
////        System.out.println("Método size()2: " + lista.size());
////        System.out.println("Método first()2: " + lista.first());
////        System.out.println("Método last()2: " + lista.last());
////        lista.removeLast();
////        System.out.println(lista.toString());
////        System.out.println("Método size()3: " + lista.size());
////        System.out.println("Método last()3: " + lista.last());
////        lista.remove(3);
////        System.out.println(lista.toString());
////        System.out.println("Método size(): " + lista.size());
////        System.out.println("Método last(): " + lista.last());
////
//        Iterator<Integer> itr = lista.iterator();
//
//        System.out.println("Iterator:");
//
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        }
        OrderedListADT<String> listaVazia = new ArrayOrderedList<>();
        /**
         * Funciona Execção
         */

        Iterator<String> itr1 = listaVazia.iterator();

        itr1.remove();
//
//        Iterator<Integer> it = lista.iterator();
//
//        while (it.hasNext()) {
//            it.next();
//
//            it.remove();
//        }
//
//        System.out.println("Iterator :");
//        System.out.println(lista.toString());
    }

}
