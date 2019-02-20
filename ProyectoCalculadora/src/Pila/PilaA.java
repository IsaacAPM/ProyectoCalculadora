/*
*Isaac Alejandro Pimentel Morales
*184041
*07/02/2019
*/
package Pila;

import Exceptions.EmptyCollectionException;
import java.util.ArrayList;

/**
 *
 * @author isaac
 */
public class PilaA <T> implements PilaADT<T>{
    private T pila[];
    private int tope;
    private final int MAX = 20;
  
    public PilaA(){
        pila = (T[])new Object[MAX];
        tope = -1;
    }
    
    public PilaA(int max){
        pila = (T[])new Object[max];
        tope = -1;
    }
    
    public boolean isEmpty(){
        return tope == -1;
    }
    
    public void push(T dato){
        if(tope == (pila.length - 1)){
            expande();
        }
        
        tope++;
        pila[tope] = dato;
    }
    
    private void expande(){
        T nuevo [] = (T[])new Object[pila.length * 2];
        
        for(int i=0;i<=tope;i++){
            nuevo[i] = pila[i];
        }
        
        pila = nuevo;
    }
    
    public T pop(){
        if(isEmpty()){
            throw new EmptyCollectionException();
        }
        
        T resul;
        resul = pila[tope];
        pila[tope] = null;
        tope--;
        return resul;
    }
    
    public T peek(){
        if(isEmpty()){
            throw new EmptyCollectionException();
        }
        
        return pila[tope];
    }
    
    public void multiPop(int n){
        if(n <= (tope+1)){    
            for(int i=0;i<n;i++){
                pop();
            } 
        }   
    }
    
}

