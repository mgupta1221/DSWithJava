package GettingStartedBasics.GettingStarted;

/**
 * https://www.youtube.com/watch?v=lt8oCGqYMGg&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=26
 * 
 * //Solved with 2 approaches below
 */
public class RotateANumber {

    public static void main(String[] args) {

        // Approach 1 -Slower one

        // int n = 27391;
        // int rotationRequired = -2;
        // int tempNumber = n;
        // int currentDigit;
        // int count = 0;

        // // Counting the number of digits in the number
        // while (tempNumber != 0) {
        // tempNumber = tempNumber / 10;
        // count++;
        // }

        // // Handling negative value of rotation required - Rotating by 3 is same as
        // // rotating by -2
        // if (rotationRequired < 0) {
        // rotationRequired = (count + rotationRequired);
        // }

        // tempNumber = n;

        // while (rotationRequired != 0) {
        // currentDigit = tempNumber % 10;
        // tempNumber = tempNumber / 10;

        // rotationRequired--;
        // tempNumber = currentDigit * (int) Math.pow(10, count - 1) + tempNumber;
        // }

        // System.out.println("Rotated number is: " + tempNumber);

        // Appraoch 1 Ends




        

        // Approach 2 -Efficient one
        // Lets say number is 27391 and it has to be rotated twice, final answer would
        // be 91273
        // To solve this, Take 273 and reverse it i.e. 372, take the other half which is
        // 91 and reverse it 19
        // Combine both i.e. 37219 and reverse the whole number - 91273

        // It works becuase:
        // P1 P2 (say we want to reverse till P1)
        // P1' P2' (reverse them individually P1' means reverse of P1)
        // P2" P1" (reversing them toegther, reversing a string twice will lead to the
        // same orginal string)
        int n = 27391;
        int rotationRequired = 2;

        // putting number digits into an array, first counting digits than defining
        // array and putting digits into an array

        int temp = n;
        int rem = 0;
        int digitCount = 0;
        while (temp != 0) {
            rem = temp % 10;
            temp = temp / 10;
            digitCount++;

        }
        int[] arr = new int[digitCount];
        int counter = arr.length - 1;
        temp = n;
        while (counter >= 0) {
            arr[counter] = temp % 10;
            temp = temp / 10;
            counter--;
        }

        // rotating first part
        int low = 0;
        int high = digitCount - rotationRequired - 1;
        while (low < high) {
            int temp1 = arr[high];
            arr[high] = arr[low];
            arr[low] = temp1;
            low++;
            high--;
        }
        // rotating second part
        low = digitCount - rotationRequired;
        high = arr.length - 1;
        while (low < high) {
            int temp1 = arr[high];
            arr[high] = arr[low];
            arr[low] = temp1;
            low++;
            high--;
        }

        // rotating full array now
        low = 0;
        high = arr.length - 1;
        while (low < high) {
            int temp1 = arr[high];
            arr[high] = arr[low];
            arr[low] = temp1;
            low++;
            high--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }
}
