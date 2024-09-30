// 11:04  -> 11:37
import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        
        List<String[]> list = new ArrayList<>();
        for(int i=0; i<files.length; i++){
            String file = files[i];
            int endOfHead = 0;
            while(!isNum(file.charAt(endOfHead))) endOfHead++;

            int endOfNum = endOfHead;
            while(endOfNum < file.length() && isNum(file.charAt(endOfNum))) endOfNum++;
            
            String head = file.substring(0,endOfHead);
            String number = file.substring(endOfHead,endOfNum);
            
            String[] parse = {head, number, file.substring(endOfNum, file.length())};
            list.add(parse);
        }
        
        Collections.sort(list, new Comparator<String[]>(){
            public int compare(String[] a, String[] b){
                String aHead = a[0].toUpperCase();
                String bHead = b[0].toUpperCase();
                
                if(aHead.equals(bHead)) {
                    return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
                }else{
                    return aHead.compareTo(bHead);
                }
            }
        });
        
        String[] answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++){
            StringBuilder sb = new StringBuilder();
            String[] s = list.get(i);
            
            sb.append(s[0]);
            sb.append(s[1]);
            sb.append(s[2]);
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    public boolean isNum(char c){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        for(int a : array){
            if(c-'0' == a)  return true;
        }
        return false;
    }
}

// 대소문자 구분 X
// tail의 정렬은 입력 순서대로

// 파싱 for문으로 숫자가 나오기 전까지 찾기. 다시 for문을 문자가 나오기 전까지 찾기
// 그걸 기준으로 정렬해야 하니까. 배열에 넣어야 한다.