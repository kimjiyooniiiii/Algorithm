import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int n,m;
    public static int[][] town;
    public static List<Integer> home = new ArrayList<>();
    public static List<Integer> store = new ArrayList<>();
    public static int[] combi;
    public static int minDistance = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input(br);

        // store에서 m개를 조합하고, 조합한 결과들과 집의 최소거리를 구해
        back(-1,0);
        System.out.println(minDistance);
    }
    public static void back(int prev, int len){
        if(len == m){
//            System.out.print("조합 ");
//            for(int r : combi){
//                System.out.print((r/n) + " " + (r%n) + " , ");
//            }
//            System.out.println();
            // m개를 모았으니, 도시 치킨 거리 구하기
            int distance = chickenRoad();
            minDistance = Math.min(minDistance, distance);
           // System.out.println(distance + "     --------------------------");
            return;
        }
        for(int i=0; i<store.size(); i++){
            if(prev < store.get(i)){
                combi[len] = store.get(i);
                back(store.get(i),len+1);
            }
        }
    }

    public static int chickenRoad(){
        int sumDistance = 0;
        for(int i=0; i<home.size(); i++){
            int homeY = home.get(i) / n;
            int homeX = home.get(i) % n;
            int minY = 0, minX = 0;

            int distance = 100;
            for(int j=0; j<combi.length; j++){
                int chiY = combi[j] / n;
                int chiX = combi[j] % n;
                if(distance > Math.abs(homeY-chiY) + Math.abs(homeX-chiX)){
                    minY = chiY;    minX = chiX;
                }

                distance = Math.min(distance, Math.abs(homeY-chiY) + Math.abs(homeX-chiX));

            }
            sumDistance += distance;

            //System.out.println("집 " + homeY + " " + homeX + "  치킨집 " + minY + " " + minX + " 거리는 " + distance);
        }
        return sumDistance;
    }

    public static void input(BufferedReader br) throws IOException {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        town = new int[n][n];
        combi = new int[m];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                if(line[j].equals("1")){
                    home.add(n*i+j);
                }else if(line[j].equals("2")){
                    store.add(n*i+j);
                }
                town[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
