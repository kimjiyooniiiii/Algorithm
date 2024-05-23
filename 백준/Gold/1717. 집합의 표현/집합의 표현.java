import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[] combi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input(br);
        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int value = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(value == 0){
                union(a,b);
            }else if(value == 1){
                if(recur(a) == recur(b)){
                    bw.write("yes" + "\n");
                    bw.flush();
                }else{
                    bw.write("no" + "\n");
                    bw.flush();
                }
            }
        }
        bw.close();
    }
    public static int recur(int num){
        if(num == combi[num]){
            return num;
        }
        return combi[num] = recur(combi[num]);
    }

    public static void union(int a, int b){
        int aP = recur(a);
        int bP = recur(b);

        if(aP < bP){
            combi[bP] = aP;
        }else if(aP > bP){
            combi[aP] = bP;
        }
    }

    public static void input(BufferedReader br) throws IOException {
        String[] condition = br.readLine().split(" ");
        n = Integer.parseInt(condition[0]);
        m = Integer.parseInt(condition[1]);
        combi = new int[n+1];

        for(int i=0; i<n+1; i++){
            combi[i] = i;
        }
    }
}

