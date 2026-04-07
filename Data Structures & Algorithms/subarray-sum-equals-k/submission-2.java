class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int n=nums.length;
        int[]prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int target=prefix[i]-k;
            if(map.containsKey(target)){
                ans=ans+map.get(target);
            }
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return ans;
    }
}