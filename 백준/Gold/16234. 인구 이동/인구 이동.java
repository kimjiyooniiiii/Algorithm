import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int n,low,high, time=0;
    public static int[][] town;
    public static City[][] cityArray;
    public static boolean[][] visit;
    public static int[] dy = {-1,1,0,0};    // 북남동서 순으로
    public static int[] dx = {0,0,1,-1};    // 북남동서 순으로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input(br);

        while(true){
            int count = barrier();
            if(count == (4*n*n - 4*n)){       // 열려 있는 국경이 없으면
                break;
            }
            average();  // 인구 이동

            for(int i=0; i<n; i++){     // 국경 처음으로 리셋
                for(int j=0; j<n; j++){
                    cityArray[i][j].resetBarrier();
                }
            }
            time++;
            //System.out.println("현재 시간 " + time);
        }
        System.out.println(time);

    }

    public static void average(){
        visit = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j]){
                    List<City> list = new ArrayList<>();    // 평균 계산 후, 업데이트 시킬 나라들
                    int[] result = bfs(i,j,list);
                    int average = result[0] / result[1];

                    if(list.size() != 1){
                        //System.out.println("합산 " + result[0] + " 개수 " + result[1]);
                        for(int z=0; z<list.size(); z++){       // 나라의 인구 수를 업데이트
                            town[list.get(z).y][list.get(z).x] = average;
                        }
//                        System.out.println("-----업데이트 이후------");
//                        for(int d=0; d<n; d++){
//                            for(int w=0; w<n; w++){
//                                System.out.print(town[d][w] + " ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println("--------------------");
                    }
                }
            }
        }
    }

    public static int[] bfs(int startY, int startX, List<City> list){
        int sum = town[startY][startX];
        int count = 1;

        Queue<City> q = new LinkedList<>();
        q.add(cityArray[startY][startX]);
        visit[startY][startX] = true;
        list.add(cityArray[startY][startX]);
        //System.out.print("방문 순서 " + startY + " " + startX);

        while(!q.isEmpty()){
            City poll = q.poll();
            for(int z=0; z<4; z++){
                int nextY = poll.y + dy[z];
                int nextX = poll.x + dx[z];

                if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < n && !visit[nextY][nextX]){
                    if((z==0 && !poll.up) || (z==1 && !poll.down)
                            || (z==2 && !poll.right) || (z==3 && !poll.left)){   // 가고자하는 방향이 열려있으면
                        q.add(cityArray[nextY][nextX]);
                        visit[nextY][nextX] = true;
                        sum += town[nextY][nextX];
                        count++;
                        list.add(cityArray[nextY][nextX]);
                        //System.out.print(", " + nextY + " " + nextX + " ");
                    }
                }
            }
        }
        //System.out.println();
        return new int[]{sum,count};
    }

    public static int barrier(){   // 이웃과의 차이를 계산에 벽을 세우기
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int z=0; z<4; z++){
                    int sideY = i + dy[z];
                    int sideX = j + dx[z];

                    if(sideY >= 0 && sideY < n && sideX >= 0 && sideX < n){
                        int diff = Math.abs(town[i][j] - town[sideY][sideX]);   // 이웃과 인구 수 차이 계산
                        if(diff < low || diff > high){
                            City c = cityArray[i][j];
                            count++;
                            switch(z){  // 북남동서의 벽 유무 업데이트
                                case 0:
                                    c.setBarrier("up", true);
                                    break;
                                case 1:
                                    c.setBarrier("down", true);
                                    break;
                                case 2:
                                    c.setBarrier("right", true);
                                    break;
                                case 3:
                                    c.setBarrier("left", true);
                                    break;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static class City{
        private int y,x;
        private boolean up,down,right,left; // 북남동서의 벽 유무

        public City(int y, int x, boolean up, boolean down, boolean right, boolean left){
            this.y = y;     this.x = x;
            this.up = up;   this.down = down;   this.right = right;     this.left = left;
        }
        public void setBarrier(String direction, boolean isBarrier){
            if(direction.equals("up")){
                this.up = isBarrier;
            }else if(direction.equals("down")){
                this.down = isBarrier;
            }else if(direction.equals("right")){
                this.right = isBarrier;
            }else if(direction.equals("left")){
                this.left = isBarrier;
            }

        }
        public void resetBarrier(){
            this.up = false;   this.down = false;   this.right = false;     this.left = false;
        }

    }

    public static void input(BufferedReader br) throws IOException {
        String[] condition = br.readLine().split(" ");
        n = Integer.parseInt(condition[0]);
        low = Integer.parseInt(condition[1]);
        high = Integer.parseInt(condition[2]);

        cityArray = new City[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cityArray[i][j] = new City(i,j,false, false, false, false);
            }
        }

        town = new int[n][n];

        for(int i=0; i<n; i++){
            String[] row = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                town[i][j] = Integer.parseInt(row[j]);
            }
        }
    }
}
