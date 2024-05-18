class Solution {
    
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int height = arr1.length, width = arr2[0].length;
        
        int[][] answer = new int[height][width]; // 공간복잡도 10000 O(n^2)
        
        for(int i=0; i<height; i++){    // 시간복잡도 10000 * 100    O(n^2)
            for(int j=0; j<width; j++){
                answer[i][j] = multiple(arr1[i].length,i,j,arr1,arr2);
            }
        }
        
        return answer;
    }
    
    public int multiple(int cycle, int row, int column, int[][] arr1, int[][] arr2){
        int sum = 0;

        for(int i=0; i<cycle; i++){
            //System.out.println(arr1[row][i]);
            sum += (arr1[row][i] * arr2[i][column]);
        }
        return sum;
    }
    
}
