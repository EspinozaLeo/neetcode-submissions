class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        //slow and fast clash
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        //slow and slow2 clash at the entrance of the cycle
        int secondSlow = 0;
        while(true){
            slow = nums[slow];
            secondSlow = nums[secondSlow];
            if(slow == secondSlow) break;
        }

        return slow;
    }
}