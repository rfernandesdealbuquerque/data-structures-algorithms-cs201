import java.util.*;

public class NoDupesSorted {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array

    public int removeDuplicatesSorted(int[] nums) {
        int lastIndex = 0;
        for(int k=1; k < nums.length; k++) {
            if (nums[lastIndex] < nums[k]) {
                lastIndex += 1;
                nums[lastIndex] = nums[k];
            }
        }
        return lastIndex + 1;
    }

    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int lastIndex = 0;
        set.add(nums[0]);
        for(int k=1; k < nums.length; k++) {
            if (! set.contains(nums[k])) {
                lastIndex += 1;
                nums[lastIndex] = nums[k];
                set.add(nums[k]);
            }
        }
        return lastIndex;
    }
}
