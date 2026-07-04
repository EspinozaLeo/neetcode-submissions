class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arrA = nums1;
        int[] arrB = nums2;
        int total = arrA.length + arrB.length;
        int half = total / 2;

        //make sure A is the smaller array
        if(arrB.length < arrA.length){
            arrA = nums2;
            arrB = nums1;
        }

        int left = 0, right = arrA.length - 1;
        while(true){
            int medA = Math.floorDiv(left + right, 2); //for array A
            int medB = half - medA - 2;
            int leftA = (medA >= 0) ? arrA[medA] : Integer.MIN_VALUE; 
            int rightA = (medA + 1 < arrA.length) ? arrA[medA + 1] : Integer.MAX_VALUE;
            int leftB = (medB >= 0) ? arrB[medB] : Integer.MIN_VALUE;
            int rightB = (medB + 1 < arrB.length) ? arrB[medB + 1] : Integer.MAX_VALUE;

            if(leftA <= rightB && leftB <= rightA){
                if(total % 2 == 1){
                    return Math.min(rightA, rightB);
                }
                return ((Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0);
            } else if(leftA > leftB){
                right = medA - 1;
            } else{
                left = medA + 1;
            }
        }
    }
}