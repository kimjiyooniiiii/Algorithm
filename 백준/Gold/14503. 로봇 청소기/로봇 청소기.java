import java.io.*;

public class Main {

    public static int[][] map;
    public static int n,m;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new int[n][m];

        String[] start = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int y = Integer.parseInt(start[0]);
        int x = Integer.parseInt(start[1]);
        int direction = Integer.parseInt(start[2]);
        int count = 0;

        while(y-1>=0 && x-1>=0 && y+1<n && x+1<m){
            // 현재칸 청소
            if(map[y][x] == 0){
              //  System.out.println("clean " + y + " " + x);
                map[y][x] = 2;
                count++;
            }
            // 빈칸 없으면
            if(!isBlank(y,x)){
                // 후진할 수 있는지
                if(checkBack(y,x,direction)){
                    if(direction==0){
            //            System.out.println("go to " + y + " " + x + "-> " + (y+1) + " " + x);
                        y = y+1;
                    }else if(direction==1){
               //         System.out.println("go to " + y + " " + x + "-> " + (y) + " " + (x-1));
                        x = x-1;
                    }else if(direction==2){
               //         System.out.println("go to " + y + " " + x + "-> " + (y-1) + " " + x);
                        y = y-1;
                    }else if(direction==3){
               //         System.out.println("go to " + y + " " + x + "-> " + y + " " + (x+1));
                        x = x+1;
                    }
                }
                // 후진못하면 끝
                else{
                    break;
                }
            }
            // 빈칸 있으면
            else{
                if(direction==0){
                    direction = 3;
                    if(map[y][x-1] == 0){
                //        System.out.println("rotation 0->3" + "go to " + y + " " + x + "-> " + (y) + " " + (x-1));
                        x = x-1;
                    }
                }else if(direction == 1){
                    direction = 0;
                    if(map[y-1][x] == 0){
             //           System.out.println("rotation 1->0" + "go to " + y + " " + x + "-> " + (y-1) + " " + (x));
                        y = y-1;
                    }

                }else if(direction == 2){
                    direction = 1;

                    if(map[y][x+1] == 0){
              //          System.out.println("rotation 2->1" + "go to " + y + " " + x + "-> " + (y) + " " + (x+1));
                        x = x+1;
                    }
                }else if (direction == 3){
                    direction = 2;

                    if(map[y+1][x] == 0){
             //           System.out.println("rotation 3->2" + "go to " + y + " " + x + "-> " + (y+1) + " " + (x));
                        y = y+1;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isBlank(int y, int x){
            if(map[y-1][x] == 0 || map[y+1][x] == 0 || map[y][x-1] == 0 || map[y][x+1]==0){
         //       System.out.println(y + " " + x + " blank true");
                return true;
            }
      //  System.out.println(y + " " + x + " blank false");
        return false;
    }

    public static boolean checkBack(int y, int x, int direction){
        if(direction == 0 && map[y+1][x] == 1) {
      //      System.out.println(y + " " + x + "direction " + direction + " no back");
            return false;
        }else if(direction == 1 && map[y][x-1]==1){
      //      System.out.println(y + " " + x + "direction " + direction + " no back");
            return false;
        }else if(direction == 2 && map[y-1][x] == 1){
      //      System.out.println(y + " " + x + "direction " + direction + " no back");
            return false;
        }else if(direction == 3 && map[y][x+1] == 1){
      //      System.out.println(y + " " + x + "direction " + direction + " no back");
            return false;
        }
      //  System.out.println(y + " " + x + "direction " + direction + " yest back");
        return true;
    }

}
