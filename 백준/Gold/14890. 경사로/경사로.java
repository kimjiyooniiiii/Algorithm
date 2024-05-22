import java.io.*;

public class Main {
    private static int n,l;
    private static Road[][] horizonMap;
    private static Road[][] verticalMap;
    public static class Road{
        private int high;
        private boolean hill;

        public Road(int high, boolean hill){
            this.high = high;
            this.hill = hill;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input(br);

        int answer = 0;
        //System.out.println("horizonMap");
        for(int i=0; i<n; i++){
            if(checkRow(i, horizonMap)){
                answer++;
            }
        }
        //System.out.println("verticalMap");
        for(int i=0; i<n; i++){
            if(checkRow(i, verticalMap)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean checkRow(int row, Road map[][]){
        for(int i=1; i<n; i++){
            int prev = map[row][i-1].high;
            int current = map[row][i].high;

            if(current == prev){
                continue;
            }

            if(Math.abs(current-prev) > 1){     // 인접한 길의 높이 차이가 1보다 크면 실패
                //System.out.println("["+row+","+i+"]와 "+"["+row+","+(i-1)+"] 차이 1넘음");
                return false;
            }else{
                int startX = i;

                if(current > prev){ // 오른쪽에서 왼쪽으로 낮아지는 경우라면 경사로의 시작 수정
                    startX = i-l;
                }

                boolean successHill = makeHill(row, startX, map);   // 원하는 구간에 경사로 만들기
                if(!successHill){    // 경사로 만들기 실패
                    return false;
                }

                if(current < prev) {    // 경사가 만들어진 후 인덱스 위치 변경
                    i = (i+l-1);
                }
            }
        }
        //System.out.println(row + "행 성공");
        return true;
    }

    public static boolean makeHill(int row, int startX, Road[][] map){ // 경사로 시작 부분을 매개변수로 받음
        for(int i=0; i<l; i++){
            int nextX = startX + i;

            if(nextX < 0 || nextX >= n){  // 경사로가 경계밖으로 나간다면
                //System.out.println("["+row+","+nextX+"]가 경계를 넘음");
                return false;
            }else if(map[row][nextX].hill){   // 이미 경사로가 있다면
                //System.out.println("["+row+","+nextX+"]가 이미 경사로 존재");
                return false;
            }else if(map[row][nextX].high != map[row][startX].high){  // 경사로 놓을 곳의 높이가 다르다면
                //System.out.println("["+row+","+nextX+"]가 경사로 높이가 다름" + map[row][nextX].high + ", 이전 높이 " + map[row][startX].high);
                return false;
            }else{
                map[row][nextX].hill = true;  // 경사로 세우기
            }
        }
        return true;
    }

    public static void input(BufferedReader br) throws IOException {
        String[] condition = br.readLine().split(" ");
        n = Integer.parseInt(condition[0]);
        l = Integer.parseInt(condition[1]);
        horizonMap = new Road[n][n];
        verticalMap = new Road[n][n];

        for(int i=0; i<n; i++){
            String[] row = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                int num = Integer.parseInt(row[j]);
                horizonMap[i][j] = new Road(num, false);
                verticalMap[j][i] = new Road(num, false);
            }
        }
    }
}
