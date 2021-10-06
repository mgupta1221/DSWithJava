Educative.io  for System Design
Gaurav Sen for HLD and System Design
Udit Agarwal (youtube) for LLD
Head First Book for Design patterns


Tips:
1. 2DArray Spiral display and Rotation concepts are used in DP problems

//NADOS Questions covered here
https://nados.pepcoding.com/content/0



Refer Readme files in individual folders here as well 


JAVA Tips
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



6. Replace a character in a string at specific index

Solution:
Convert the string to StringBuilder. StringBuilder has a function called setCharAt(). See below:

  String str = "IamGood";
  StringBuilder sbr = new StringBuilder(str);

   sbr.setCharAt(2, 'p');  //2 is the index and 'p' is the chracter which will be placed instead of 'm'(index 2)

7. How to declare ArrayList 

ArrayList<Integer> arr= new ArrayList<>();

8. Get the length of ArrayList
arr.size()

9. Get the value at index if
arr.get(i)

10. Remove element from ArrayList
arr.remove(i)

//Whenever removal from ArrayList is required, always iterate the arraylist from right. This is becuase on removal, index
//of all elements to the right reduces by 1 so immediate next element is missed 








   
