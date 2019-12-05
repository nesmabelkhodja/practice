class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        
        for (int i = 0; i<nums.length; i++){
            int test = target - nums[i];
            if (map.containsKey(test) && map.get(test) !=i){
                return new int[] {i, map.get(test)};
            }
        }
        return new int[] {-1};
    }
}