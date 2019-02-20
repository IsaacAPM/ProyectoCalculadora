package proyectocalculadora;
import Pila.PilaA;

/**
 *
 * @author isaac
 */
public class Calculadora {
    
    
    public static boolean detectorErroresSintaxis(String prob){
        boolean resp = true;
        boolean band = true;
        char pa;
        PilaA<Character> p= new PilaA<Character>();
        int i = 0;
        int j;
        int f = prob.length() - 1;
        
        if(prob.charAt(f) == '+' || prob.charAt(f) == '-' || prob.charAt(f) == '*' || prob.charAt(f) == '/'){
            resp = false;
        }
        
        while(i < prob.length() && resp && band){
            if(prob.charAt(i) == '*' || prob.charAt(i) == '/'){
                resp = false;
            } else if(prob.charAt(i) == '.'){
                if(prob.charAt(i+1) == '.' || prob.charAt(i) == '*' || prob.charAt(i) == '/' || prob.charAt(i) == '+' || prob.charAt(i) == '-'){
                    resp = false;
                } else {
                    band = false;
                }
            } else if( prob.charAt(i) != '+' && prob.charAt(i) != '-'){
                band = false;
            } else {
                i++;
            }
        }
        
        if(i > prob.length()){
            resp = false;
        }
        
        while(i<prob.length() && resp){
                    
            pa=prob.charAt(i);
            
            if(pa=='('||pa=='['||pa=='{'){
                p.push(pa);
            }
            else{
                switch (pa){
                    case ')':
                        if(!p.isEmpty()&&p.peek()=='('){
                            p.pop();
                        }
                        else{
                            resp=false;
                        }
                        break;
                    case ']':
                        if(!p.isEmpty()&&p.peek()=='['){
                            p.pop();
                        }
                        else{
                            resp=false;
                        }
                        break;
                    case '}':
                        if(!p.isEmpty()&&p.peek()=='{'){
                            p.pop();
                        }
                        else{
                            resp=false;
                        }
                        break;
                    case '.':
                        if(prob.charAt(i-1) == '+' || prob.charAt(i-1) == '-' || prob.charAt(i-1) == '*' || prob.charAt(i-1) == '/'){
                            if((i+1) < prob.length()){
                                if(prob.charAt(i+1) == '.' || prob.charAt(i+1) == '+' || prob.charAt(i+1) == '-' || prob.charAt(i+1) == '*' ||prob.charAt(i+1) == '/' || prob.charAt(i+1) == '(' || prob.charAt(i+1) == ')' || prob.charAt(i+1) == '[' || prob.charAt(i+1) == ']' || prob.charAt(i+1) == '{' || prob.charAt(i+1) == '}'){
                                    resp = false;
                                }
                            }else {
                                resp = false;
                            }
                        }
                        if((i+1) < prob.length()){
                            if(prob.charAt(i+1) == '.'){
                            resp = false;
                            } else {
                                j = i+1;
                                band = true;
                                while(j < prob.length() && band){
                                    if(prob.charAt(j) == '+' || prob.charAt(j) == '-' || prob.charAt(j) == '*' || prob.charAt(j) == '/' || prob.charAt(j) == '(' || prob.charAt(j) == ')' || prob.charAt(j) == '{' || prob.charAt(j) == '}' || prob.charAt(j) == '[' || prob.charAt(j) == ']'){
                                        band = false;
                                    } else if (prob.charAt(j) == '.'){
                                        resp = false;
                                        band = false;
                                    }
                                    j++;
                                }
                                i = j-1;
                            } 
                        }                  
                        break;
                    case '+':
                        if(prob.charAt(i+1) == '*' || prob.charAt(i+1) == '/'){
                            resp = false;
                        }
                        break;
                    case '-':
                        if(prob.charAt(i+1) == '*' || prob.charAt(i+1) == '/'){
                            resp = false;
                        }
                        break;
                    case '*':
                        if(prob.charAt(i+1) == '+' || prob.charAt(i+1) == '-' || prob.charAt(i+1) == '*' || prob.charAt(i+1) == '/'){
                            resp = false;
                        }
                        break;
                    case '/':
                        if(prob.charAt(i+1) == '+' || prob.charAt(i+1) == '-' || prob.charAt(i+1) == '*' || prob.charAt(i+1) == '/'){
                            resp = false;
                        }
                        break;
                }
            }
            
            i++;
        }
        
        if(resp&&!p.isEmpty()){
            resp=false;
        }
        
        return resp;
    }
    
    public static boolean detectorErroresMath(String prob){
        boolean resp = true;
        boolean band;
        int i = 0;
        int j;
        
        while(i < prob.length() && resp){
            if(prob.charAt(i) == '/' && (i+1) < prob.length()){
                if(prob.charAt(i+1) == '0'){
                    if((i+2) < prob.length()){
                        j = i+2;
                        band = true;
                        while(j < prob.length() && band){
                            if(prob.charAt(j) == '+' || prob.charAt(j) == '-' || prob.charAt(j) == '*' || prob.charAt(j) == '/' || prob.charAt(j) == '(' || prob.charAt(j) == ')' || prob.charAt(j) == '{' || prob.charAt(j) == '}' || prob.charAt(j) == '[' || prob.charAt(j) == ']'){
                                resp = false;
                                band = false;
                            } else if(prob.charAt(j) == '.'){
                                band = false;
                            } else if(prob.charAt(j) != '0'){
                                band = false;
                            } else {
                                j++;
                            }
                        }
                        if(j < prob.length()){
                            i = j-1;
                        } else{
                            resp = false;
                        }                    
                    } else {
                        resp = false;
                    }  
                }     
            }
            i++;
        }
        
        return resp;
    }
    
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
    
}//class
