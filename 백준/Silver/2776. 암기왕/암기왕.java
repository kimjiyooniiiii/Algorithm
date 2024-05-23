import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int t,n,m;
    private static int nArray[], mArray[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int j=0; j<t; j++){
            input(br);
            m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<m; i++){
                bw.write(isCorrect(Integer.parseInt(st.nextToken()),0,n-1)+"\n");
            }
            bw.flush();
        }
        bw.close();

    }
    public static int isCorrect(int num, int start, int end){
        if(start > end){
            return 0;
        }
        int middle = (end + start) / 2;
        int compare = nArray[middle];
        if(compare == num){
            return 1;
        }
        else if(compare > num){
            return isCorrect(num, start, middle-1);
        }else{
            return isCorrect(num, middle+1, end);
        }
    }

    public static void input(BufferedReader br) throws IOException {

            n = Integer.parseInt(br.readLine());
            nArray = new int[n];
            String[] nInput = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                nArray[i] = Integer.parseInt(nInput[i]);
            }
            Arrays.sort(nArray);


    }
}

