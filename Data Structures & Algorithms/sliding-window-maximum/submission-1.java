class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int[] outputArray = new int[nums.length - k + 1];
        // int left = 0, right = k - 1, i = 0;
        // while(right < nums.length){
        //     outputArray[i] = Arrays.stream(Arrays.copyOfRange(nums, left, right + 1)).max().getAsInt();
        //     i++;
        //     left++;
        //     right++;
        // }
        // return outputArray;
        
        int numsLength = nums.length;
        int[] outputArray = new int[numsLength - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int left = 0, right = 0;
        while(right < numsLength){
            while(!q.isEmpty() && nums[q.getLast()] < nums[right]){
                q.removeLast();
            }
            q.addLast(right);

            if(left > q.getFirst()){
                q.removeFirst();
            }

            if((right + 1) >= k){
                outputArray[left] = nums[q.getFirst()];
                left++;
            }
            right++;
        }

        return outputArray;
    }
}