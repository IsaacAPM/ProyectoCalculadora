package proyectocalculadora;
import Pila.PilaA;

/**
 *
 * @author isaac
 */
public class Calculadora {
    
    /**<pre>
     * Revisa la sintaxis de una expresión matemática
     * que únicamente usa las 4 operaciones aritméticas
     * básicas.
     * </pre>
     * @param prob Expresión matemática a revisar
     * @return <ul>
     *      <li>true: si la sintaxis de la expresión es correcta</li>
     *      <li>false: si la sintaxis de la expresión es incorrecta</li>
     * </ul>
     */
    public static boolean detectorErroresSintaxis(String prob){
        boolean resp = true;
        boolean band = true;
        char pa;
        PilaA<Character> p= new PilaA<Character>();
        int i = 0;
        int j;
        int f = prob.length() - 1;
        
        //verifico que el ultimo caracter de la expresión no sea un operador o un parentesis de cierre
        if(prob.charAt(f) == '+' || prob.charAt(f) == '-' || prob.charAt(f) == '*' || prob.charAt(f) == '/' || prob.charAt(f) == '('){
            resp = false;// en caso de serlo, la respuesta es false
        }
        
        //comienso a revisar la expresión desde el inico buscando operadores + y -, ya que estos no afectan al inico
        //dejo de revisar di encuntro un número o un operador diferente a + y - 
        while(i < prob.length() && resp && band){
            //verifico si el termino es un *,/ o )
            if(prob.charAt(i) == '*' || prob.charAt(i) == '/' || prob.charAt(i) == ')'){
                resp = false;// en caso de serlo la respuesta es false
            } else if(prob.charAt(i) == '.'){//si no fue lo anterior verifico si es un punto
                //si si es un punto reviso si el siguiente es otro punto o un operador
                if(prob.charAt(i+1) == '.' || prob.charAt(i) == '*' || prob.charAt(i) == '/' || prob.charAt(i) == '+' || prob.charAt(i) == '-'){
                    resp = false;//en caso de serlo la respuesta es false
                } else {//si no fue nada de lo anterior entonses debe ser un número o un parentesis
                    band = false;//salgo del while
                }
            } else if( prob.charAt(i) != '+' && prob.charAt(i) != '-'){//si no fue nada de lo anterior reviso que no sea ni un + ni un -
                band = false;//si no es etonses salgo del while
            } else {
                i++;// si si es un + o un -, aumeto 1 a la i para revisar el siguiente
            }
        }
        
        //si al final se salio del while por que recorrio toda la cadena entonses quiere decir
        //que la expresión solo tiene operadores + y -
        if(i > prob.length()){
            resp = false;// si es el caso la respuesta es false
        }
        
        //si no fue el caso anterior entonses quiere decir que encontro un número o un parentesis
        //prosedo a revisar que los parentesis esten bien balanseados y que no haya otros errores de
        //sintaxis
        while(i<prob.length() && resp){
                    
            pa=prob.charAt(i);
            
            if(pa=='('){
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
                    case '.':
                        //en caso de que el caracter altual sea un punto reviso si antes de el hay un operador
                        if(prob.charAt(i-1) == '+' || prob.charAt(i-1) == '-' || prob.charAt(i-1) == '*' || prob.charAt(i-1) == '/'){
                            //si si hay resviso hay un caracter despues
                            if((i+1) < prob.length()){
                                //si si hay reviso que es ese caracter
                                if(prob.charAt(i+1) == '.' || prob.charAt(i+1) == '+' || prob.charAt(i+1) == '-' || prob.charAt(i+1) == '*' ||prob.charAt(i+1) == '/' || prob.charAt(i+1) == '(' || prob.charAt(i+1) == ')'){
                                    resp = false;//si no es un numero la respuesta es false
                                }
                            } else {//si no hay otro caracter despues la respuesta es false
                                resp = false;
                            }
                        }
                        //si lo que esta antes no es un operador y si hay otro caracter despues
                        if((i+1) < prob.length()){
                            //reviso que hay en los caracteres siguietes, si es alguno de los siguientes casos la respuesta sera false
                            //5.2.2, 5..2, etc. 
                            if(prob.charAt(i+1) == '.'){
                            resp = false;
                            } else {
                                j = i+1;
                                band = true;
                                while(j < prob.length() && band){
                                    if(prob.charAt(j) == '+' || prob.charAt(j) == '-' || prob.charAt(j) == '*' || prob.charAt(j) == '/' || prob.charAt(j) == '(' || prob.charAt(j) == ')'){
                                        band = false;
                                    } else if (prob.charAt(j) == '.'){
                                        resp = false;
                                        band = false;
                                    }
                                    j++;
                                }
                                i = j-2;
                            } 
                        }                  
                        break;
                    //reviso los casos en los que el caracter actual es un operador
                    //solo sera false la respuesta si el siguiente caracter es otro
                    //operador
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
                        if(prob.charAt(i+1) == '+' || prob.charAt(i+1) == '*' || prob.charAt(i+1) == '/'){
                            resp = false;
                        }
                        break;
                    case '/':
                        if(prob.charAt(i+1) == '+' || prob.charAt(i+1) == '*' || prob.charAt(i+1) == '/'){
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
        
        return resp;//regreso la respuesta final
    }
    
    /**<pre>
     * Revisa las operaciones de una expresión matemática
     * que únicamente usa las 4 operaciones aritméticas
     * básicas; busca que no se comentan erros matemáticos
     * como unicamente se usan las 4 operaciones basicas el 
     * único error posible es dividir entre 0.
     * </pre>
     * @param prob Expresión matemática a revisar
     * @return <ul>
     *      <li>true: si nunca se cometio un error matemático(dividir entre 0)</li>
     *      <li>false: si se cometio un error matemático(dividir entre 0)</li>
     * </ul>
     */
    public static boolean detectorErroresMath(String prob){
        boolean resp = true;
        boolean band;
        int i = 0;
        int j;
        
        //busco en la cadena un operador de división
        while(i < prob.length() && resp){
            if(prob.charAt(i) == '/' && (i+1) < prob.length()){// caundo lo ecuentro me aseguro que exista un caracter despues
                if(prob.charAt(i+1) == '0'){//si el caracter que sigue es 0 reviso que caso es
                    if((i+2) < prob.length()){
                        j = i+2;
                        band = true;
                        while(j < prob.length() && band){
                            if(prob.charAt(j) == '+' || prob.charAt(j) == '-' || prob.charAt(j) == '*' || prob.charAt(j) == '/' || prob.charAt(j) == '(' || prob.charAt(j) == ')'){
                                resp = false; //este if revisa el caso x/000+y, la cantidad de 0 en este caso debe ser mayor igual a 1 
                                band = false; //este caso indica que hay un error
                            } else if(prob.charAt(j) == '.'){
                                band = false; //este if revisa el caso x/0.y, este caso no es un error 
                            } else if(prob.charAt(j) != '0'){
                                band = false; //este if revisa el caso x/000y, este caso tampoco debe marcar error
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
        
        return resp;// regresa la respuesta final
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
