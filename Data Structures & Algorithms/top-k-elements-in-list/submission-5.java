
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] frequency = new List[nums.length + 1];

        for(int i = 0; i < frequency.length; i++){
            frequency[i] = new ArrayList<>();
        }
        for(int num : nums){
            count.merge(num, 1, Integer::sum);
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            int number = entry.getKey();
            int howMany = entry.getValue();
            frequency[howMany].add(number);
        }

        int index = 0;
        int[] kUnique = new int[k];
        for(int i = frequency.length - 1; i >= 0; i--){
            for(int n : frequency[i]){
                kUnique[index++] = n;
                if(index == k){
                    return kUnique;
                }
            }
        }
        return kUnique;
    }
}