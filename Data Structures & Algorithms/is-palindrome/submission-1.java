class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        StringBuilder sb = new StringBuilder(cleaned);
        int j = sb.length() - 1;
        if(sb.length() == 0) return true;
        
        for(int i = 0; i < (s.length())/2; i++){
            if(sb.charAt(i) == sb.charAt(j)){
                j = j - 1;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
