import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char data;
        Node left;
        Node right;
    
        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static Node head = new Node('A', null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head, root, left, right);
        }

        getPreorder(head);
        System.out.println();

        getInorder(head);
        System.out.println();

        getPostorder(head);
        System.out.println();
    }

    public static void insertNode(Node head, char root, char left, char right) {

        // 현재 넣고자 하는 노드라면
        if(head.data == root) {
            head.left = (left == '.') ? null : new Node(left, null, null);
            head.right = (right == '.') ? null : new Node(right, null, null);

        // 넣고자 하는 노드가 아니면 이동
        } else {
            if(head.left != null) insertNode(head.left, root, left, right);
            if(head.right != null) insertNode(head.right, root, left, right);
        }
    }

    public static void getPreorder(Node node) {
        
        System.out.print(node.data);
        
        if(node.left != null) getPreorder(node.left);

        if(node.right != null) getPreorder(node.right);
    }

    public static void getInorder(Node node) {
        
        if(node.left != null) getInorder(node.left);

        System.out.print(node.data);
        
        if(node.right != null) getInorder(node.right);
    }

    public static void getPostorder(Node node) {
        
        if(node.left != null) getPostorder(node.left);        
        
        if(node.right != null) getPostorder(node.right);

        System.out.print(node.data);
    }
}