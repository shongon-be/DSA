package leetcode.easy.stack.valid_parenthese;

import java.util.Stack;

public class ValidParentheses {

    static boolean isValid(String s){
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                st.push(c);
            }else {
                if(st.isEmpty()) return false;

                if(c == ')'){
                    if(st.pop() != '(') return false;
                } else if (c == ']') {
                    if(st.pop() != '[') return false;
                } else {
                    if(st.pop() != '{') return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({{{{}}}))";

        System.out.println(isValid(s));

    }
}
