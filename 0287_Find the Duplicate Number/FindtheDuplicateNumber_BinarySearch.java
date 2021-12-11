﻿class Solution {
    
    public int findDuplicate(int[] nums) {      
        int l = 1, r = nums.length - 1;
        
        while (l <= r) {
            int mid = (l + r) / 2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid)
                    count++;
            }
            
            // Normally, if there is no duplicate before mid, the count should be equals to mid
            // if count > mid, means there is duplicate before mid, should continue to search [l, mid-1]
            if (count > mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}