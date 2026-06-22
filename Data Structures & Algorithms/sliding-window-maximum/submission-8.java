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
            //check if queue size is bigger than 0 (so we can remove safely) and if nums at smallest index (queue's last index is smallest) is smaller
            //than the new nums at R (nums[right]), then remove the last index in queue since its small and useless
            while(q.size() > 0 && nums[q.getLast()] < nums[right]){
                q.removeLast();
            }
            q.addLast(right);

            //expire the maximum in the queue once the window slides past it
            if(left > q.getFirst()){
                q.removeFirst();
            }

            //check if window is valid (size of k)
            if((right + 1) >= k){
                outputArray[left] = nums[q.getFirst()];
                left++;
            }
            right++;
        }

        return outputArray;
    }
}