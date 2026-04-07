

class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){

            /*if(c == '(' || c == '{' || c == '['){
                st.push(c);
            } 
            else {

                if(st.isEmpty()){
                    return false;
                }

                char top = st.pop();

                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }*/
            if(c=='(')st.push(')');
            else if(c=='[')st.push(']');
            else if(c=='{')st.push('}');
            else{
                if(st.isEmpty()||st.pop()!=c){
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}