import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int n,m,k;
    public static int[][] map;
    public static int result = 0;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmk = br.readLine().split(" ");
        n = Integer.parseInt(nmk[0]);
        m = Integer.parseInt(nmk[1]);
        k = Integer.parseInt(nmk[2]);
        map = new int[n][m];

//        for(int i=0; i<n; i++) {
//            String[] mapLine = br.readLine().split(" ");
//            for(int j=0; j<m; j++){
//                map[i][j] = Integer.parseInt(mapLine[j]);
//            }
//        }

        // 시간복잡도 : 100 X 64000000 = 64억........
        // 스티커를 입력받아 list에 저장
        for(int i=0; i<k; i++){
            String[] rc = br.readLine().split(" ");
            int r = Integer.parseInt(rc[0]);
            int c = Integer.parseInt(rc[1]);
            List<int[]> list = new ArrayList<>();

            // 시간복잡도 : 10 X 10
            for(int y=0; y<r; y++){
                String[] line = br.readLine().split(" ");
                for(int x=0; x<c; x++){
                    if(line[x].equals("1")){
                        list.add(new int[]{y,x});
                    }
                }
            }
            // 시간복잡도 : 160000 X 4 X 100 = 64000000
            if(!put(list)){
                for(int ro=0; ro<3 ; ro++){
                    // 이전의 높이를 이용해 다음의 y를 계산
                    if(ro%2 == 0){
                        rotation(list,r);
                    }else{
                        rotation(list,c);
                    }
                    if(put(list)){
                        break;
                    }
                }
            }

//            System.out.println("-------------------------------");
//            for(int a=0; a<n; a++) {
//                for(int b=0; b<m; b++){
//                    System.out.print(map[a][b] + " ");
//                }
//                System.out.println();
//            }
        }
        System.out.println(result);
    }

    public static void rotation(List<int[]> list, int width){
        for(int i=0; i<list.size(); i++){
            int prevY = list.get(i)[0];
            int prevX = list.get(i)[1];

            int changeY = prevX;
            int changeX = width-1-prevY;

            list.set(i,new int[]{changeY, changeX});
        }
    }

    public static boolean put(List<int[]> list){
        int count = 0;
        int[][] location = new int[list.size()][2];

        // 시간 복잡도 : 40 X 40 X 100 = 160000
       for(int i=0; i<n; i++){
           for(int j=0; j<m; j++){
               if(count == list.size()){
                   // 스티커를 붙이고 나간다. 붙인 자리를 알아야 한다.
                   for(int[] l : location){
                       map[l[0]][l[1]] = 1;
                   }
                   result += count;
                   return true;
               }
               count = 0;
               for(int s=0; s<list.size(); s++){
                   int y = list.get(s)[0] + i;
                   int x = list.get(s)[1] + j;

                   if(y >= n || x >= m || map[y][x] == 1){
                       //System.out.println("list y:" + list.get(s)[0] + " x:" + list.get(s)[1] + " to map y:" +y + " x:" + x + " no");
                       break;
                   }else{
                       //System.out.println("list y:" + list.get(s)[0] + " x:" + list.get(s)[1] +" to map y:" +y + " x:" + x +  " yes");
                       location[count][0] = y;
                       location[count][1] = x;
                       count++;
                   }
               }
           }
       }
       
       if(count == list.size()){
           for(int[] l : location){
               map[l[0]][l[1]] = 1;
           }
           result += count;
           return true;
       }
        return false;
    }
}
