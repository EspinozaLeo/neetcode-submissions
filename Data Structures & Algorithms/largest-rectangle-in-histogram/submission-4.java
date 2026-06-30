class Solution {
    public int largestRectangleArea(int[] heights) {
        int arrLength = heights.length;
        int area = 0;
        Deque<int[]> stack = new ArrayDeque<>(); //{index, height}
        for(int i = 0; i < arrLength; i++){
            int start = i;
            while(!stack.isEmpty() && heights[i] < stack.peek()[1]){
                int[] popped = stack.pop();
                int index = popped[0], height = popped[1];
                area = Math.max((i - index) * height, area);
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] bar : stack) {
            area = Math.max(area, bar[1] * (arrLength - bar[0]));
        }
        return area;
    }
}