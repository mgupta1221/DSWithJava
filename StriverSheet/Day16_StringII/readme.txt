1) Get ASCII of a chacrter in JAVA

Ans: just typecast to 'int'

int asciValue= (int)'a'; 

int asciValue= (int)'=';

See 'Valid Anagrams' question.

2)  Very important: HashMap cannot be iterated over index like Strings and Arrays
    Below is the way to iterate through HashMap via keySet.

    Used in 'Valid Anagaram' problem - Approach 3
   
    Set<Character> keys = map.keySet();
    for (Character key : keys) {
        if (map.get(key) != 0) {
            return false;
        }
    }

    3) Convert String to Integer, and Integer to String

    // Integer to String
    int num=10;
    String str= Integer.toString(num);

    String str= "101";
    int num= Integer.parseInt(str);