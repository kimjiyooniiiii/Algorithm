class Solution {
    public int max = 0;
    public int solution(int[][] land) {
        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                int cur = land[i][j];
                for(int z=0; z<4; z++){
                    if(j != z){
                        land[i][j] = Math.max(land[i][j], cur+land[i-1][z]);
                    }
                }
                //System.out.print(land[i][j] +" ");
            }
            //System.out.println();
        }

        for(int j=0; j<4; j++){
            max = Math.max(max,land[land.length-1][j]);
        }
        return max;
    }
    
}