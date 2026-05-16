class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> charCountS = new HashMap<>();
        Map<Character, Integer> charCountT = new HashMap<>();
        for(char c : s.toCharArray()){
            charCountS.merge(c, 1, Integer::sum);
        }
        for(char d : t.toCharArray()){
            charCountT.merge(d, 1, Integer::sum);
        }
        return charCountS.equals(charCountT);
    }
}
