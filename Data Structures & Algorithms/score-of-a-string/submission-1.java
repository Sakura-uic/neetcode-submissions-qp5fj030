class Solution {
    public int scoreOfString(String s) {
        int sum=0;
        int i=0;
        int j=i+1;
        while(i<s.length()&&j<s.length()){
            sum=sum+Math.abs(s.charAt(j)-s.charAt(i));
            i++;
            j++;
        }
        return sum;
    }
}