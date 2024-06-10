import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Integer[] num = new Integer[numbers.length];
        for(int i=0; i<numbers.length; i++){
            num[i] = numbers[i];
        }
        
        Arrays.sort(num, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                String aS = a.toString();
                String bS = b.toString();
                
                return Integer.parseInt(bS + aS) - Integer.parseInt(aS + bS);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num.length; i++){
            if(i==0 && num[i] == 0){
                sb.append("0");
                break;
            }
            sb.append(num[i].toString());
        }
        answer = sb.toString();
        return answer;
    }

}