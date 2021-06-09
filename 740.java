
//Solution discussed in class
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums == null) return 0;
        int max =0;
        for(int num : nums){
            max = Math.max(num,max);
        }
        int[] arr = new int[max+1];
        for(int i=0; i<nums.length; i++){
            int index = nums[i];
            arr[index] += nums[i];
        }
        
        int skip=0;
        int take=arr[0];
        for(int i=0;i<arr.length;i++){
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+arr[i];
        }
        return Math.max(skip,take);
    }
}