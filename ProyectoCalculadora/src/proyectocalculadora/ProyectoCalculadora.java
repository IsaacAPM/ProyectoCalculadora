/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;

/**
 *
 * @author isaac
 */
public class ProyectoCalculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Calculadora.detectorErroresSintaxis("5+2"));
        System.out.println(Calculadora.detectorErroresSintaxis("(5+2)*6"));
        System.out.println(Calculadora.detectorErroresSintaxis("(5+6)(56+1"));
        System.out.println(Calculadora.detectorErroresSintaxis("(25*.89+(52*85))-(25/82)"));
        System.out.println(Calculadora.detectorErroresSintaxis("++++5-25.23.2"));
        System.out.println(Calculadora.detectorErroresSintaxis("++++.5+"));
        
        /*System.out.println(Calculadora.detectorErroresMath("5+5/0"));
        System.out.println(Calculadora.detectorErroresMath("5+5/0.5"));
        System.out.println(Calculadora.detectorErroresMath("5+5/05"));
        System.out.println(Calculadora.detectorErroresMath("5+5/0+6"));
        System.out.println(Calculadora.detectorErroresMath("5+5/0(5)"));
        System.out.println(Calculadora.detectorErroresMath("5+5/00000005"));
        System.out.println(Calculadora.detectorErroresMath("5+5/000000"));
        System.out.println(Calculadora.detectorErroresMath("5+5/0000001"));
        System.out.println(Calculadora.detectorErroresMath("5+5/00000020"));
        System.out.println(Calculadora.detectorErroresMath("5+5/001+5"));*/
        
        String cadena="50.2+2.5/(3+45)*3-6/2*(1+1)-1";
        System.out.println(Calculadora.detectorErroresSintaxis(cadena));
        /*System.out.println(Calculadora.convertirPostfija(cadena));
        System.out.println(Calculadora.convertirPostfija("(25+45)/85"));*/
        
        System.out.println(Calculadora.detectorErroresSintaxis("5+5/5+.5*(5+5)"));
        System.out.println(Calculadora.detectorErroresSintaxis("6/-3"));
        System.out.println(Calculadora.detectorErroresSintaxis("(2/1.0)"));
        System.out.println(Calculadora.detectorErroresSintaxis("2/1."));
    }
    
}
