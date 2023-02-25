Solution 1 :- Backtracking

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    public void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] candidates, int target, int index) {
        if(target == 0) {
            list.add(new ArrayList<>(tempList));
        } else if(target < 0) {
            return;
        } else {
            for(int i=index;i<candidates.length;i++) {
                tempList.add(candidates[i]);
                backtrack(list,tempList,candidates,target-candidates[i],i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}

Time complexity is O(2^n). Space complexity O(n). Basically, for each num you have two choices, pick it or not.
It should actually be O(n * 2 ^ N). The array copy operation in most languages is linear. Afaik, this is O(n): list.add(new ArrayList<>(tempList))