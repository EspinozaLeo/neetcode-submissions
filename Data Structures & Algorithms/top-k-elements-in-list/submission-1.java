
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int num : nums){
            numMap.merge(num, 1, Integer::sum);
        }

        int mapSize = numMap.size();
        int counter = 0;
        int[] kUnique = new int[k];
        for(int i = 0; i < mapSize; i++){
            Map.Entry<Integer, Integer> maxEntry = numMap.entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .orElse(null);

            if (maxEntry != null) {
                System.out.println("Key: " + maxEntry.getKey());
                System.out.println("Max Value: " + maxEntry.getValue());
                kUnique[counter] = maxEntry.getKey();
                counter++;
                numMap.remove(maxEntry.getKey());
            }
            if(counter >= k){
                break;
            }
        }
        return kUnique;
    }
}
