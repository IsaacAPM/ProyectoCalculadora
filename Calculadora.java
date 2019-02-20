package problema10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Calculadora {
    
    public static String convertirPostfija(String cadena){
        PilaA res= new PilaA();
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
            
            if((int)c>=48&&(int)c<=57||c=='.'){
                j=i+1;
                b=true;
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
        
        while(!aux.isEmpty()){
            postfijo+= aux.pop() + " ";
        }
        
        return postfijo;
    }
}
