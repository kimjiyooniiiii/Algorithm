import java.util.*;
class Solution {
    private int[] by = {-1,0,1,0}, bx = {0,1,0,-1};  // 0북 1동 2남 3서
    private char[][] game;
    private int[][] distance;
    private boolean[][] isVisit;

    public int solution(String[] board) {
        int answer = -1;
        int height = board.length, width = board[0].length();
        game = new char[height][width];
        distance = new int[height][width];
        isVisit = new boolean[height][width];
        int[] startYX = fillIn(board);
        
        Queue<int[]> piece = new LinkedList<>();
        piece.add(startYX);

        while(!piece.isEmpty()){
            int[] cur = piece.poll();
            int curY = cur[0], curX = cur[1];
            
            for(int i=0; i<4; i++){
                int dirY = curY + by[i];
                int dirX = curX + bx[i];
                boolean isMoving = false;
            
                while(dirY >= 0 && dirY < height && dirX >= 0 && dirX < width
                      && game[dirY][dirX] != 'D')
                {   
                    isMoving = true;
                    dirY += by[i];    dirX += bx[i];
                }
                if(isMoving){
                    dirY -= by[i];  dirX -= bx[i];
                    
                    if(game[dirY][dirX] == 'G'){
                        answer = distance[curY][curX] + 1;
                        piece.clear();
                        break;
                    }

                    if(!isVisit[dirY][dirX]){
                        distance[dirY][dirX] 
                            = distance[curY][curX] + 1; // 이전 위치에서 +1
                    
                        piece.add(new int[]{dirY, dirX});
                        isVisit[dirY][dirX] = true;
                    }
                }
            }
        }
        
        return answer;
    }
    
    public int[] fillIn(String[] board){
        int[] startYX = new int[2];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length(); j++){
                char letter = board[i].charAt(j);
                game[i][j] = letter;
                if(letter == 'R'){      // 시작 좌표
                    startYX[0] = i;     startYX[1] = j;
                }
            }
        }
        return startYX;
    }
}