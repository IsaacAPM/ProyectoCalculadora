/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema10;

/**
 *
 * 
 */
public class b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena="50.2+2.5/(3+45)*3-6/2*(1+1)-1";
        
        System.out.println(Calculadora.convertirPostfija(cadena));
        

    }
    
}
