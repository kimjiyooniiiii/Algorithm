import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // h의 최대값은 citations의 길이
        int maxH = citations.length;
        
        Arrays.sort(citations);
        
        for(int h=0; h<=maxH; h++){
            int count = 0;
            for(int j=0; j<citations.length; j++){
               // System.out.println("h : " + h + " num : " + citations[j]);
                
                if(citations[j] >= h){
                    count++;
                 //       System.out.println("h : " + h + " count : " + count);
                }
            }
            if(count >= h && h >= (citations.length-count)){
                answer = Math.max(answer,h);
               // System.out.println("answer : " + answer);
            }else{
                break;
            }
        }
        
        return answer;
    }
}

// 과학자의 생산성과 영향력 
// 과학자의 논문 n개 중 h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용되었다면 h의 최댓값

// 논문 0 1 2 3 4번 각각 0 1 3 5 6번 인용됨 
// h가 1이면 h이상 인용된거 h편이상이고  O
// h가 2이면 -> h번 이상 인용된거 h편 이상  O
// h가 3이면 -> h번 이상 인용된거 h편 이상  O
// h가 4이면 -> h번 이상 인용된거 h편 이하  X

// 인용 횟수 1000번을 0회부터 1000회까지 실행해야하고, 그때마다 인용된 편수를 비교해야하니 1000번
// 시간복잡도 O(n^2)  공간복잡도 O(1)
