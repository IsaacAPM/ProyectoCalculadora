/*
*Isaac Alejandro Pimentel Morales
*184041
*07/02/2019
*/
package Exceptions;

/**
 *
 * @author isaac
 */
public class EmptyCollectionException extends RuntimeException{
    
    public EmptyCollectionException(){
        super("Colección vacia");
    }
    
    public EmptyCollectionException(String mensage){
        super(mensage);
    }
    
}
