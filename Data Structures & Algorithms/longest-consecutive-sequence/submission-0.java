class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        int longestSeq = 0;
        for(int num : nums){
            numbers.add(num);
        }

        for(int num : numbers){
            if(numbers.contains(num - 1)){
                continue;
            } else{
                int seq = 1;
                int seqNum = num + 1;
                while(numbers.contains(seqNum)){
                    seq++;
                    seqNum++;
                }
                longestSeq = Math.max(longestSeq, seq);
            }
        }
        return longestSeq;
    }
}
