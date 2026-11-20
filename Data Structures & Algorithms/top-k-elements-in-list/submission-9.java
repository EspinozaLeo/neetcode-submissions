
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] frequency = new List[nums.length + 1];

        //create an empty ArrayList at each index
        for(int i = 0; i < frequency.length; i++){
            frequency[i] = new ArrayList<>();
        }
        //key is the number and value is how many times it appears
        for(int num : nums){
            count.merge(num, 1, Integer::sum);
        }
        //insert into frequency[howMany] the number
        //for example if [5, 6, 5, 5, 4, 1, 6], then frequency[3] = 5, frequency[2] = 6, frequency[1] = [4, 1]
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            int number = entry.getKey();
            int howMany = entry.getValue();
            frequency[howMany].add(number);
        }
        //create kUnique array and walk backwards on frequency (highest number/index is the highest numbers seen)
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