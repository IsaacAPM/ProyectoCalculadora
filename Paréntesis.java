/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema10;

/**
 *
 * @author ifonsecaz
 */
public class Paréntesis {
    public static boolean estanBalanceados(String op){
        PilaA<Character> p= new PilaA<Character>();
        char pa;
        boolean res= true;
        int i=0;
        
        while(i<op.length()&&res){
                    
            pa=op.charAt(i);
            
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
                            res=false;
                        }
                        break;
                    case ']':
                        if(!p.isEmpty()&&p.peek()=='['){
                            p.pop();
                        }
                        else{
                            res=false;
                        }
                        break;
                    case '}':
                        if(!p.isEmpty()&&p.peek()=='{'){
                            p.pop();
                        }
                        else{
                            res=false;
                        }
                        break;
                    default:
                }
            }
            
            i++;
        }
        
        if(res&&!p.isEmpty()){
            res=false;
        }
       
        return res;     
    }
}
