class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] hotterDays = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int tempIndex = stack.pop();
                hotterDays[tempIndex] = i - tempIndex;
            }
            stack.push(i);
        }

        return hotterDays;
    }
}
