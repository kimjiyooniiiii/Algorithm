
import java.util.*;
class Solution {
    private int max = 0;

    public int solution(int[][] land) {
        
        Map[][] map = new Map[land.length][4];
        for(int i=0; i<land.length; i++){
            for(int j=0; j<4; j++) {
                map[i][j] = new Map(land[i][j], j);
            }
        }
        Arrays.sort(map[0], new Comparator<Map>(){
            @Override
                public int compare(Map a, Map b){
                    return a.num - b.num;
                }
            });  
        
        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++) {
                if(map[i][j].index == map[i-1][3].index){
                    map[i][j].num += map[i-1][2].num;
                }else{
                    map[i][j].num += map[i-1][3].num;
                }
            }
            Arrays.sort(map[i], new Comparator<Map>(){
            @Override
                public int compare(Map a, Map b){
                    return a.num - b.num;
                }
            });  
        }
        
        // for(int i=0; i<land.length; i++){
        //     for(int j=0; j<4; j++) {
        //         System.out.print(map[i][j].num + " " );
        //     }
        //     System.out.println();
        // }
        
        return map[land.length-1][3].num;
    }
    
    class Map {
        private int num;
        private int index;
        public Map(int num, int index){
            this.num = num; this.index = index;
        }
    }

}
