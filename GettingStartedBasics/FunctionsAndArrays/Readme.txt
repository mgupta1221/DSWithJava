Functions And Arrays

1) Decimal Number system: (0-9, 10-19...)  Base is 10

    0   10   20 - - -- - 100
    1   11   21          101 
    2   12   22          102
    3   13   23          103
    4   14   24
    5
    6
    7
    8
    9   19   29- - - 99  109

    [9563] base10   =  9*10^3 + 5*10^2 + 6*10^1 + 3*10^0 

2) Binary  (0 - 1)  - base is 2

0   10  100 1000
1   11  101 1001 
        110 1010
        111 1011
            1100
            1101
            1110
            1111

110 base 2 = 1*2^2  + 1*2^1  +  0*2^0 

3) Octal (0-7)  - Base 8

0   10 ----- 70  100
1   11           101
2   12
3   13
4   14
5   15
6   16
7   17       77  107

563 =  5*8^2  + 6*8^1 + 3*8^0


Note: See images to understand How to convert Number from One Base to other. 

There are 3 possible scenarios only:

1) Converting from any base to base 10 (Decimal) - (https://www.youtube.com/watch?v=lOsmPMihcTM&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=80)
2) Converting from Base 10 to any base  (https://www.youtube.com/watch?v=F0aTGc2vS5s&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=82)
3) Converting from any base to any base - IMP: For this case- convert the number first to base 10 
equivalent (using method1) and than convert the number to any required base(using method 2). 


Converting any Decimal number(Base 10) to Any base:

1) Keep divding the number with target base(say Base 2) till it reaches 0
2) On each division , keep calculating the remainder
3) Multiple each remainder with 10^n (means  10^0, 10^1, 10^2....10^n )   - we use 10 becuase it is the source base
4) Add all values of step 3 to get the result.




Converting Any base to Decimal number(Base 10):

1) Keep divding the number by 10 (target base) till it reaches 0
2) On each division , keep calculating the remainder
3) Multiple each remainder with sourcebase^n (means  2^0, 2^1, 2^2....2^n )   - we use 2, assuming sourceBase is 2
4) Add all values of step 3 to get the result.


- Imp: Check about logic of Additions and Multiplication in Any base
https://www.youtube.com/watch?v=YVpTjZRShqo&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=86

Solution for Addition and Multiplication is in one file

- Remember, in case of multiplication - addition done is not normal Base 10 addition, it will be 
respective base's addition




Important quesitons in this folder
SubSetsOfArray
BinarySearchUseCases







