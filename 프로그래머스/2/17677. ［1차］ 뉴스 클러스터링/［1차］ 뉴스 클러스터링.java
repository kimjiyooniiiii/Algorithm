// 40분
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        String[] array = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O",
                          "P","Q","R","S","T","U","V","W","X","Y","Z"};
        Set<String> alpha = new HashSet<String>(Arrays.asList(array));
        
        str1 = str1.toUpperCase(); str2 = str2.toUpperCase();
        
        int str1Count = 0, str2Count = 0, sameCount = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<str1.length()-1; i++){
            String prev = String.valueOf(str1.charAt(i));
            String next = String.valueOf(str1.charAt(i+1));
            if(alpha.contains(prev) && alpha.contains(next)){
                str1Count++;
                map.put(prev+next, map.getOrDefault(prev+next, 0) + 1);
                //System.out.println(prev+next + " " + map.get(prev+next));
            }
        }
        
        for(int i=0; i<str2.length()-1; i++){
            String prev = String.valueOf(str2.charAt(i));
            String next = String.valueOf(str2.charAt(i+1));
            if(alpha.contains(prev) && alpha.contains(next)){
                str2Count++;
                if(map.containsKey(prev+next)){
                    sameCount++;
                    map.put(prev+next, map.get(prev+next) - 1);
                    if(map.get(prev+next) == 0) map.remove(prev+next);
                }
                //System.out.println(prev+next + " " + map.get(prev+next));
            }
        }
    
        int sumCount = str1Count + str2Count - sameCount;
        double divide = (double)sameCount / sumCount;
        //System.out.println(str1Count + " "  + sumCount);
        if(str1Count == 0 && str2Count == 0) divide = 1;
        
        return (int)(divide * 65536);
    }
}
