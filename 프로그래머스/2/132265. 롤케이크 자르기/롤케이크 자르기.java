import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> one = new HashMap<>();
        Map<Integer,Integer> two = new HashMap<>();
        
        for(int i=0; i<topping.length; i++){
            int type = topping[i];
            one.put(type, one.getOrDefault(type,0)+1);
        }
        
        for(int i=0; i<topping.length; i++){
            int type = topping[i];
            two.put(type, two.getOrDefault(type,0)+1);
            
            int value = one.get(type) - 1;
            if(value == 0){
                one.remove(type);
            }else{
                one.put(type, value);
            }
            
            if(one.size() == two.size()){
                answer++;
            }
        }
        return answer;
    }
}

// 한 개가 남았을 때 