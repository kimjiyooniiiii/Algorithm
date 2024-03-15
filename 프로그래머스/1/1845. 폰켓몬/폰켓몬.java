import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int key = nums[i];
            if(map.containsKey(key)){
                int v = map.get(key);
                map.put(key,v+1);
            }else{
                map.put(key,1);
            }
        }

        int type = map.size();
        int pick = nums.length / 2;
        
        if(type > pick){
            answer = pick;
        }else{
            answer = type;
        }
        
        return answer;
    }
}