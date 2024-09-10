import java.util.*;
// 42 
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> sumCollection = new HashSet<>();
        
        for(int i=0; i<elements.length; i++){
            sumCollection.add(elements[i]);
            int sum = elements[i];
             //System.out.print(sum + " ");       // 첫 노드
            for(int j=1; j<elements.length; j++){
                int neighbor = i+j;
                if(neighbor >= elements.length){
                    neighbor = (i+j) - elements.length;
                }
                sum += elements[neighbor];
                sumCollection.add(sum);
                //System.out.println(elements[neighbor] + " " + sum);
            }
           // System.out.println();
        }
//         for(int i : sumCollection){
//             System.out.print(i + " ");
//         }
        
        
        answer = sumCollection.size();
        
        return answer;
    }
}

// 원형 수열에서 수열로 만들 수 있는 것들을 합으로 표현하고 그것의 개수를 반환