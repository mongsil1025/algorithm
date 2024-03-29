package algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        List<List<Integer>> answer = permute(new int[] {1, 2, 3});
        System.out.println(answer.toString());
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
     }
     
     private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
           list.add(new ArrayList<>(tempList));
        } else{
           for(int i = 0; i < nums.length; i++){ 
              if(tempList.contains(nums[i])) continue; // element already exists, skip
              tempList.add(nums[i]);
              backtrack(list, tempList, nums);
              tempList.remove(tempList.size() - 1);
           }
        }
     } 
}
