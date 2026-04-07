class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int n=nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i=1; i<n; i++){
            pre[i] = nums[i] + pre[i-1];
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            int target = pre[i]-k;
            if(map.containsKey(target)){
                ans+=map.get(target);
            }
            map.put(pre[i], map.getOrDefault(pre[i], 0)+1);
        }
        return ans;
    }
}