**思考题：**

（1）树的面试题解法一般都是递归的，为什么？

​	因为树本身不是一个线性结构，不适合进行迭代操作，而树的左子树和右子树可以看成是更小规模的树，与递归中子问题的概念相同。



# java中的Collection框架

**方法论1**：从官网查看对应版本的java 文档：以下是java  se 8 documentation



![image-20201010214638659](images/image-20201010214638659.png)

**==点击 java的概念图 可以学习对应的官方文档。==**



**以下是java中的核心框架接口：**

![image-20201010214443662](images/image-20201010214443662.png)















# Map接口

map接口中定义的接口方法：

```java 
int size();  // map中键值对的个数

boolean isEmpty();  // 判断map是否为空  为空 返回true

boolean containsKey(Object key);   //  判断map中是否包含某个key

boolean containsValue(Object value); // 判断map中是否包含某个value

V get(Object key);  // 通过key获取map中对应的value

V put(K key, V value);   // 【增】加入键值对 （将指定的键和值相关联）

V remove(Object key);   // 【删】 通过key 删除指定的键值对

boolean remove(Object key, Object value)   // 【删】 通过key-value 删除一个map元素
    
default V replace(K key, V value)   // 【改】 修改key对应的value

default boolean replace(K key, V oldValue, V newValue) // 【改】
    
void clear();   // 清空map

Set<K> keySet();  // 返回所有键的集合   （因为key是唯一的，返回值类型set集合中的元素也是唯一的）

Collection<V> values(); // 返回所有的value 的集合   因为value可以不唯一，返回值类型为Collection

Set<Map.Entry<K, V>> entrySet();  // 获取所有的 实体（key-value）集合
```





# HashMap源码分析及总结

参考：https://tech.meituan.com/2016/06/24/java-hashmap.html

**类的继承层次**

![image-20201009203839378](images/image-20201009203839378.png)



- 当且仅当hashCode一致，且equals比对一致的对象，才会被Hashmap认为是同一个对象。

- 在java8 和java8之前 的HashMap的实现是不一样的：

  - java8 之前的HashMap的底层实现是 **数组+ 链表**
  - java8 的HashMap底层实现是  **数组 + 红黑树 + 链表**

- ``` java
  transient Entry<K,V>[] table;  // java8 之前的table数组类型
  transient Node<K,V>[] table;   // java8 中的table数组类型  
  // table的默认容量是16，加载因子是0.75
  ```

- java8 中，当链表深度达到建树阈值（7）时，会条用treeifyBin方法将整个链表重构成红黑树