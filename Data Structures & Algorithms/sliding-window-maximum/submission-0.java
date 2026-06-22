class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] outputArray = new int[nums.length - k + 1];
        int left = 0, right = k - 1, i = 0;
        while(right < nums.length){
            outputArray[i] = Arrays.stream(Arrays.copyOfRange(nums, left, right + 1)).max().getAsInt();
            i++;
            left++;
            right++;
        }
        return outputArray;
    }
}
