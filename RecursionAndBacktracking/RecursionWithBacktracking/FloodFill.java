
public class FloodFill {

    // Question :
    // https://www.youtube.com/watch?v=FkkgY7qQF_s&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=47

    // Solution:
    // www.youtube.com/watch?v=R1URUB6_y2k&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=48

    // This method will use printing technique (not returning values technique)

    public static void main(String[] args) {

        // Taking automated hardcoded Input

        // Big Input
        // int m = 6;
        // int n = 7;

        // var str = "0 1 0 0 0 0 0 0 1 0 1 1 1 0 0 0 0 0 0 0 0 1 0 1 1 0 1 1 1 0 1 1 0
        // 1 1 1 0 0 0 0 0 0";
        // String[] elementsInArrayFormat = str.split(" ");
        // int[][] arr = new int[m][n];
        // int conter = 0;
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // arr[i][j] = Integer.parseInt(elementsInArrayFormat[conter]);
        // conter++;
        // }
        // }
        // // printMatrix(arr);
        // // floodFill(arr, 0, 0, "");

        // Small Input
        int m = 4;
        int n = 3;

        var str = "0 1 1 0 0 1 1 0 0 0 1 0";
        String[] elementsInArrayFormat = str.split(" ");
        int[][] arr = new int[m][n];
        int conter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(elementsInArrayFormat[conter]);
                conter++;
            }
        }

        printMatrix(arr);

        // This visted array is required to keep track of visited array else the code
        // will run into infinite loop, see solution video
        boolean[][] visited = new boolean[m][n];
        floodFill(arr, 0, 0, "", visited);
    }

    public static void floodFill(int[][] arr, int r, int c, String ans, boolean[][] visited) {

        // Notice the condition "arr[r][c] == 1" placed at the end becuase '1' is
        // obstacle and it should be placed at the end in all OR conditons

        // Also, Notice the condition "visited[r][c]==true" placed at the end becuase we
        // do not want to revisit the cell for one single path

        if (r < 0 || c < 0 || r == arr.length || c == arr[0].length || arr[r][c] == 1 || visited[r][c] == true) {
            return;
        }
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            System.out.print(ans + "\t");
            return;
        }
        visited[r][c] = true;

        floodFill(arr, r - 1, c, ans + "t", visited);
        floodFill(arr, r, c - 1, ans + "l", visited);
        floodFill(arr, r + 1, c, ans + "d", visited);
        floodFill(arr, r, c + 1, ans + "r", visited);

        // Vistied set to false is very important becuase if one path is fully
        // covered(t,l,d,r),you have to unmark it to explore other paths using those
        // cells
        visited[r][c] = false;

    }

    public static void printMatrix(int[][] arr) {
        int p = arr.length;
        int q = arr[0].length;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
