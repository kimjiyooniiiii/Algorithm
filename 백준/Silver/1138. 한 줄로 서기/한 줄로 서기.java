import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] speak = new int[n];

        for(int i=0; i<speak.length; i++){
            speak[i] = Integer.parseInt(input[i]);
        }// 입력 끝

        int number = 0;
        List<Integer> result = new ArrayList<>();

        while(result.size() != n){
            int front = 0;
            for(int i=0; i<speak.length; i++){
                int current = i+1;
                if(number == 0 && speak[i] == 0){
                    result.add(current);
                }
                else if(speak[i] == number){
                    int count = 0;
                    for(int j=0; j<result.size(); j++){
                        if(result.get(j) > current){
                            count++;
                        }
                        if((count == number && j==result.size()-1) || (count == number && result.get(j+1) > current)){
                            result.add(j+1,current);
                            //front++;
                            break;
                        }
                    }
                }
            }
            number++;
        }

        for(int i=0; i<result.size(); i++){
            if(i == result.size()-1){
                bw.write(result.get(i)+"");
                bw.flush();
            }else{
                bw.write(result.get(i)+" ");
                bw.flush();
            }
        }
        bw.close();
    }

}