import java.io.*;

public class Main {

    public static BufferedWriter bw;
    public static int[][] array;
    public static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        array = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                array[i][j] = Integer.parseInt(s[j]);
            }
        }

        recur(0,n,0,n);

        for(int i=0; i<3; i++) {
            bw.write(result[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void recur(int colS, int colE, int rowS, int rowE){
        int len = rowE-rowS;

        if(!check(colS,colE, rowS,rowE)){
            recur(colS,colS+len/3, rowS,rowS+len/3); // 0~1, 0~1
            recur(colS,colS+len/3, rowS+len/3,rowS+len*2/3); // 0~1, 1~2
            recur(colS,colS+len/3, rowS+len*2/3,rowS+len); // 0~1, 2~3

            recur(colS+len/3,colS+len*2/3, rowS,rowS+len/3); // 1~2, 0~1
            recur(colS+len/3,colS+len*2/3, rowS+len/3,rowS+len*2/3);// 1~2, 1~2
            recur(colS+len/3,colS+len*2/3, rowS+len*2/3,rowS+len); // 1~2, 2~3

            recur(colS+len*2/3,colS+len, rowS,rowS+len/3); // 2~3, 0~1
            recur(colS+len*2/3,colS+len, rowS+len/3,rowS+len*2/3); // 2~3, 1~2
            recur(colS+len*2/3,colS+len, rowS+len*2/3,rowS+len); // 2~3, 2~3
        }else{
            result[array[colS][rowS]+1]++;
        }
    }

    public static boolean check(int colS, int colE, int rowS, int rowE){
        int stand = array[colS][rowS];

        for(int j=colS; j<colE; j++) {
            for(int i=rowS; i<rowE; i++) {
                if(array[j][i] != stand){
                    return false;
                }
            }
        }
        return true;
    }
}