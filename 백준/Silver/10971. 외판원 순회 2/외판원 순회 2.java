import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int[] course;
    public static int[][] matrix;
    public static int[] space;
    public static boolean[] isVisited;
    public static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        course = new int[n];
        isVisited = new boolean[n];
        min = n*1000000;

        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        recur(0);

        bw.write(min + "");
        bw.flush();
        bw.close();
    }

    public static void recur(int count) {
        if(count == n) {
            int sum = 0;
            int start = course[0];
            for(int i=0; i<course.length-1; i++) {
                if(matrix[course[i]][course[i+1]] == 0){
                    return;
                }
                sum += matrix[course[i]][course[i+1]];
            }
            int end = course[course.length-1];
            if(matrix[end][start] == 0) return;

            sum += matrix[end][start];
            min = Math.min(min, sum);
        } else{
            for(int i=0; i<n; i++){
                if(!isVisited[i]){
                    isVisited[i] = true;
                    course[count] = i;

                    recur(count+1);
                    isVisited[i] = false;
                }
            }
        }
    }

}