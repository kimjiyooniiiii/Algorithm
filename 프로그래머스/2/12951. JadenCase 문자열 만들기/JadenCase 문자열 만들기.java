import java.util.stream.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
       
        String[] splitS = s.split(" ", -1);     // 공백을 살려서 자르기
        
        for(int i=0; i<splitS.length; i++){
            String smallS = splitS[i];
            if(smallS.length() != 0){
                char firstChar = smallS.charAt(0);
                firstChar = Character.isDigit(firstChar) 
                    ? firstChar : Character.toUpperCase(firstChar);

                sb.append(firstChar);
                sb.append(smallS.substring(1).toLowerCase());
            }
            
            if(i != splitS.length -1){
                sb.append(" ");
            }
            
        }
        
        return sb.toString();
    }
}

// 꼭 안자르고 하고 싶은데. 