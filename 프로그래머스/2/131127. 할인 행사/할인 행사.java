// 시간복잡도 : O(n), 공간복잡도 : O(n)

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // hashMap은 Map 인터페이스의 구현체로, 값을 저장할 때, 해시함수로 나온 해시값을 사용해 저장됩니다. 그렇기 때문에 입력, 삭제 모두 O(1) 시간이 듭니다.
        // hashMap은 크기를 넘은 값이 들어오면 저장공간을 2배로 늘리기 때문에 미리 공간크기를 지정해주겠습니다.
        Map<String, Integer> jungHyun = new HashMap<>(10);
        
        for(int i=0; i<want.length; i++){
            jungHyun.put(want[i],number[i]);
        }
        
        for(int i=0; i<=discount.length-10; i++){
            // 새로운 map을 생성하고 정현의 map과 일치하는지 비교한다.
            if(jungHyun.equals(makeMap(i,i+10,discount))){
                answer++;
            }
        }
        
        return answer;
    }
    
    public Map<String, Integer> makeMap(int start, int end, String[] discount){
        Map<String, Integer> sales = new HashMap<>(10);
        for(int i=start; i<end; i++){
            sales.put(discount[i], sales.getOrDefault(discount[i],0)+1);
        }
        return sales;
    }
}
