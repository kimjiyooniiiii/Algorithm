import java.util.*;
class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long allCount = factorial(n);   // 전체 경우의 수
        List<Integer> erase = new ArrayList<>();
        for(int i=1; i<=n; i++){
            erase.add(i);
        }
        
        int insert = 0;
        while(k > 1)
        {
            allCount /= n--;
           
            int index = 1;
            while(allCount * index < k){
                index++;
            }
            answer[insert++] = erase.get(index-1);
            erase.remove(index-1);
            k -= (index-1) * allCount;
        }
        
        for(int i=0; i<answer.length; i++){
            if(answer[i] == 0){
                answer[i] = erase.get(0);
                erase.remove(0);
            }
        }
        
        return answer;
    }
    
    public long factorial(int n){
        long result = 1;
        for(int i=2; i<=n; i++){
            result *= i;
        }
        return result;
    }

}