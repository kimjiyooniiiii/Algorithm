class Solution {
    public int solution(int n) {
        int number = 1;
        
        while(factorial(number) <= n){
            number++;
        }
        return number - 1;
    }
    
    public int factorial(int number) {
        int result = 1;
        
        while(number >= 1) {
            result *= number;
            number--;
        }
        
        return result;
    }
}