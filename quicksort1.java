public class quicksort1 {
    public static void quickSort(int array[],int left,int right){
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
        quickSort(array, left, i-1);
        quickSort(array, i+1, right);
        
    }
    public static void sort(int []array){

        int len=array.length;
        quickSort(array, 0, len-1);

    }
    public static void print(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(" ");
        
    }
    public static void main(String [] args){
        int []arr={1,5,3,6,2};
        print(arr);
        sort(arr);
        print(arr);
    }
    
}
