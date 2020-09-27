/**
 * Description: 移动零 LeetCode-283-简单
 * Author:   Larry
 * Date:     2020/9/27 14:19
 */

public class MoveZero {

    public static void main(String[] args) {
        //测试
        int[] nums={0,1,0,3,12};
        System.out.println("移动之前：");
        printArray(nums);

        moveZeroes(nums);
        System.out.println("移动之后：");
        printArray(nums);

    }
    /*
    给定一个数组 nums，将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     */
    static void moveZeroes(int[] nums){
        //【1】先判断合法性
        if(nums==null){
            return;
        }
        int j=0;
        for (int i=0;i< nums.length;i++){
            if (nums[i]!=0){
                int temp= nums[i];
                nums[i]=nums[j];
                nums[j++]=temp;
            }
        }
    }

    //数组遍历
    static  void printArray(int[] array){
        for (int i:array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }


}
