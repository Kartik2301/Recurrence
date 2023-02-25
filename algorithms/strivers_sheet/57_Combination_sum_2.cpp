Solution 1 :- Backtracking

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, target, candidates, new ArrayList<>(),0);
        return list;
    }
    public void backtrack(List<List<Integer>> list, int target, int [] candidates, List<Integer> tempList, int start) {
        if(target == 0) {
            list.add(new ArrayList<>(tempList));
        } else if(target < 0) {
            return;
        } else {
            for(int i=start;i<candidates.length;i++) {
                if(i > start && candidates[i] == candidates[i-1]) continue;
                tempList.add(candidates[i]);
                backtrack(list,target-candidates[i],candidates,tempList,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}

Time complexity is O(2^n). Space complexity O(n). Basically, for each num you have two choices, pick it or not.
It should actually be O(n * 2 ^ N). The array copy operation in most languages is linear. Afaik, this is O(n): list.add(new ArrayList<>(tempList))
