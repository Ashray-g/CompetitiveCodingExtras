package leetcode;

public class CountSpecialQuadruplets {
    public static void main(String[] args) {

    }
    public int countQuadruplets(int[] nums) {
        int n =nums.length;
        int ans = 0;
        for(int a = 0;a<n-3;a++){
            for(int b = a+1;b<n-2;b++){
                for(int c = b+1;c<n-1;c++){
                    for(int d = c+1;d<n;d++){
                        if(nums[a] + nums[b] + nums[c] == nums[d]){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
