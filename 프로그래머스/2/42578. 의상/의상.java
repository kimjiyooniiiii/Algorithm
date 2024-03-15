import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(String[] c : clothes){
            if(map.containsKey(c[1])){
                List<String> value = map.get(c[1]);
                value.add(c[0]);
                map.replace(c[1],value);
            }else{
                List<String> value = new ArrayList<>();
                value.add(c[0]);
                map.put(c[1],value);
            }
        }
        // Iterator<Map.Entry<String, List<String>>> it = map.entrySet().iterator();
        // while(it.hasNext()){
        //     Map.Entry<String, List<String>> next = it.next();
        //     System.out.println(next.getKey() + " " + next.getValue());
        // }
        
        for(Map.Entry<String, List<String>> m : map.entrySet()){
            answer *= (m.getValue().size() + 1);
        }
        
        return answer-1;
    }
    
    public int factorial(int num, int result){
        if(num == 1){
            return result;
        }else{
            result *= num;
            return factorial(num-1, result);
        }
    }
    
    public int sameType(int num) {
        return num * (num-1) / 2;
    }
}