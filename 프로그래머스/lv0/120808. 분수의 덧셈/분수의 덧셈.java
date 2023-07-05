class Solution {
    public int[] solution(int number1, int denom1, int number2, int denom2) {
        
        int number3 = (number1 * denom2) + (number2 * denom1);   //분자
        System.out.println(number3);
        int denom3 = (denom1 * denom2);  //분모
                System.out.println(denom3);
        int gcd = getGCD(number3, denom3);  //최대 공약수
                System.out.println(gcd);
        int[] answer = new int[2] ;
        
        answer[0] = number3 / gcd;
        answer[1] = denom3 / gcd;
        
        return answer;
    }
    
    public int getGCD(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        else {
            return getGCD(b, a % b);
        }
    }
}