package proyecto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *<pre>
 *
 * El algoritmo se encarga de recivir una expresión matemática, de la cual se revisa esté correcta 
 * y posteriormente se transforma a la notación postfija para facilitar su resolución
 *</pre>
 */
public class Calculadora {
    
    /**
     * <pre>
     *      Regresa una expresión matemática convertida a la notación postfija: 
     *              Notación infija: a-b*c   
     *              Notación postfija: abc*-
     * 
     *      @param cadena: Recibe una expresión matemática en su forma infija, la cual se hace pasar primero por el detector de errores.
     *      @return postfijo: Regresa en forma de String la expresión convertida, donde cada elemento está separado por un espacio.
     * 
     * </pre>
     */
    public static String convertirPostfija(String cadena){
        PilaA res= new PilaA();         //Ambas pila res y aux sirven para ir formando la expresión convertida, mientras que op guardará los operadores.
        PilaA aux = new PilaA();
        PilaA<Character> op= new PilaA();       
        int i=0;
        int j;
        char c;
        String cifra;
        boolean b;
        String postfijo="";
        
        while(i<cadena.length()){
            c=cadena.charAt(i);
            
            //Para extraer del String las cifras se recurrió al equivalente de los números en ascii, para facilitar su obtención.
            if((int)c>=48&&(int)c<=57||c=='.'){     
                j=i+1;
                b=true;
                
                //Mientras se traten de números pertenecientes a una sola cifra, el String ira recorriendo uno a uno y finalmente los extraera en su conjunto y agregará a la pila res.
                while(j<cadena.length()&&b){        
                    if((int)cadena.charAt(j)>=48&&(int)cadena.charAt(j)<=57||cadena.charAt(j)=='.'){
                       j++; 
                    }
                    else{
                        b=false;
                    }
                }
                if(j>=cadena.length()){
                    cifra=cadena.substring(i);
                }
                else{
                    cifra=cadena.substring(i,j);
                }
                
                res.push(cifra);
                i=j-1;

            }
            else{
                /*
                *A continuácion se repasan los casos en que se encuentren paréntesis, si es uno que abre se agregará a la pila op, 
                *por el contrario si cierra se extrerán los operadores que van contenidos dentro del paréntesis y se eliminará su homólogo,
                *de esta forma la expresión postfija no necesitá de paréntesis.
                */
                if(c=='('){
                    op.push(c);
                }
                else{
                    if(c==')'){
                        while(!op.isEmpty()&&op.peek()!='('){
                            res.push(op.pop());
                        }
                        
                        if(!op.isEmpty()&&op.peek()=='('){
                            op.pop();
                        }
                    }
                    else{
                        
                        /*
                        *Para los operadores, éstos se iran agregando o extrayendo según las reglas de jerarquía,
                        *si el que encuentra es de menor o igual jerarquía a los anteriores, estos se sustraeran y al final se agregará éste.
                        */
                        if(c=='+'||c=='-'){
                            while(!op.isEmpty()&&op.peek()!='('){
                                res.push(op.pop());
                            }
                        }
                        else{
                            b=true;
                            while(!op.isEmpty()&&op.peek()!='('&&b){
                                if(op.peek()=='*'||op.peek()=='/'){
                                    res.push(op.pop());
                                }
                                else{
                                    b=false;                                
                                }
                            }
                        }
                        op.push(c);
                    }
                }
           }
        
            i++;
        }
        
        while(!op.isEmpty()){
            res.push(op.pop());
        }
        
        while(!res.isEmpty()){
            aux.push(res.pop());
        }
        // Al formarse la expresión en la pila res, se recurre a la pila aux para que al ir extrayendo los elementos y agregarlos al String queden ordenados.
        while(!aux.isEmpty()){
            postfijo+= aux.pop() + " ";
        }
        
        return postfijo;
    }
}
