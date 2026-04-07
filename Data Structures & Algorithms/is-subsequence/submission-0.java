class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()){
            return false;
        }
        StringBuilder sb=new StringBuilder();
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                sb.append(s.charAt(i));
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        if(sb.toString().equals(s)){
                return true;
            }
            return false;
        }
    }