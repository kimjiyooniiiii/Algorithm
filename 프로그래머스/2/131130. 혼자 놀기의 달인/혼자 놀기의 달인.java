import java.util.*;
class Solution {
    public HashMap<Integer,Boolean> map = new HashMap<>();  // 해당 번호의 상자를 열었는지 정보 저장
    public int[] pick = new int[2];
    public int max = 0;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        for(int i=0; i<cards.length; i++){
            map.put(i+1,false);
        }
        back(-1,0,cards);
        answer = max;
        return answer;
    }
    
    public void back(int prev, int len, int[] cards){
        if(len == 2) {
            // 두 조합을 이용해 상자 열어보기
            int result = combi(pick[0],pick[1],cards);
            if(result == 0){
      //          System.out.println("게임 실패");
            }
            if(result != -1 && result != 0){
     //           System.out.println("결과 : " + result);
                max = Math.max(max, result);
            }
            return;
        }
        for(int i=0; i<cards.length; i++){
            if(i > prev){
                pick[len] = i+1;
                back(i, len+1, cards);
            }
        }
    }
    
    public int combi(int one, int two, int[] cards){
        int oneCount = 0, twoCount = 0;      
        
       // System.out.println("pick " + one + " " + two);
       // System.out.println("첫번째 상자열기");
        oneCount = openBox(one, cards); // 첫번째 선택한 숫자로 상자 연속 열기
        
        if(!map.containsValue(false)){  // 더 이상 열 수 있는 상자가 없다면
            return 0;
        }else if(map.get(two)){     // 두번째 선택한 숫자가 이미 열려있는 경우 -> 잘못된 조합의 경우
            return -1;
        }else{
        //    System.out.println("두번째 상자열기");
            twoCount = openBox(two, cards); // 두번째 선택한 숫자로 상자 연속 열기
            
       //     System.out.println("oneCount " + oneCount + " twoCount " + twoCount);
            return oneCount * twoCount;
        }
    }
    
    public int openBox(int next, int[] cards){
        int count = 0;
        
        for(int i=0; i<cards.length; i++){  // 다시 모든 상자 상태 돌리기
            map.replace(i+1,false);
        }
        
         while(true){
            if(map.get(next) == true){   // 이미 상자가 열려 있다면
                break;
            }
       //     System.out.println(next + " open");
            map.replace(next, true);    // 상자 열기
            next = cards[next-1];
            count++;
        }
        return count;   // 연속으로 연 갯수 반환
    }
}