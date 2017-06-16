package com.science;

/**
 * Created by Amal on 5/4/2017.
 */
public class LeetCode {
    //Given an array of integers, every element appears twice except for one. Find that single one.
        public int singleNumber(int[] nums) {
            int targetnum=nums[0];
            for(int i=1;i<nums.length;i++)
            {
                targetnum^= nums[i];
            }
            return targetnum;
        }

        /*
        //Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        public int[] TwoSum(int[] nums, int target) {
            Dictionary<int,int> hashnums=new Dictionary<int,int>();
            int[] result=new int[2];
            for(int i=0;i<nums.Length;i++)
            {
                if(!hashnums.ContainsKey(nums[i]))
                {
                    if(!hashnums.ContainsKey(target-nums[i]))
                        hashnums.Add(target-nums[i],i);
                }
                else
                {
                    result[0]=hashnums[nums[i]];
                    result[1]=i;
                    return result;
                }
            }
            return result;
        }*/

}
