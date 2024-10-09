// 8:10
import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int start=0, end=0, sum = sequence[0];
        List<int[]> list = new ArrayList<>();
        
        while(true){
            if(start >= sequence.length || end >= sequence.length)  break;

            if(sum < k){ 
                if(++end >= sequence.length)  break;
                sum += sequence[end];
            }else if(sum > k){
                sum -= sequence[start++];
            }else{
                list.add(new int[]{start, end, end-start+1});
                sum -= sequence[start++];
            }
        }
        
        Collections.sort(list, (a, b) -> {
            if(a[2] == b[2])    return a[0] - b[0];
            return a[2] - b[2];
        });

        return new int[]{list.get(0)[0], list.get(0)[1]};
    }

}

