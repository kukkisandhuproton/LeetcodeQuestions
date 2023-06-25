class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0){
            return "";
        }

        PriorityQueue<String> pq = new PriorityQueue<>(nums.length,(String str1,String str2)->{
            String s1s2 = str1+str2;
            String s2s1 = str2+str1;
            return s2s1.compareTo(s1s2);
        });

        for(int num:nums){
            pq.add(String.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        while(sb.length()>=2 && sb.charAt(0)=='0' && sb.charAt(1)=='0'){
            sb.delete(0,1);
        }
        return sb.toString();
    }
}
