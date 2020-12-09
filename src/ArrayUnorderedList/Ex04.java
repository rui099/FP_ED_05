/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayUnorderedList;

import Interfaces.UnorderedListADT;
import PackagesExeptions.ElementNotFoundException;
import java.util.Iterator;
import javax.activation.UnsupportedDataTypeException;

/**
 *
 * @author Paulo
 */
public class Ex04 {

    /**
     * @param args the command line arguments
     * @throws javax.activation.UnsupportedDataTypeException
     * @throws PackagesExeptions.ElementNotFoundException
     */
    public static void main(String[] args) throws UnsupportedDataTypeException, ElementNotFoundException {
        UnorderedListADT<Integer> lista = new ArrayUnorderedList<>();

        lista.addToFront(1);
        lista.addToRear(0);
        lista.addToFront(2);
        lista.addAfter(5, 1);
//        lista.addAfter(5, 100);

        Iterator<Integer> it = lista.iterator();

        while (it.hasNext()) {
            it.next();
            
            it.remove();
        }

        System.out.println(lista.toString());
    }

}
