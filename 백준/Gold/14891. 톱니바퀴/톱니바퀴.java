import java.io.*;
import java.util.*;

public class Main {

    public static Deque<Integer> one = new LinkedList<>();
    public static Deque<Integer> two = new LinkedList<>();
    public static Deque<Integer> three = new LinkedList<>();
    public static Deque<Integer> four = new LinkedList<>();


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split("");
        for(int j=0; j<8; j++){
            one.add(Integer.parseInt(line[j]));
        }
        String[] line2 = br.readLine().split("");
        for(int j=0; j<8; j++){
            two.add(Integer.parseInt(line2[j]));
        }
        String[] line3 = br.readLine().split("");
        for(int j=0; j<8; j++){
            three.add(Integer.parseInt(line3[j]));
        }
        String[] line4 = br.readLine().split("");
        for(int j=0; j<8; j++){
            four.add(Integer.parseInt(line4[j]));
        }

        int test = Integer.parseInt(br.readLine());
        for(int i=0; i<test; i++){
            String[] condition = br.readLine().split(" ");
            int num = Integer.parseInt(condition[0]);
            int direction = Integer.parseInt(condition[1]);
            Queue<int[]> q = new LinkedList<>();

            int oneEast = getWestEast("one", 2);
            int twoWest = getWestEast("two", 6);
            int twoEast = getWestEast("two", 2);
            int threeWest = getWestEast("three", 6);
            int threeEast = getWestEast("three", 2);
            int fourWest = getWestEast("four", 6);

            if(num == 1){
                q.add(new int[]{1, (direction)});
                if(oneEast != twoWest){
                    q.add(new int[]{2, (direction*(-1))});
                    if(twoEast != threeWest){
                        q.add(new int[]{3, (direction)});
                        if(threeEast != fourWest){
                            q.add(new int[]{4, (direction*(-1))});
                        }
                    }
                }
            }else if(num == 2){
                q.add(new int[]{2, (direction)});
                if(oneEast != twoWest) {
                    q.add(new int[]{1, (direction * (-1))});
                }
                if(twoEast != threeWest){
                    q.add(new int[]{3, (direction* (-1))});
                    if(threeEast != fourWest){
                        q.add(new int[]{4, (direction)});
                    }
                }
            }else if(num == 3){
                q.add(new int[]{3, (direction)});
                if(twoEast != threeWest){
                    q.add(new int[]{2, (direction* (-1))});
                    if(oneEast != twoWest){
                        q.add(new int[]{1, (direction)});
                    }
                }
                if(threeEast != fourWest){
                    q.add(new int[]{4, (direction * (-1))});
                }
            }else if(num == 4){
                q.add(new int[]{4, (direction)});
                if(threeEast != fourWest){
                    q.add(new int[]{3, (direction * (-1))});
                    if(twoEast != threeWest) {
                        q.add(new int[]{2, (direction)});
                        if(oneEast != twoWest){
                            q.add(new int[]{1, (direction * (-1))});
                        }
                    }
                }
            }

            while(!q.isEmpty()){
                int[] poll = q.poll();
                int topni = poll[0];
                int rotation = poll[1];

                //System.out.println(topni + " " + rotation);

                switch (topni) {
                    case 1 :
                        if(rotation == 1) {
                            one.addFirst(one.pollLast());
                        }else{
                            one.add(one.pollFirst());
                        }
                        break;
                    case 2:
                        if(rotation == 1) {
                            two.addFirst(two.pollLast());
                        }else{
                            two.add(two.pollFirst());
                        }
                        break;
                    case 3:
                        if(rotation == 1) {
                            three.addFirst(three.pollLast());
                        }else{
                            three.add(three.pollFirst());
                        }
                        break;
                    case 4:
                        if(rotation == 1) {
                            four.addFirst(four.pollLast());
                        }else{
                            four.add(four.pollFirst());
                        }
                        break;
                }
            }
//            System.out.println(one);
//            System.out.println(two);
//            System.out.println(three);
//            System.out.println(four);
//            System.out.println();
        }

        int sum = 0;
        if(one.peek() == 0){
            sum += 0;
        }else{
            sum += 1;
        }
        if(two.peek() == 0){
            sum += 0;
        }else{
            sum += 2;
        }
        if(three.peek() == 0){
            sum += 0;
        }else{
            sum += 4;
        }
        if(four.peek() == 0){
            sum += 0;
        }else{
            sum += 8;
        }
        System.out.println(sum);
    }


    // 동,서쪽의 극 구하기
    public static int getWestEast(String tobni, int index){
        int dir = 0;

        for(int i=0; i<index; i++){
            if(tobni.equals("one")){
                one.add(one.pollFirst());
            }else if(tobni.equals("two")){
            //    System.out.println("prev two " + two);
                two.add(two.pollFirst());
            //    System.out.println("two " + two);
            }else if(tobni.equals("three")){
                three.add(three.pollFirst());
            }else if(tobni.equals("four")){
                four.add(four.pollFirst());
            }
        }

        if(tobni.equals("one")){
            dir = one.peek();
        }else if(tobni.equals("two")){
            dir = two.peek();
        }else if(tobni.equals("three")){
            dir = three.peek();
        }else if(tobni.equals("four")){
            dir = four.peek();
        }

        for(int i=0; i<index; i++){
            if(tobni.equals("one")){
                one.addFirst(one.pollLast());
            }else if(tobni.equals("two")){
          //      System.out.println("prev two " + two);
                two.addFirst(two.pollLast());
        //        System.out.println("two " + two);
            }else if(tobni.equals("three")){
                three.addFirst(three.pollLast());
            }else if(tobni.equals("four")){
                four.addFirst(four.pollLast());
            }
        }
        return dir;
    }
}
