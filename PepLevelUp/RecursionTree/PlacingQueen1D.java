package PepLevelUp.RecursionTree;

public class PlacingQueen1D {

    // From Video of 30th march

    // [0,0,0,0,0]
    // Above are boxes, you have to place 3 queens such that if Queen0 is placed in
    // box 0 than rest 2 queens will be placed in box 1 and further(aage ke boxes hi
    // rakh sakte hain).
    // So this question is same as Coin Change combination where we can go ahead
    // only and cannot go back

    // qpsf: Queen placed so far
    private static int placeQueenCombination1D(int[] nums, int qpsf, int idx, String qsf) {
        if (qpsf == 3) {
            System.out.println(qsf);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < nums.length; i++) {
            count += placeQueenCombination1D(nums, qpsf + 1, i + 1, qsf + "b" + i + "q" + qpsf + " ");
        }
        return count;

    }

    // 2nd case can be when queen can be placed in any previous box too i.e.
    // Permutation
    private static int placeQueenPermutation1D(int[] nums, int qpsf, String qsf) {
        if (qpsf == 3) {
            System.out.println(qsf);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1000) {
                int item = nums[i];

                nums[i] = -1000;
                count += placeQueenPermutation1D(nums, qpsf + 1, qsf + "b" + i + "q" + qpsf + " ");
                nums[i] = item;
            }
        }
        return count;

    }

    // Solution using subsequence approach
    public static void PlaceQueenCombination_Subs(int[] nums, int qpsf, int idx, String psf) {
        if (qpsf == 3 || idx == nums.length) {
            if (qpsf == 3) {
                System.out.println(psf);
            }
            return;
        }

        if (idx <= 3) {
            PlaceQueenCombination_Subs(nums, qpsf + 1, idx, psf + "b" + idx + "q" + qpsf + " ");

        }
        PlaceQueenCombination_Subs(nums, qpsf, idx + 1, psf);
        return;
    }

    public static void main(String[] args) {
        int[] nums = new int[6];
        
        // int result = placeQueenCombination1D(nums, 0, 0, "");
        // int result = placeQueenPermutation1D(nums, 0, "");

        PlaceQueenCombination_Subs(nums, 0, 0, "");
        // System.out.println(result);

    }
}
