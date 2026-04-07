class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>st=new Stack<>();
        for(String op:operations){
            if(op.equals("+")){
                int top=st.pop();
                int next=st.peek();
                int total=top+next;
                st.push(top);
                st.push(total);
            }
            else if(op.equals("D")){
                st.push(2*st.peek());
            }
            else if(op.equals("C")){
                st.pop();
            }
            else{
                st.push(Integer.parseInt(op));//when no conditions are applied just push the given integer 
            }
        }
        int sum=0;
        for(int score:st){
            sum=sum+score;
        }
        return sum;
    }
}