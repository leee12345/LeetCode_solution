import java.util.*;

public class QuickSort{

    public static void quicksort(int[] array,int left, int right){
        if(left>=right) return;
        int i=left,j=right;
        int index=array[i];
        while(i<j){
            while(i<j&&array[j]>=index){
                j--;
            }
            if(i<j){
                array[i++]=array[j];
            }
            while(i<j&&array[i]<index){
                i++;
            }
            if(i<j){
                array[j--]=array[i];
            }
        }
        array[i]=index;
        quicksort(array, left, i-1);
        quicksort(array, i+1, right);
    }
    
    public static void quickSort(int[] array){
        if(array==null||array.length==0) return;
        quicksort(array, 0, array.length-1);
    }




    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入数组长度");
        int n=Integer.parseInt(sc.nextLine());
        System.out.println("请输入数组元素");
        String string=sc.nextLine();
        String[] strs=string.split(",");
        int[] list= new int[n];
        for(int i=0;i<strs.length;i++)
        {
            list[i]=Integer.parseInt(strs[i]);
        }
        System.out.println("排序前");
        print(list);
        quickSort(list);
        System.out.println("排序后");
        print(list);
        return;

    }
    private static void print(int[]list){
        for(int i=0;i<list.length;i++)
        {
            System.out.println(list[i]);
        }
    }

}