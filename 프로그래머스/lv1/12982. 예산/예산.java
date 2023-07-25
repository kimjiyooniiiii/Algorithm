import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum=0;
        Arrays.sort(d);
        
        for(int i=0; i<d.length; i++){
            sum += d[i];
            System.out.println(sum);
            
            if(sum > budget){
                break;
            }
            
            answer++;
            System.out.println(answer);
            
        }
        return answer;
    }
}

//예산이 작은 것부터 더해가기