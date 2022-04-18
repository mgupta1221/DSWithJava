package PepLevelUp.RecursionTree;

public class PlacingQueen2D {

    // From Video of 30th march

    // [0,0,0,0,0]
    // [0,0,0,0,0]
    // [0,0,0,0,0]
    // Above are boxes in 2D, you have to place 3 queens such that if Queen0 is
    // placed in
    // one cell (x,y) than rest 2 queens will be placed in cells after it (aage ke
    // boxes mai hi
    // rakh sakte hain).
    // We have to find all combination of cells where 3 queens can be placed.

    // Check video recording for solution description

    // qpsf: Queen placed so far
    // We will use the combination approach only.
    private static int placeQueen_Combination2D(int[][] nums, int qpsf, int idx, String qsf) {

        if (qpsf == 4) {
            System.out.println(qsf);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < nums.length * nums.length; i++) {
            int row = i / nums.length; // for any cell, this formula will give the row value
            int col = i % nums.length; // for any cell, this formula will give the column value
            count += placeQueen_Combination2D(nums, qpsf + 1, i + 1, qsf + "(" + row + "," + col + ")");
        }
        return count;

    }

    public static void main(String[] args) {
        int[][] nums = new int[4][4];

        int result = placeQueen_Combination2D(nums, 0, 0, "");
        System.out.println(result);

    }
}
