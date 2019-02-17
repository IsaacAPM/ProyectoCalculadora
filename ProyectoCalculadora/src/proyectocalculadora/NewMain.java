/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;

/**
 *
 * @author Israel Fonseca Zárat
 */
public class NewMain {

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
        a.agregaCaracter(d);
        a.manejoOperadores(p);
        a.agregaCaracter(f);
        a.manejoOperadores(ñ);
        a.agregaCaracter(h);
        a.agregaCaracter(l);
        a.agregaCaracter(k);
        a.manejoOperadores(o);
        a.agregaCaracter(i);
        a.agregaCaracter(j);
        a.manejoOperadores(q);
        a.agregaCaracter(f);
        a.manejoOperadores(o);
        a.agregaCaracter(h);
        
        System.out.println(a.resuelve());
    }
    
}
