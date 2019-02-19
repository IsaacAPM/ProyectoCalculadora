package proyectocalculadora;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isaac
 */
public class Calculadora {
    
    public static boolean detectorErrores(String prob){
        boolean resp = true;
        boolean band = true;
        int i = 0;
        int f = prob.length() - 1;
        
        if(prob.charAt(f) == '+' && prob.charAt(f) == '-' && prob.charAt(f) == '*' && prob.charAt(f) == '/'){
            resp = false;
        }
        
        while(i < prob.length() && resp && band){
            if(prob.charAt(i) == '*' || prob.charAt(i) == '/'){
                resp = false;
            } else if( prob.charAt(i) != '+' && prob.charAt(i) != '-'){
                band = false;
            } else {
                i++;
            }
        }
        
        return resp;
    }
    
    
}
