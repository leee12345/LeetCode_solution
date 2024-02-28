public class NewClass{
   
    public static int findK(int[] nums,int k){
        int n=nums.length;
        int l=0,r=n-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]==k){
                return mid;
            }else if(nums[mid]<k){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
    public static void main(String[] args){
        int[]nums={1,2,2,3,3,3,4,4,5};
        int k=3;
        System.out.println(findK(nums,k));
    }
    //如果取后一个3 如何改进
    public static int findLastK(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2; // Ensure mid biases towards right
            if (nums[mid] == k) {
                l = mid; // Update left boundary to search right part
            } else if (nums[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] == k ? l : -1; // Return -1 if not found
    }
    

    //1g 3g 9g 27g 一个天平 能称出来多重的东西
    //get post方法区别
    //为何post方法实现数据的安全性还需要HTTPS
    //HTTP和HTTPS区别
    //HTTPS加密 非对称加密的实现方式 如何实现非对称加密
    //反爬虫IP池的实现 Session如何设置用户名和密码登录
    //事务操作：同时有多少个进程，如何设置
    //INNODB的隔离级别 默认隔离级别是Repeatable Read
    //现在用的java版本 和别的java版本有什么区别
    //HASHMAP底层实现 HASHMAP put(key,value)方法实现过程
    //mysql走索引的语句
    //where a=1 AND b=1 AND c=1 走不走索引？where a=1 AND b=1 AND c>1 走不走索引？哪一部分走索引？where a=1 AND b=1 AND c！=1 走不走索引？哪一部分走索引？
    //
}