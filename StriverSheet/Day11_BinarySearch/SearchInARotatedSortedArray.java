package StriverSheet.Day11_BinarySearch;

public class SearchInARotatedSortedArray {

    // We used Binary search
    // Idea is:  Har baar array ko break karenge aur sabse pehle mid par element ko
    // check kar lenege ..if yes to wahi se return kar denge...if 'no' than
    // dekhenge ki kya array ka left part sorted hai.. agar hai to kya target 'low'
    // or 'mid' ki range mai aa rha hai...agar 'yes' to usme hi element milega to
    // 'high' ko mid-1 par set kar denege.. else 'low' ko (mid+1) set kar denge...

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target)
                return mid;
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String args[]) {
        // int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        // int target = 0;

        // int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        // int target = 3;

        int arr[] = { 5, 1, 3 };
        int target = 3;

        System.out.println("The index in which the number is present is " + search(arr, target));

    }

}
