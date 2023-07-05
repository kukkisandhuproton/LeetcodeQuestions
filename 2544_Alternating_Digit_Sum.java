class Solution {
    public int alternateDigitSum(int n) {
        boolean flag = true;
        int result = 0;
        int count = 0;
        int i = n;
        
        while(n>0){
            System.out.println(n%10);
            n=n/10;
            count++;
        }
        // if count is even
        if(count%2==0){
            flag = false;
        }
        while(i>0){
            if(flag){
                result = result+i%10;
                i=i/10;
                flag=!flag;
            }
            else{
                result = result-i%10;
                i=i/10;
                flag = !flag;
            }

        }

        // System.out.println(count);
        return result;
    }
}
