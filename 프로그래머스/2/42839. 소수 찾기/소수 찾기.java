import java.util.*;
class Solution {
    char[] result;
    boolean[] visit;
    Set<Integer> numSet = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        result = new char[numbers.length()];
        visit = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            visit[i] = true;
            result[0] = numbers.charAt(i);
            dfs(1, numbers);
            visit[i] = false;
        }
        Iterator it = numSet.iterator();
        while(it.hasNext()){
            int next = (int)it.next();
            if(next != 0 && next != 1 && isPrime(next)){
                System.out.println(next);
                answer++;
            }
        }

        return answer;
    }
    
    public boolean isPrime(int num){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=2; i<=Math.sqrt(num); i++){
            while(num % i == 0){
                num /= i;
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        if(num > 1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int result = 1;
        for(int i : map.keySet()){
            result *= (map.get(i)+1);
        }
        if(result > 2){
            return false;
        }
        return true;
    }
    
    public void dfs(int count, String numbers){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++){
            sb.append(result[i]);
        }
        numSet.add(Integer.parseInt(sb.toString()));
        
        for(int i=0; i<numbers.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                result[count] = numbers.charAt(i);
                dfs(count + 1, numbers);
                visit[i] = false;
            }
        }
    }
   
}