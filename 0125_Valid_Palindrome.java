class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        int start = 0;
        int end = s.length()-1;
        s = s.toLowerCase();
        while(start<end){
            while(start<end && !((s.charAt(start)>='a' && s.charAt(start)<='z')
            ||(s.charAt(start)>='0' && s.charAt(start)<='9'))){
                start++;
            }
            while(start<end && !((s.charAt(end)>='a' && s.charAt(end)<='z') 
                    || (s.charAt(end)>='0'&&s.charAt(end)<='9'))){
                end--;
            }
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
