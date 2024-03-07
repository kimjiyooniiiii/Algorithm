class Solution {
    public static int zero = 0;
    int change = 0;
    
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")) {
            change++;
            s = removeZero(s);
            s = toBinary(s);

        }
        
        answer[0] = change;
        answer[1] = zero;

        return answer;
    }
    
    public String removeZero(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0'){
                zero++;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
    public String toBinary(String s) {
        StringBuilder sb = new StringBuilder();
        
        int len = s.length();
        int count = len;
        
        while(len > 1) {
            count = len/2;
            int spare = len%2;
            sb.append(String.valueOf(spare));
            len = len/2;
        }
        sb.append(1);
        return sb.reverse().toString();
    }
}