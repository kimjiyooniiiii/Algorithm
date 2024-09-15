
class Solution {
    
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int width = arr2[0].length, height = arr1.length;
        int[][] answer = new int[height][width];
        
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                answer[i][j] = multiply(i,j,arr2.length, arr1, arr2);
            }
        }
        
        
        return answer;
    }

    public int multiply(int arr1Row, int arr2Column, int height, int[][] arr1, int[][] arr2){
        int sum = 0;
        
        for(int i=0; i<height; i++){
            sum += arr1[arr1Row][i] * arr2[i][arr2Column];
        }
        return sum;
    }
    
}
