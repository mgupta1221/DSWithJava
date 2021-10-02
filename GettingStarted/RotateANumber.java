package GettingStarted;

/**
 * https://www.youtube.com/watch?v=lt8oCGqYMGg&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=26
 */
public class RotateANumber {

    public static void main(String[] args) {
        int n = 27391;
        int rotationRequired = -2;

        int tempNumber = n;
        int currentDigit;
        int count = 0;

        // Counting the number of digits in the number
        while (tempNumber != 0) {
            tempNumber = tempNumber / 10;
            count++;
        }

        // Handling negative value of rotation required - Rotating by 3 is same as rotating by -2
        if (rotationRequired < 0) {
            rotationRequired = (count + rotationRequired);
        }

        tempNumber = n;

        while (rotationRequired != 0) {
            currentDigit = tempNumber % 10;
            tempNumber = tempNumber / 10;

            rotationRequired--;
            tempNumber = currentDigit * (int) Math.pow(10, count - 1) + tempNumber;
        }

        System.out.println("Rotated number is: " + tempNumber);

    }
}
