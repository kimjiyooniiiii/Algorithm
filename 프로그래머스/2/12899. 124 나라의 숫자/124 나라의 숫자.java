import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        List<String> change = new ArrayList<>();
        StringBuilder answerBuilder = new StringBuilder();
        
        int divide = n;
        int spare;
        while(divide >= 3){
            spare = divide % 3;
            divide = divide / 3;
            //System.out.println(divide + " " + spare);
            if(spare == 0){
                answerBuilder.insert(0,"4");
                //change.add("4");
                divide -= 1;
            }else if(spare == 2){
                answerBuilder.insert(0,"2");
                //change.add("2");
            }else if(spare == 1){
                answerBuilder.insert(0,"1");
                //change.add("1");
            }
        }
        
        if(divide != 0){
             answerBuilder.insert(0,String.valueOf(divide));
        }
        //change.add(String.valueOf(divide));
        
        
        // for(int i=change.size()-1; i>=0; i--){
        //     if(!change.get(i).equals("0")){
        //         //answerBuilder.append(change.get(i););
        //         answer += change.get(i);
        //     }
        // }
        answer = answerBuilder.toString();
        return answer;
    }
}