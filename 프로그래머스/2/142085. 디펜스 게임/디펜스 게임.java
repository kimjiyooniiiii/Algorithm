import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> useK = new PriorityQueue<>();
        
        for(int i=0; i<enemy.length; i++){
            if(k > 0){
                k--;    answer++;
                useK.add(enemy[i]);
            }else{
                if(!useK.isEmpty() && useK.peek() < enemy[i]){
                    int minNum = useK.poll();
                    if(n < minNum){
                        break;
                    }
                    n -= minNum;
                    useK.add(enemy[i]);
                    answer++;
                }else if(n >= enemy[i]){
                    n -= enemy[i];
                    answer++;
                }else{
                    break;
                }
            }
        }
        
        return answer;
    }
}

// 그리디...