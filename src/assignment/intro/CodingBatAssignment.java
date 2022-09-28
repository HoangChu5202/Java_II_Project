package assignment.intro;

import java.util.*;

public class CodingBatAssignment {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll( list,7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9);
        sortAndRemoveDuplicates(list);
        System.out.println(list);
    }

    public static ArrayList<Integer> sortAndRemoveDuplicates(ArrayList<Integer> nums) {
        Set<Integer> convertSet = new HashSet<>(nums);
        nums = new ArrayList<>(convertSet);
        Collections.sort(nums);
        return nums;
    }
}
