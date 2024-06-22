import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;   
        sortData(data, col);
        int[] remain = new int[row_end - row_begin + 1];
        for(int i=row_begin; i<=row_end; i++){
            remain[i-row_begin] = rowDivide(data, i);
        }
        
        answer = remain[0];
        for(int i=1; i<remain.length; i++){
            answer ^= remain[i];
        }
        
        return answer;
    }
    
    public int rowDivide(int[][] data, int row){
        int sum = 0;
        
        for(int i=0; i<data[row-1].length; i++){
            sum += (data[row-1][i] % row);
        }
        return sum;
    }
    
    public void sortData(int[][] data, int col){
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[col-1] == (b[col-1])){
                    return b[0] - a[0];
                }
                return a[col-1] - b[col-1];
            }
        });
    }
}

// 모두 정수 타입 컬럼
// 첫 컬럼은 기본키 
// 가로 500, 세로 2500