class TimeMap {
    private HashMap<String, ArrayList<Entry>> map;

    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        ArrayList<Entry> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String result = "";
        while(left <= right){
            int mid = left + ((right - left) / 2);
            if(list.get(mid).timestamp <= timestamp){
                result = list.get(mid).value;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return result;
    }
}
