package AdobeQues;

//https://practice.geeksforgeeks.org/problems/special-numbers4116/1

//Logic is :
// 1*10+0 = 10 
// 1*10+1 = 11 
// 1*10+2 = 12 
// 1*10+3 = 13 
// 1*10+4 = 14 
// 1*10+5 = 15
// and after that next 6 numbers will be- 
// 2*10+0 = 20 
// 2*10+1 = 21 
// 2*10+2 = 22 
// 2*10+3 = 23 

//Here:
// 'b' is the mod with 6
// 'x' is ten's value like 1..10..100..1000 like that - 'x' will be multiplied with 'mod' to calcuulate answer till N!=0
// Keep dividing N by 6 to iterate

public class SpecialNumber {
    public static long getSpecialNumber(int N) {
        N--;
        int x = 1, ans = 0;
        while (N != 0) {
            int b = N % 6;
            ans = (x * b) + ans;
            N /= 6;
            x *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        long result = getSpecialNumber(20);
        System.out.println(result);
    }

}
