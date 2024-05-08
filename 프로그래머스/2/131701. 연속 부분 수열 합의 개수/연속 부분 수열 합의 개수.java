import java.util.*;

class Solution {
    public Set<Integer> sum = new HashSet<>();
    public int solution(int[] elements) {
        int answer = 0;
        
        for(int i=0; i<elements.length; i++){
            sum.add(elements[i]);
        }
        
        int start = 0, end = 2; // 10 12

        for(int size=2; size<elements.length; size++){
            for(int i=0; i<elements.length; i++){
                int add = 0;
                for(int j=0; j<size; j++){
                    int next = i+j;
                
                    if(next >= elements.length){
                        next -= elements.length;
                    }
                    add += elements[next];
                    //System.out.println(elements[next]);
                }
                sum.add(add);
            }
        }
        answer = (sum.size()) + 1;
        return answer;
    }
}