import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        Arrays.sort(sides);
        int a = sides[0];
        int b = sides[1];
        int sum = a+b;
        
        for(int i = b+1; i<sum; i++){
            answer++;
        }
        System.out.println(answer);
        
        for(int i=1; i<=b; i++){
            if((i+a) > b){
                answer++;       
            }
        }
        System.out.println(answer);
        
        return answer;
    }
}