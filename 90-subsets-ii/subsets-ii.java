class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        findUniqueSubsets(nums, 0, new ArrayList<>());
        return res;
    }

    public void findUniqueSubsets(int[] nums, int index, List<Integer> sublist) {
        if (index == nums.length) {
           if(!res.contains(sublist)){
             res.add(new ArrayList<>(sublist));
           }
           return;
        }
        sublist.add(nums[index]);
        findUniqueSubsets(nums, index+1, sublist);
        sublist.remove(sublist.size() - 1);
        findUniqueSubsets(nums, index+1, sublist);

    }
}