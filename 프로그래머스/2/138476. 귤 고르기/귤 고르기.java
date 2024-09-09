// 2:40
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> pair = new HashMap<>();
        for(int t : tangerine){
            pair.put(t, pair.getOrDefault(t,0) + 1);
        }
        
        Collection<Integer> values = pair.values();
        List<Integer> sortedValues = values
            .stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());

        for(int v : sortedValues){
            if(k <= 0){
                break;
            }
               k -= v;
               answer++;
        }
        
        return answer;
    }
    
}
// k개에서 v개씩 뺌. 