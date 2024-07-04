import java.io.*;

public class Main {
    private static int n, k;
    private static int[][] table;
    private static int[][] stuff;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input(br);

        for(int i=0; i<n; i++) {
            if(stuff[i][0] > k){
                for(int j=0; j<k+1; j++){
                    if (i != 0) {
                        table[j][i] = table[j][i - 1];
                    }
                }
                continue;
            }
            for (int j = 0; j < stuff[i][0]; j++) {
                if (i != 0) {
                    table[j][i] = table[j][i - 1];
                }
            }
            for (int j = stuff[i][0]; j < k + 1; j++) {
                if(i == 0){
                    table[j][i] = stuff[i][1];
                }else{
                    int diff = j-stuff[i][0];   // 최대로 넣을 수 있는 무게에서 자신의 무게를 뺀 결과
                    table[j][i] = Math.max(table[j][i - 1], stuff[i][1] + table[diff][i-1]);
                }
            }
        }
//        for(int[] t : table){
//            for(int a : t){
//                System.out.print(a + " ");
//            }
//            System.out.println();
//        }
         System.out.println(table[k][n-1]);

    }

//    public static int solution(String[] board) {
//        int answer = 0;
//
//        return answer;
//    }

    public static void input(BufferedReader br) throws IOException {
        String[] condition = br.readLine().split(" ");
        n = Integer.parseInt(condition[0]);
        k = Integer.parseInt(condition[1]);
        table = new int[k+1][n];
        stuff = new int[n][2];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            stuff[i][0] = Integer.parseInt(line[0]);
            stuff[i][1] = Integer.parseInt(line[1]);
        }
    }
}

