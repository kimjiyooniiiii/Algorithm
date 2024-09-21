// 2:00 -> 12 -> 19
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> brother = new HashMap<>();
        for(int t : topping){
            brother.put(t, brother.getOrDefault(t, 0) + 1);
        }
        
        Set<Integer> chulsu = new HashSet<>();
        
        for(int i=0; i<topping.length; i++){
            int key = topping[i];
            chulsu.add(key);
            if(brother.containsKey(key)){
                int value = brother.get(key);
                if(value == 1) brother.remove(key);
                else brother.put(key, value - 1);
            }
            
            if(chulsu.size() == brother.size()) answer++;
        }
        
        return answer;
    }
}
