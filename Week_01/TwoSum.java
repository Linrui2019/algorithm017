import com.sun.xml.internal.bind.v2.TODO;

/**
 * Description: 两数之和
 * Author:   Larry
 * Date:     2020/9/27 20:17
 */

public class TwoSum {


    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] indexs=twoSum01(nums,target);
        printArray(indexs);

    }

    //【法1】暴力法，遍历每个元素x,并查找是否存在一个值与target-x相等的目标元素
    //时间复杂度 O(n2)   空间复杂度O(1)
    static  int[] twoSum01(int[] nums,int target){

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    //【方法2】哈希表解法
    // TODO: 2020/9/27


    //数组遍历
    static  void printArray(int[] array){
        for (int i:array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }


}
