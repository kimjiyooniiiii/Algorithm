import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int r,c,t;
    public static Section[][] room;
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};
    public static int airTop, airBottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input(br);

        for(int i=0; i<t; i++){     // t초 동안 실행
            // 미세먼지 확산
            spread();
            regroup();

            recycleTop();
            recycleBottom();
        }

        System.out.println(sumTrash());
    }
    public static int sumTrash(){
        int sum = 0;
        for(int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                int trash = room[i][j].trash;
                if(trash != -1){
                    sum += trash;
                }
            }
        }
        return sum;
    }
    public static void recycleBottom(){
        int firstY = airBottom;  // 공기청정기 아랫부분의 행
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        for(int i=1; i<c-1; i++) {    q.add(room[firstY][i].trash);    }
        for(int i=firstY; i<r-1; i++) {   q.add(room[i][c-1].trash);  }
        for(int i=c-1; i>0; i--) {  q.add(room[r-1][i].trash);  }
        for(int i=r-1; i>firstY+1; i--) {   q.add(room[i][0].trash);    }

        //System.out.println(q);

        for(int i=1; i<c-1; i++) {    room[firstY][i].trash = q.poll();    }
        for(int i=firstY; i<r-1; i++) {   room[i][c-1].trash = q.poll();  }
        for(int i=c-1; i>0; i--) {  room[r-1][i].trash = q.poll();  }
        for(int i=r-1; i>firstY; i--) {   room[i][0].trash = q.poll();    }

//        for(int i=0; i<r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(room[i][j].trash +  " ");
//            }
//            System.out.println();
//        }
    }
    public static void recycleTop(){
        int firstY = airTop;  // 공기청정기 윗부분의 행
        Queue<Integer> q = new LinkedList<>();

        // 옮길 미세먼지 q에 넣기
        for(int i=firstY-2; i>0; i--){  q.add(room[i][0].trash);    }
        for(int i=0; i<c-1; i++){   q.add(room[0][i].trash);    }
        for(int i=0; i<firstY; i++){  q.add(room[i][c-1].trash);  }
        for(int i=c-1; i>=1; i--){  q.add(room[firstY][i].trash);   }
        q.add(0);   // 마지막으로 정화된 공기

        // 미세먼지 옮기기
        for(int i=firstY-1; i>0; i--){  room[i][0].trash = q.poll();    }
        for(int i=0; i<c-1; i++){   room[0][i].trash = q.poll();    }
        for(int i=0; i<firstY; i++){  room[i][c-1].trash = q.poll();  }
        for(int i=c-1; i>=1; i--){  room[firstY][i].trash = q.poll();   }

    }
    public static void regroup(){       // 미세먼지 재정비
        for(int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                 room[i][j].trash += room[i][j].addition;
                room[i][j].addition = 0;
            }
        }
    }

    public static void spread(){    // 나눠줄 미세먼지 양 계산
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(room[i][j].trash > 0){
                    int divide = room[i][j].trash/5;
                    int count = 0;
                    for(int z=0; z<4; z++){
                        int sideY = i + dy[z];
                        int sideX = j + dx[z];

                        if(sideY >= 0 && sideY < r && sideX >= 0 && sideX < c){
                            if(room[sideY][sideX].trash != -1) {    // 주변이 공기청정기가 아니면
                                room[sideY][sideX].addition += divide;
                                count++;
                            }
                        }
                    }
                    room[i][j].addition -= (count * divide);    // 확산되고 없어질 먼지
                }
            }
        }
    }

    public static class Section {
        private int y,x;
        private int trash, addition;    // 미세먼지 양과 추가될 양

        public Section(int y, int x, int trash, int addition){
            this.y = y;     this.x = x;
            this.trash = trash;     this.addition = addition;
        }
    }


    public static void input(BufferedReader br) throws IOException {
        String[] condition = br.readLine().split(" ");
        r = Integer.parseInt(condition[0]);
        c = Integer.parseInt(condition[1]);
        t = Integer.parseInt(condition[2]);

        room = new Section[r][c];
        for(int i=0; i<r; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<c; j++){
                int trash = Integer.parseInt(line[j]);
                room[i][j] = new Section(i,j,trash,0);

                if(trash == -1){
                    if(airTop == 0){
                        airTop = i;
                    }else{
                        airBottom = i;
                    }
                }
            }
        }
    }
}
