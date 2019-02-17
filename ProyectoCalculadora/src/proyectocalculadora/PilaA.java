/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;

//import proyectoCalculadora.EmptyCollectionException;

/**
 *
 * @author edi
 */
public class PilaA <T> implements PilaADT<T>{
    private  T[] pila;
    
    private int tope;
    
    private final int MAX=100;

    public PilaA() {
        pila= (T[])new Object[MAX];
        tope=-1;
    }
    
    public PilaA(int max) {
        pila= (T[])new Object[max];
        tope=-1;
    }

    @Override
    public void push(T dato) {
        if(tope == pila.length-1){
            expande();
        }
        tope++;
        pila[tope]=dato;
    }

    private void expande(){
        T[] nuevo=(T[])new Object [pila.length*2];
        
        for(int i=0; i<=tope; i++){
            nuevo[i]=pila[i];
        }
        pila=nuevo;
    }
    
    @Override
    public T pop() {
        if(isEmpty()){
            //throw new EmptyCollectionException();
        }
        T res= pila[tope];
       
        pila[tope]=null;
        tope--;
        
        return res;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            //throw new EmptyCollectionException();
        }
        T res= pila[tope];
    
        return res;
    }

    @Override
    public boolean isEmpty() {
        return tope==-1;
    }
}
