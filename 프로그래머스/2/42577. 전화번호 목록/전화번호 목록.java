// 9:45 -> 59
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i].length() > phone_book[i+1].length()){
                continue;
            }
            int size = phone_book[i].length();
            String front = phone_book[i+1].substring(0,size);
           // System.out.println(phone_book[i] + " " + front);
            if(front.equals(phone_book[i])){
                answer = false;
            }
        }
        return answer;
    }
}
// 완전 치명적인 실수 했네.. 그냥 포함이 아니고 앞에 포함.. 하..
// 이걸 왜 놓쳤을까. 빨리 풀고 싶어서. 