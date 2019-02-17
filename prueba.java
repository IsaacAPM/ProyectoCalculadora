/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;

/**
 *
 * @author Israel Fonseca Zárate
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculadora a= new Calculadora();
        String b="0";
        String c="1";
        String d="2";
        String e="3";
        String f="4";
        String g="5";
        String h="6";
        String i="7";
        String j="8";
        String k="9";
        String l=".";
        String m="(";
        String n=")";
        String ñ="+";
        String o="-";
        String p="*";
        String q="/";
        
        
        
        a.agregaCaracter(e);
        a.agregaCaracter(g);
        a.agregaCaracter(l);
        a.agregaCaracter(g);
        a.manejoOperadores(o);
        a.agregaCaracter(g);
        a.manejoOperadores(p);
        a.agregaCaracter(d);
        a.manejoOperadores(q);
        a.agregaCaracter(e);
        a.manejoOperadores(o);
        a.agregaCaracter(c);
        a.manejoOperadores(o);
        a.manejoOperadores(m);
        a.agregaCaracter(g);
        a.manejoOperadores(ñ);
        a.agregaCaracter(e);
        a.manejoOperadores(n);
        a.manejoOperadores(p);
        a.agregaCaracter(d);
        
        System.out.println(a.resuelve());
    
        
    }
    
}
