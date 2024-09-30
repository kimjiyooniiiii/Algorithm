// 10:16 -> 59
// 이런 문제가 복잡하긴한데 나는 이런거 좋아해. 체계적으로 다가가야 하는거

import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer,List<Integer>> map = new TreeMap<>();
        
        for(String r : records){
            String[] splitR = r.split(" ");
            int number = Integer.parseInt(splitR[1]);
            String[] splitT = splitR[0].split(":");
            int time = Integer.parseInt(splitT[0])*60 + Integer.parseInt(splitT[1]);
            
            if(!map.containsKey(number)){
                map.put(number, new ArrayList<>());
            }
            map.get(number).add(time);
        }
        
        int[] answer = new int[map.size()];
        int index = 0;
        for(int k : map.keySet()){
            List<Integer> timeList = map.get(k);
            if(timeList.size() % 2 == 1) timeList.add(1439);
            
            int sum = 0;
            int pay = 0;
            for(int i=0; i<timeList.size(); i+=2){
                sum += timeList.get(i+1) - timeList.get(i);
            }
            pay += fees[1];
            sum -= fees[0];
            
            if(sum > 0){
                int stand = fees[2];
                int bundle = sum / stand;
                if(sum % stand > 0) bundle++;
                pay += bundle * fees[3];
            }
            answer[index++] = pay;
        }
        
        
        return answer;
    }

}
// 순서대로 요금 계산