import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        int start = 2;
        
        while(start <= n && n != 1){
            if(n % start == 0){
                if(!list.contains(start)){
                    list.add(start);
                }
                n /= start;
            }else{
                start++;
            }
        }
        List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
        int[] array = newList.stream().mapToInt(Integer::intValue).toArray();
        
        System.out.println(list);

        return array;
    }
}