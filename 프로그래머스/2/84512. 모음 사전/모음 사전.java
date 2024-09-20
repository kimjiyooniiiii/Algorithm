// 12 : 22 -> 38 -> 51   30분
class Solution {
    private String[] alpha = {"A","E","I","O","U"};
    private String[] visit = new String[6];
    private int result = -1;
    private int count = 0;
    
    public int solution(String word) {
        dfs(0, word);
        
        return result;
    }
    
    public void dfs(int len, String word){
        if(len > 5) return;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<len; i++){
            sb.append(visit[i]);
        }

        if(sb.toString().equals(word)){
            result = count;
        }
        count++;
        
        for(int i=0; i<5; i++){
            visit[len] = alpha[i];
            dfs(len + 1, word);
        }
    }

}
