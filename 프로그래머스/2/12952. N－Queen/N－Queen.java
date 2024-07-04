class Solution {
    private int answer = 0;
    private int[] column;
    
    public int solution(int n) {
        column = new int[n];
        dfs(0, n);
        return answer;
    }
    
    public void dfs(int row, int n){
        if(row == n){
            answer++;
            // for(int i : column){
            //     System.out.print(i + " ");
            // }
            // System.out.println();
            return;
        }
        
        for(int i=0; i<n; i++){     // 0열부터 n-1열까지 넣어보기
            column[row] = i;
            if(check(row)){
                dfs(row+1, n);
            }
        }
    }
    public boolean check(int curRow){
        for(int i=0; i<curRow; i++){    // 0행부터 현재 행 이전까지 겹치지 않는 곳이 있는지
            if(column[i] == column[curRow] 
               || Math.abs(i-curRow) == Math.abs(column[i] - column[curRow])){
                return false;
            }
        }
        return true;
    }
}