/*
*Isaac Alejandro Pimentel Morales
*184041
*07/02/2019
*/
package Pila;

/**
 *
 * @author isaac
 */
public interface PilaADT <T>{
    public void push(T dato);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public void multiPop(int n);
    
}
