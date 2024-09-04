// 1 : 57
class Solution {
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(s.length() > 1){
            answer[0]++;
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    answer[1]++;
                }else{
                    sb.append('1');
                }
            }
            s = Integer.toBinaryString(sb.toString().length());
        }

        return answer;
    }

}

// 111111 