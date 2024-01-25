import java.io.*;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;

    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");

            char root = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            insertNode(head, root, left, right);
        }

        preOrder(head);
        bw.write("\n");
        bw.flush();

        inOrder(head);
        bw.write("\n");
        bw.flush();

        postOrder(head);

        bw.close();
    }

    static class Node {
        private char value;
        private Node left;
        private Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node temp, char root, char left, char right) {
        if(temp.value == root) {
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        } else{
            if(temp.left != null ) insertNode(temp.left, root, left, right);
            if(temp.right != null) insertNode(temp.right, root, left, right);
        }
    }

    public static void preOrder(Node node) throws IOException {
        if(node == null) {
            return;
        }
        bw.write(node.value);
        bw.flush();
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) throws IOException {
        if(node == null){
            return;
        }
        inOrder(node.left);
        bw.write(node.value);
        bw.flush();
        inOrder(node.right);
    }

    public static void postOrder(Node node) throws IOException {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        bw.write(node.value);
        bw.flush();
    }
}