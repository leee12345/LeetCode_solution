public class MergeSort {
    public static void main(String[] args){
        int[] array={12,11,13,5,6,7};
        System.out.println("原始数组: ");
        printArray(array);

        mergeSort(array,0,array.length-1);
        System.out.println("排序后的数组： ");
        printArray(array);
    }
   public static void mergeSort(int[]array, int left, int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(array, left, mid);
            mergeSort(array,mid+1,right);
            merge(array,left,mid,right);
        }
   }

   public static void merge(int[]array,int left,int mid, int right){
        int[] temp= new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=right){
            if(array[i]<=array[j]){
                temp[k++]=array[i++];
            }else{
                temp[k++]=array[j++];
            }
        }
        while(i<=mid){
            temp[k++]=array[i++];
        }
        while(j<=right){
            temp[k++]=array[j++];
        }
        for(int l=0;i<temp.length;l++){
            array[left+l]=temp[l];
        }
   }



    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
