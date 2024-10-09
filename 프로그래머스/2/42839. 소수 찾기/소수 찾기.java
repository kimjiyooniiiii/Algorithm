// 6:7 -> 24
import java.util.*;
class Solution {
    private int[] numArray;
    private boolean[] visit;
    private Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        numArray = new int[numbers.length()];
        visit = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            int num = numbers.charAt(i) - '0';
            visit[i] = true;
            numArray[0] = num;
            dfs(numbers, 1);
            
            visit[i] = false;
        }
        
        // for(int s : set){
        //     System.out.print(s + " ");
        // }
        // System.out.println();

        return set.size();
    }
    
    public void dfs(String numbers, int depth){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<depth; i++){
            sb.append(String.valueOf(numArray[i]));
            //System.out.print(numArray[i]);
        }
        int result = Integer.parseInt(sb.toString());
        if(prime(result)) set.add(result);
        //System.out.println();
        
        for(int i=0; i<numbers.length(); i++){
            if(!visit[i]){
                int num = numbers.charAt(i) - '0';
                visit[i] = true;
                numArray[depth] = num;
                dfs(numbers, depth+1);
                visit[i] = false;
            }
        }
    }
    
    public boolean prime(int num){
        if(num == 1 || num == 0)    return false;
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) {
                //System.out.println(i);
                return false;
            }
        }
        return true;
    }
}
