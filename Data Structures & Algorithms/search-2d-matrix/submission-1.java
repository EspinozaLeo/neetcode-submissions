class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            int row = mid / n, column = mid % n;
            int value = matrix[row][column];
            //if matrix[row][column] == target return true
            if (value == target) return true;
            //if target < matrix[row][column] (ignore everything to the right of mid)
            else if(target < value){
                right = mid - 1;
            //if target > matrix[row][column] (ignore everything to the left of mid)
            } else{
                left = mid + 1;
            }
        }
        return false;
    }
}