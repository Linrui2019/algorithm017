**小作业：  写一个关于 HashMap 的小总结。**



# 242. 有效的字母异位词

**==Tags:  hash-table 、 sort==**

- **切题四件套**

  - **clarification**   和面试官讨论并确认题目的要求
  - **possible solution  --> optimal (time & space)**     思考所有可能的解法，并从中找出最优的那个解
  - **code**      编码
  - **test cases**    测试

  

**思路：**

1. **暴力解法** ：    排序        对两个字符串进行排序，判断是否相等， **时间复杂度 O(nlogn)  空间复杂度 O(1)** 

 	2. **hash-table**:   计算两个字符串中每个字母的出现次数并进行比较

```java
// 时间复杂度 O(n)
// 空间复杂度 O(1)

class Solution {
    public boolean isAnagram(String s, String t) {
        // 首先对其合法性进行判断，如果两个字符串长度不等，立刻返回false
        if (s.length()!=t.length()) {
            return false;  
        }
        int[] alphabet=new int[26];  // 26个字母的计数器
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i)-'a']++;   // 统计s中字母出现的次数 +1
            alphabet[t.charAt(i)-'a']--;   // 统计t中字母出现的次数 并-1
        }
        for (int i : alphabet) {  // 检查每个字母对应的计数器是否为0
            if (i!=0) {
                return false;
            }
        }
        return true;
    }
}
```





# 49. 字母异位词分组

**思路：**

​	（1） **暴力解法**：     先排序   再判断。当且仅当它们的排序字符串相等时，两个字符串是字母异位词。

​	（2） **hash-table :**     统计每个字母出现的个数

参考链接：https://leetcode-cn.com/problems/group-anagrams/solution/liang-chong-fang-shi-jie-jue-by-sdwwld/

```java
// 时间复杂度 O(nk)  n:为字符串的个数  k: 最大字符串长度
// 空间复杂度 O(nk)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 边界条件检查
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String,List<String>> map=new HashMap<>();
        for (String s : strs) {
            char[] alphabet=new char[26];// 统计字母的次数
            for (char c : s.toCharArray()) {
                alphabet[c-'a']++;  // 将对应索引的值+1
            }
            String keyStr=String.valueOf(alphabet); // 将char[]转换成String
            if (!map.containsKey(keyStr)) {    // 判断map中是否包含该key
                map.put(keyStr, new ArrayList<>());  // 不包含则 加入map中
            }
            map.get(keyStr).add(s);   // 否则，将该字符串加入 ArrayList中
        }
        return new ArrayList<>(map.values());  // 输出map的值
    }
}
```









# 1. 两数之和

==**Tags:     array 、 hash-table**==



**思路：**

​		（1）. **暴力解法**          两个for loop       **时间复杂度 O(n2)**      **空间复杂度 O(1)**

​		（2）   **哈希表**			使用hashtable 记录数组的值和索引（key=数组值；value=索引）。  先对数组进行遍历，查找hashtable中是											否含有target-x 这个key,如果有。则返回当前索引和hashtable中对应key的值（即数组索引）。若没有，将其

​											值和对应的索引加入hashtable. 最后返回对应的索引。

​	**参考解析：**

 https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/			

https://leetcode.com/problems/two-sum/discuss/3/Accepted-Java-O(n)-Solution					

```java
// 时间复杂度 O(n)
// 空间复杂度 O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();  // 所有的集合中都不能存储基本类型的数据！！！
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){   
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[0];

    }
}
```



