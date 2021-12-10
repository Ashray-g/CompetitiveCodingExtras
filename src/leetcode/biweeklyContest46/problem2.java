package leetcode.biweeklyContest46;

import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] groups = {{1, -1, -1},{3, -2, 0}};
        int[] nums = {1,-1,0,1,-1,-1,3,-2,0};
        int curG = 0;
        int curL = 0;
        int target = groups.length;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == groups[curG][curL]){
                if(curL < groups[curG].length-1) curL++;
                else{
                    curL = 0;
                    curG++;
                }
            }else{
                i-=curL;
                curL = 0;
            }
            if(curG == target) break;
            System.out.println(curG + " " + curL);
        }
        if(curG == target) System.out.println(true);
    }
}
