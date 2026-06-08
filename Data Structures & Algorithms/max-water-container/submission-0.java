class Solution {
    public int maxArea(int[] heights) {
        int leftP = 0, rightP = heights.length - 1;
        int area = 0;
        while(leftP < rightP){
            int tempArea = (rightP - leftP) * Math.min(heights[rightP], heights[leftP]);
            area = Math.max(tempArea, area);
            if(heights[leftP] < heights[rightP]){
                leftP++;
            }
            else{
                rightP--;
            }
        }
        return area;
    }
}
