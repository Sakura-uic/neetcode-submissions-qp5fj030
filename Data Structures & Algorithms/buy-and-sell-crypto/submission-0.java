class Solution {
    public int maxProfit(int[] prices) {
        int max_p=0;
        int n=prices.length;
        int i=0,j=1;
        while(j<n){
            if(prices[i]<prices[j]){
            int p=prices[j]-prices[i];
            max_p=Math.max(max_p,p);
        }
        else{
            i=j;
        }
        j++;
        }
        return max_p;
    }
}
