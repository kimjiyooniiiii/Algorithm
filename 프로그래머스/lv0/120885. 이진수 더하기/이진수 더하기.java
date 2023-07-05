import java.util.stream.Stream;
import java.util.*;

class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        List<Integer> result = new ArrayList<>();
        
        List<Integer> list1 = new ArrayList<>();
        for(int i=0; i<bin1.length(); i++) {
            list1.add(Character.getNumericValue(bin1.charAt(i)));
        }
        List<Integer> list2 = new ArrayList<>();
        for(int i=0; i<bin2.length(); i++) {
            list2.add(Character.getNumericValue(bin2.charAt(i)));
        }
        int bonus = 0;
        int diff = 0;
        
        if(list1.size() > list2.size()) {
            diff = list1.size()-list2.size();
            Collections.reverse(list2);
            for(int i=0; i<diff; i++){
                list2.add(0);
            }
            Collections.reverse(list1);
        }
        else if(list1.size() < list2.size()) {
            diff = list2.size()-list1.size();
            Collections.reverse(list1);
            for(int i=0; i<diff; i++){
                list1.add(0);
            }
            Collections.reverse(list2);
        }
        else{
            Collections.reverse(list1);
            Collections.reverse(list2);
        }

        
        for(int i=0; i<list1.size(); i++) {
            if(list1.get(i)+list2.get(i)+bonus == 2) {
                result.add(0);
                bonus = 1;
            }
            else if(list1.get(i)+list2.get(i)+bonus == 3){
                result.add(1);
                bonus = 1;
            }else{
                result.add(list1.get(i)+list2.get(i)+bonus);
                bonus = 0;
            }
        }
        if(bonus == 1){
            result.add(1);
        }
        Collections.reverse(result);
        
        for(Integer r : result){
            answer += String.valueOf(r);
        }
        
        return answer;
    }
}