class Solution {
    public double myPow(double x, int n) {
        double answer = 1.0;
        long number = n;
        if(number<0){
            number = -1*number;
        }
        while(number>0){
            if(number%2==1){
                answer = answer*x;
                number--;
            }
            else{
                x=x*x;
                number=number/2;
            }
        }
        if(n<0){
            answer=1/answer;
        }
        return answer;
    }
}
