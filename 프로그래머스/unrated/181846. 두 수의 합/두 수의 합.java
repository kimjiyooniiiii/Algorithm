import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        String answer = "";
        
        BigInteger ai = new BigInteger(a);
        BigInteger bi = new BigInteger(b);
        
        answer = String.valueOf(ai.add(bi));
        
        return answer;
    }
}