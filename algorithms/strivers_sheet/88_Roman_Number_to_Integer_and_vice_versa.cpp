Roman to Integer

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int i;
        int result = 0;
        for(i=0;i<s.length()-1;i++) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result + map.get(s.charAt(i));
    }
} 

Integer to Roman

class Solution {
    public String intToRoman(int num) {
        String [] words = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int [] value = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        int i;
        String res = "";
        for(i=words.length-1;i>=0;i--) {
            while(num >= value[i]) {
                num -= value[i];
                res += words[i];
            }
        }
        return res;
    }
}


Time complexity :- O(1)
Space comlexity :- O(1)