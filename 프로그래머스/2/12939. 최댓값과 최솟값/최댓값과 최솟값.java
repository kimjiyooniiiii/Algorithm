import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] splitS = s.split(" ");
        Integer[] sToInteger = Arrays.stream(splitS)
            .map(Integer::parseInt)
            .sorted()
            .toArray(Integer[]::new);
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(sToInteger[0]));
        sb.append(" ");
        sb.append(String.valueOf(sToInteger[sToInteger.length-1]));
        return sb.toString();
    }
}