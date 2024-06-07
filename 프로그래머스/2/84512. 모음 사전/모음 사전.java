class Solution {
    public String[] array = new String[5];
    public int count = 0;
    public int result = 0;
    public StringBuilder sb = new StringBuilder(5);
    
    public int solution(String word) {
        String[] s = {"A","E","I","O","U"};
        dfs(s, word, 0);
        return result;
    }
    
    public void dfs(String[] s, String word, int order){
        for(int i=0; i<order; i++){
            sb.append(array[i]);
        }
        if(sb.toString().equals(word)){
            result = count;
        }
        count++;
        sb.setLength(0);

        if(order == 5){
            return;
        }

        for(int i=0; i<s.length; i++){
            array[order] = s[i];
            dfs(s, word, order+1);
        }
    }
}