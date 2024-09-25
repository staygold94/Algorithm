import java.util.*;
import java.io.*;

public class Main {
    public static int n, answer;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(arr, 0);

        System.out.println(answer);
    }

    public static void dfs(int[][] board, int depth) {

        if(depth == 5) {
            answer = Math.max(answer, getMaxValue(board));
            return;
        }

        for(int i=0; i<4; i++) {
            int[][] newBoard = getNewBoard(board, i);
            dfs(newBoard, depth+1);
        }
    }

    public static int[][] getNewBoard(int[][] board, int direction) {

        int[][] newBoard = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(newBoard[i], 0);
        }

        for(int i=0; i<n; i++) {
            // 왼쪽
            if(direction == 0) {
                List<Integer> list = new ArrayList<>();
                for(int j=0; j<n; j++) {
                    if(board[i][j] != 0) list.add(board[i][j]);
                }
                list = mergeList(list);

                for(int j=0; j<list.size(); j++) {
                    newBoard[i][j] = list.get(j);
                }
                
            // 오른쪽
            } else if(direction == 1) {
                List<Integer> list = new ArrayList<>();
                for(int j=n-1; j>=0; j--) {
                    if(board[i][j] != 0) list.add(board[i][j]);
                }
                list = mergeList(list);

                for(int j=0; j<list.size(); j++) {
                    newBoard[i][j] = list.get(j);
                }

            // 위
            } else if(direction == 2) {
                List<Integer> list = new ArrayList<>();
                for(int j=0; j<n; j++) {
                    if(board[j][i] != 0) list.add(board[j][i]);
                }
                list = mergeList(list);

                for(int j=0; j<list.size(); j++) {
                    newBoard[j][i] = list.get(j);
                }
            // 아래
            } else if(direction == 3) {
                List<Integer> list = new ArrayList<>();
                for(int j=n-1; j>=0; j--) {
                    if(board[j][i] != 0) list.add(board[j][i]);
                }
                list = mergeList(list);

                for(int j=0; j<list.size(); j++) {
                    newBoard[j][i] = list.get(j);
                }
            }
        }

        return newBoard;
    }

    public static List<Integer> mergeList(List<Integer> list) {

        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i).equals(list.get(i+1))) { // Integer 객체가 동일값인지 비교
                list.set(i, list.get(i) * 2);       // 해당 위치 업데이트
                list.remove(i+1);                   // 그 다음 위치 삭제
            }
        }

        return list;
    }

    public static int getMaxValue(int[][] board) {
        int max = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                max = Math.max(max, board[i][j]);
            }
        }

        return max;
    }
}