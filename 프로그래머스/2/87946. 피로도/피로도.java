
class Solution {
    private boolean[] visit;
    private int max = 0;

    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        
        for(int i=0; i<dungeons.length; i++){
            if(dungeons[i][0] <= k){
                visit = new boolean[dungeons.length];
                visit[i] = true;

                backTracking(dungeons, k - dungeons[i][1], 1);
            }
        }
        
        return max;
    }

    public void backTracking(int[][] dungeons, int energy, int count){
        max = Math.max(max, count);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visit[i] && dungeons[i][0] <= energy){
                visit[i] = true;
                backTracking(dungeons, energy - dungeons[i][1], count+1);
                visit[i] = false;
            }
        }
    }
}
