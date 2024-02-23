import java.util.*;

public class Stack {
    
    public static void main(String [] args){
        String str1="{([])}";
        String str2="{(])";
        String str3="{([)]}";
        System.out.println(res(str1));
        System.out.println(res(str2));
        System.out.println(res(str3)); 
    }
    public static boolean res(String str){

        Deque<Character> st = new LinkedList<Character>();
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(ch=='('){
                st.push(')');
            }else if(ch=='{'){
                st.push('}');
            }else if(ch=='['){
                st.push(']');
            }else{
                if(st.peek()!=ch){
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        return st.isEmpty();

    }
}
