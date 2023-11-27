import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<String> numList = new ArrayList<>();
    static int n;
    static boolean[] isVisited;
    static int[] makeArray;
    static String search = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //1~n까지 이루어지는 순열
        n = Integer.parseInt(br.readLine());
        /*isVisited = new boolean[n+1];
        makeArray = new int[n+1];

        make(0);

        System.out.println(numList);*/

        String[] input = br.readLine().split(" ");
        Integer[] intInput = new Integer[n];
        for(int i=0; i<n; i++){
            intInput[i] = Integer.parseInt(input[i]);
        }

        for(int i=intInput.length-1; i>=0; i--){
            if(i==0){
                    System.out.print(-1);
                    return;
            }
            int current = intInput[i];
            int prev = intInput[i-1];

            if(prev > current){
                Arrays.sort(intInput, i,intInput.length, Collections.reverseOrder());
                int max = 0;
                int maxIndex = 0;
                for(int j=i; j<intInput.length; j++){
                    if(intInput[j] > max && intInput[j] < prev){
                        max = intInput[j];
                        maxIndex = j;
                    }
                }
                intInput[i-1] = max;
                intInput[maxIndex] = prev;

                for(int x=0; x<intInput.length; x++){
                    if(x == intInput.length-1){
                        System.out.print(intInput[x] + "\n");
                    }else{
                        System.out.print(intInput[x]+" ");
                    }
                }
                return;
            }
        }
    }

    /*public static void make(int r){
        if(r == n){
            String result = "";
            for(int i=1; i<makeArray.length; i++){
                result += String.valueOf(makeArray[i]);
            }
            numList.add(result);
            return;
        }else{
            for(int i=1; i<=n; i++){
                if(isVisited[i] == false){
                    isVisited[i] = true;
                    makeArray[r+1] = i;
                    make(r+1);
                    isVisited[i] = false;
                }
            }
        }
    }*/
}