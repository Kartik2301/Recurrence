class Solution {
    public int compareVersion(String version1, String version2) {
        
        String [] ver1 = version1.split("[.]");
        String [] ver2 = version2.split("[.]");
        int i;
        for(i=0;i<Math.max(ver1.length,ver2.length);i++) {
            int a = 0;
            int b = 0;
            if(i < ver1.length) {
                a = Integer.parseInt(ver1[i]);
            }
            if(i < ver2.length) {
                b = Integer.parseInt(ver2[i]);
            }
            if(a > b) return 1;
            if(a < b) return -1;
        }
        return 0;
    }
}

Time complexity :- O(max(len(version1), len(version2)))
Space complexity :- O(n)