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
public class Calculadora {
    private PilaA <String> expresionPostfija;
    private String cifra;
    private PilaA <String> operadores;
    private String últimoOp;
    
    public Calculadora(){
        cifra="";
        últimoOp="";
        expresionPostfija= new PilaA();
        operadores= new PilaA();
    }    

    public String getCifra() {
        return cifra;
    }
    
    
    
    public String agregaCaracter(String num){
        if(num.equals(".")&&cifra.contains(".")){
            limpiar();
            //Excepción ha introducido dos puntos decimales
        }
        else{
            cifra+=num;
        }
        
        return cifra;
    }
    
    private void agregaCifra(){
        expresionPostfija.push(cifra);
        cifra="";
    }
    
    private void limpiar(){
        while(!operadores.isEmpty()){
            operadores.pop();
        }
        while(!expresionPostfija.isEmpty()){
            expresionPostfija.pop();
        }
        cifra="";
        últimoOp="";
    }
    
    public void manejoOperadores(String op){
        
        if(!cifra.equals("")){
            agregaCifra();
        }
        else{
            if(últimoOp.equals("+")||últimoOp.equals("-")||últimoOp.equals("*")||últimoOp.equals("/")){
                if(op.equals("+")||op.equals("-")||op.equals("/")||op.equals("*")){
                    limpiar();
                    //Excepción Se introdujo dos operadores seguidos o uno al inicio
                }    
            }
        }
        
        if(op.equals(")")){
               
            while(!operadores.isEmpty()&&!operadores.peek().equals("(")){
                    expresionPostfija.push(operadores.pop());
            }   
            if(!operadores.isEmpty()&&operadores.peek().equals("(")){
                operadores.pop();   //Este último será el paréntesis (
            }
            else{
                limpiar();
                //Excepción: Falta un paréntesis "("
            }
        }
        else{
            if(op.equals("+")||op.equals("-")){
                while(!operadores.isEmpty()&&!operadores.peek().equals("(")){
                    expresionPostfija.push(operadores.pop());
                }
            }
            else{
                if(op.equals("*")||op.equals("/")){
                    while(!operadores.isEmpty()&&(operadores.peek().equals("*")||operadores.peek().equals("/"))){
                        expresionPostfija.push(operadores.pop());
                    }
                }
            }
            operadores.push(op);
        }
        últimoOp=op;
    }
    
    
    public double resuelve(){
        double res=0;
        PilaA <String> aux = new PilaA();
        String op;
        double a,b;
        
        if(!cifra.equals("")){
                agregaCifra();
        }
        while(!operadores.isEmpty()){
            if(operadores.peek().equals("(")){
                limpiar();
                //Excepción falto cerrar paréntesis
            }
            expresionPostfija.push(operadores.pop());
        }
        while(!expresionPostfija.isEmpty()){
            aux.push(expresionPostfija.pop());
        }
        while(!aux.isEmpty()){
            op=aux.peek();
            
            if(op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/")){
                a=Double.parseDouble(expresionPostfija.pop());
                b=Double.parseDouble(expresionPostfija.pop());
                
                switch(op){
                    case "+":
                        res=b+a;
                        break;
                    case "-":
                        res=b-a;
                        break;
                    case "*":
                        res=b*a;
                        break;
                    case "/":
                        res=b/a;
                        break;
                }
                expresionPostfija.push("" + res);
                aux.pop();
            }
            else{
                expresionPostfija.push(aux.pop());
            }
        }
        
        return res;
    }
}
