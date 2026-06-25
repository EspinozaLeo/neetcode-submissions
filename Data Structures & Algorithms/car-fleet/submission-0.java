class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        // sort by position descending (closest to target first)
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Deque<Double> stack = new ArrayDeque<>();
        for (int[] c : cars) {
            double time = (double) (target - c[0]) / c[1];
            if (stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            }
        }
        return stack.size();
    }
}