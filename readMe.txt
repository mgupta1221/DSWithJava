1. GettingStartedBasics
2. Recursion And Backtracking

Educative.io  for System Design
Gaurav Sen for HLD and System Design
Udit Agarwal (youtube) for LLD
Head First Book for Object Oriented Analysis and patterns


For LLD 
==============================================

Youtube playlist
1). Gaurav Sen playlist
2). Udit Agarwal LLD playlist
3). Soumyajit Bhattacharyay LLD playlist
4). The Code Mate LLD playlist - By Navneet Rabadiya
5). The Tech Granth – For Design Patterns. You can refer to his LLD and Design Patterns playlist from this channel.
6). Christopher Okhravi - For Design Patterns
7). Keerti Purswani (She/Her) – For Design Patterns & Mock LLD Interviews
8). SudoCODE – By Yogita Sharma
9). Distributed Sytems Guy - Bala G
10). Derek Banas

Some paid best resources for ones who are looking out for well-structured content of LLD :

1). Educative.io – Grokking the Object-Oriented Design Interview
2). InterviewReady – By Gaurav Sen 
3). GeeksforGeeks - Low-Level Design Course 
 
Best resources in form of Blogs :

1). Recommended “𝑳𝒐𝒘-𝑳𝒆𝒗𝒆𝒍 𝑫𝒆𝒔𝒊𝒈𝒏 𝑷𝒓𝒊𝒎𝒆𝒓” repository on GitHub
2). workat.tech website - By Gaurav Chandak
3). sourcemaking[dot]com/design_patterns
4). refactoring[dot]guru/design-patterns
5). System Design articles on LeetCode[dot]com
 


For HLD
==============================================
Books :

1). Designing Data-Intensive Applications – This book is the Bible of System Design.
2). Grokking the System Design pdf – By Educative.io
Use https://lnkd.in/gy-uGDN7 to get 10% discount or use https://lnkd.in/dQtAV45A for my 𝐀𝐟𝐟𝐢𝐥𝐢𝐚𝐭𝐞 𝐥𝐢𝐧𝐤𝐬
3). Web Scalability for Startup Engineers – By Artur Ejsmont
4). System Design Interview Part I and II – By Alex Xu

Some of the YouTube channels which helped me immensely in my System Design preparation :

1). Gaurav Sen playlist
2). TechDummies - By Narendra L
3). SudoCODE - By Yogita Sharma
4). System Design Interview
5). The Tech Granth
6). codeKarle - By Sandeep Kaul

Some of the best paid System Design courses which you can use if you're looking out for well-structured content for System Design :

1). InterviewReady - By Gaurav Sen (Use coupon code “𝐁𝐀𝐑𝐍𝐖𝐀𝐋” for 20% additional discount)
2). Educative.io - Use https://lnkd.in/gy-uGDN7 to get 10% discount or use https://lnkd.in/dQtAV45A for my 𝐀𝐟𝐟𝐢𝐥𝐢𝐚𝐭𝐞 𝐥𝐢𝐧𝐤𝐬
3). AlgoExpert - By Clement Mihailescu

Some of the best resources available for free on the Internet in form of blogs :

1). Recommended “System Design Primer” repository on GitHub
https://github.com/prasadgujar/low-level-design-primer

2). highscalability[dot]com
3). systeminterview[dot]com
4). workat.tech website
5). GeeksForGeeks - (Use coupon code “𝐁𝐀𝐑𝐍𝐖𝐀𝐋” for 10% additional discount for any course)

Some well-curated engineering blogs of the below companies for System Design that helped me immensely in giving a boost to my preparation :

1). Uber
2). Facebook
3). Stripe
4). Snapchat, and a lot more…..=
https://workat.tech/system-design/article/best-engineering-blogs-articles-videos-system-design-tvwa05b8bzzr

SystemDesign.org  - link below
https://docs.google.com/document/d/1pOarvQbjzLd9tz5ZuxktyrYsZ41mbWba5_LUeFj65lI/edit

System deisng on Leetcode - 
https://leetcode.com/discuss/interview-question/system-design?currentPage=1&orderBy=hot&query=



Top 75 questions
// https://leetcode.com/list/xi4ci4ig/


Youtube Learnbay.io
System Design
https://www.youtube.com/watch?v=cacrMJkq-LY&list=PLAs_8ZdWQs0kdWVstOpzByNCkzNHigQl-

Low level
https://www.youtube.com/watch?v=ADtnMlP0ztg&list=PLAs_8ZdWQs0n_1yAA4_4x8EC8W7t_vSVB

High level
https://www.youtube.com/watch?v=TYO849M8Q5U&list=PLAs_8ZdWQs0kplOtwqU_fMO2InH0bd-Fe


Student Notes

https://github.com/alok722/pepcoding-dsa-java
https://github.com/tamanna-verma/DSA_Notes


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


6. Remember the following outputs, so use wisely what to use when:

char a = '3';
System.out.println((int)a); //51    - when typecasting

char a = '3';
System.out.println(a-'0');  //3     - if want to convert char to equivalent number, use this

7. How to convert '6' to 6

 char c = '6';
 System.out.println((char) (c - '0'));  
 
 //this works becuase ascii of '6' is 54 and of '0' (0 gets typecast to '0' automatically here) 
 //is 48, so the differnece is 6

 //ASCII code of '0' is 48

 7.  //Getting alphabet from number(number is in String format)
        
    int charVal = ch - '0'; /// converting character to number
    char code = (char) ('a' + charVal - 1); // notice we are typecasting and adding as well



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

For more details on "Faith and Expectation" and "Levels and Options" approach,
see readMe file of IntroToRecursion




14. Check PrintPermutations in Recursion -> RecursionOnWayUp



15. //For Hacker rank , 2D multiline inputs are taken as :

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








   
