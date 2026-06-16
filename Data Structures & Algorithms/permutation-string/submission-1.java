class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length() || s2.length() == 0) return false;
        if(s1.length() == 0) return true;

        int s1Length = s1.length(), s2Length = s2.length();
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        for(int i = 0; i < s1Length; i++){
            array1[s1.charAt(i) - 'a']++;
            array2[s2.charAt(i) - 'a']++;
        }

        for(int i = s1Length; i < s2Length; i++){
            if(Arrays.equals(array1, array2)) return true;
            array2[s2.charAt(i - s1Length) - 'a']--;
            array2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(array1, array2)) return true;
        return false;
    }
}
