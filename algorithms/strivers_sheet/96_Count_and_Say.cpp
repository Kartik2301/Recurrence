class Solution {
    public String countAndSay(int n) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("11");
        list.add("21");
        list.add("1211");
        int i;
        for(i=4;i<n;i++) {
            String temp = list.get(i-1);
            int j;
            char first = temp.charAt(0);
            int count = 1;
            String result = "";
            for(j=1;j<temp.length();j++) {
                if(temp.charAt(j) == first) {
                    count++;
                } else {
                    result += (String.valueOf(count) + first);
                    first = temp.charAt(j);
                    count = 1;
                }
            }
            result += (String.valueOf(count) + first);
            list.add(result);
        }
        return list.get(n-1);
    }
}

Time complexity :- O(n)
Space complexity :- O(n)