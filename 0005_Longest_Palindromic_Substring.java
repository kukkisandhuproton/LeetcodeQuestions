class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        String result="";
        for(int i =0;i<s.length();i++){
            String str1 = palindrome(s,i,i);
            String str2 = palindrome(s,i,i+1);
            if(result.length()<str1.length()){
                result = str1;
            }
            if(result.length()<str2.length()){
                result = str2;
            }
        }
        return result;
    }
    public String palindrome(String str,int start, int end){
        while(start>=0&&end<str.length()&&str.charAt(start)==str.charAt(end)){
            start--;
            end++;
        }
        return str.substring(start+1,end);
    }
}
