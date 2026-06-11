class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();
        int count = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            while(characters.contains(s.charAt(right))){
                characters.remove(s.charAt(left));
                left++;
            }
            count = Math.max(count, right - left + 1);
            characters.add(s.charAt(right));
        }
        return count;
        
    }
}
