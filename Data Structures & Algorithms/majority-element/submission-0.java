class Solution {
    public int majorityElement(int[] nums) {
        int res=0;
        int n=nums.length;
        int count=n/2;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i)>count){
                res=i;
            }
        }
        return res;
    }
}