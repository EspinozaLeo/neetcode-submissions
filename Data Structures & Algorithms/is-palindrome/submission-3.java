class Solution {
    public boolean isPalindrome(String s) {
        // String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        // StringBuilder sb = new StringBuilder(cleaned);
        // int j = sb.length() - 1;
        // if(sb.length() == 0) return true;

        // for(int i = 0; i < (sb.length())/2; i++){
        //     if(sb.charAt(i) == sb.charAt(j)){
        //         j = j - 1;
        //         continue;
        //     }
        //     else{
        //         return false;
        //     }
        // }
        // return true;

        int left = 0, right = s.length() - 1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
