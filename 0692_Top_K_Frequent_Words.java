5
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        HashMap<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((s1,s2)->{
            if(map.get(s1)==map.get(s2)){
                return s1.compareTo(s2);
            }
            else{
                return map.get(s2)-map.get(s1);
            }
        });
        pq.addAll(map.keySet());
        while(k>0){
            result.add(pq.poll());
            k--;
        }

        return result;
    }
}
