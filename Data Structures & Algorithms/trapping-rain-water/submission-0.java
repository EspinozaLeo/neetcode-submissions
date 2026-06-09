class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;

        int water = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        while(left < right){
            if(maxLeft < maxRight){
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                water = water + maxLeft - height[left];
            } else{
                right--;
                maxRight = Math.max(maxRight, height[right]);
                water = water + maxRight - height[right];
            }
        }
        return water;
    }
}
