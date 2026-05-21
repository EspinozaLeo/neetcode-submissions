class Solution {

    public String encode(List<String> strs) {
        // this is O(n^2) because every string concat will run n times. use StringBuilder
        // String encodedWords = "";
        // for(String s : strs){
        //     encodedWords = encodedWords + s.length() + "#" + s;
        // }
        // return encodedWords;
        
        //this is O(n)
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int delimeter = str.indexOf("#", i);
            String prefix = str.substring(i, delimeter);
            int wordSize = Integer.parseInt(prefix);
            String decodedWord = str.substring(delimeter + 1, delimeter + 1 + wordSize);
            decodedStrings.add(decodedWord);
            i = delimeter + 1 + wordSize;
        }

        return decodedStrings;
    }
}
