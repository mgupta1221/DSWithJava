1. GettingStartedBasics
2. Recursion And Backtracking

Educative.io  for System Design
Gaurav Sen for HLD and System Design
Udit Agarwal (youtube) for LLD
Head First Book for Object Oriented Analysis and patterns


Tips:
1. 2DArray Spiral display and Rotation concepts are used in DP problems

//NADOS Questions covered here
https://nados.pepcoding.com/content/0



Refer Readme files in individual folders here as well 


JAVA Tips

Strings
1.

char leftChar = str.charAt(low); // See how we pick charcters by index using charAt()


2. To compare strings use "Equals()"
to compare chars, use normal == or !=

3.How to convert char to string
 
 //Aproach 1: String outputString = ch + ""; //this is a shortcut
 
 //Approach 2: String outputString =Character.toString(ch);

4. How to check if a charcter is upper or lower Case
 if (newChar >= 'a' && newChar <= 'z') { //means lower case ELSE upper case

5. How to toggle character from lower case to Upper case

say newChar = 'b';
char UpperCaseB=   (char) (newChar - 32)  // notice we substracting with 32 which will give us an interger so we have to typecast


say newChar = 'B';
char UpperCaseB=   (char) (newChar + 32)  // Adding with 32 here if character is uppercase

6. How to convert '6' to 6

 char c = '6';
 System.out.println((char) (c - '0'));  
 
 //this works becuase ascii of '6' is 54 and of '0' (0 gets typecast to '0' automatically here) 
 //is 48, so the differnece is 6

 //ASCII code of '0' is 48



6. 2 variations of substring method   => str.substring(startIndex, endIndex)

say str= "hello";
str.substring(1,3)   //   "el"    -> does not print the last index charcter, second  'l' in this case
str.substring(1)     //   "ello" -> print from the given index till the endF




7. Replace a character in a string at specific index

Solution:
Convert the string to StringBuilder. StringBuilder has a function called setCharAt(). See below:

  String str = "IamGood";
  StringBuilder sbr = new StringBuilder(str);

   sbr.setCharAt(2, 'p');  //2 is the index and 'p' is the chracter which will be placed instead of 'm'(index 2)


ArrayList
7. How to declare ArrayList 

ArrayList<Integer> arr= new ArrayList<>();

8. Get the length of ArrayList
arr.size()

9. Get the value at index if
arr.get(i)

10. Remove element from ArrayList
arr.remove(i)

11. Taking specific elements from ArrayList, use Sublist() function. Note that it does not 
return ArrayList<String>, instead it returns  List<String> which you can convert to ArrayList as below:

 List<String> remValues = alphaValues.subList(1, alphaValues.size()); 
 //Here we are taking all values of ArrayList except first value - Notice SubList returns List<String>


You can convert List<String> to ArrayList<String> as below:
ArrayList<String> values = new ArrayList<String>(alphaValues.subList(1, alphaValues.size()));



//Whenever removal from ArrayList is required, always iterate the arraylist from right. This is becuase on removal, index
//of all elements to the right reduces by 1 so immediate next element is missed 


================================================================================================
Recursion


11. // How to understand recursion, See image attached in recursion folder for quick reading of the same
https://www.youtube.com/watch?v=R7qja_gZrvI


12. Recursion tip:
// Everything before recursive call will execute when you go up in the recursion
// Everything after recursive call will execute wapas aate hue...

// Notice the difference between PrintDecreasing and than PrintIncreasing in Recursion folder


//While solving problem with recursion- we assume approach will work for n-1 and write the codes. Good Example
is in solution of Tower of Hanoi 
 https://www.youtube.com/watch?v=QDBrZFROuA0

Recursion works on the idea of faith that if algo will work for "n-1", than it will also work for "n"



13. Recursion can be solved using :
a) Faith and Expectation approach (Check "GetStairPaths" in 'RecursionWithArrayList' section)
b) Level and Options approach (Check "PrintStairPaths" in 'RecursionOnWayUp' section)

Both approaches are exaplianed briefly in PrintStairPaths solution video, link below
https://www.youtube.com/watch?v=NEuYcztalew



14. //For Hacker rank , 2D multiline inputs are taken as :

 Scanner scn = new Scanner(System.in);     

int n =Integer.parseInt( scn.nextLine());
int[][] a = new int[n][n];
for (int i = 0; i < n; i++) {            
    String str = scn.nextLine();
    String[] temp = str.split(" ");
    for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(temp[j]);

    }

}








   
