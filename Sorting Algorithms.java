import java.util.Arrays;
import java.util.Random;
import java.io.*;
import java.util.*;

public class A1PatelHirenkumar {
    public static void main(String[] args)
    {
        testMethod();
        System.out.println("\nHURRAY!! PROGRAM ENDED SUCCESSFULLY \n\nPROGRAMMED BY PATEL HIRENKUMAR JAYESHKUMAR" );
    }
    private static final int BREAKPOINT=50; //global variable that helps in hybridQuickSort
    private static final int NUM_OF_TESTS=100; /*VARIABLES USED IN TEST METHOD*/
    private static final int ARRAY_SIZE=10000;
    private static final int NUM_OF_SWAPS=2500;

    public static void insertionSort(int[] nums) {  //driver method that is only passed the array to be sorted

        insertionSort(nums, 0, nums.length);//helper method hides extra info from the user
        String algorithm="Insertion Sort";
        checkSorted(nums,algorithm);
    }//end insertionSort

    private static void insertionSort(int[] nums, int start, int end) {  //helper method
        //sorts array values from start to end(start/end are indices)
        int i, j, key, temp;
        for (i = start; i < end; i++)//outer loop helps capture the each value in the array
        {
            key = nums[i];
            j = i-1;
            while (j >= start && key < nums[j]){
                //inner loops compares value from outer loop with every value
                // before it looking for a value greater than it
                temp = nums[j];
                nums[j] = nums[j + 1]; //swapping takes place if a greater value is found
                nums[j + 1] = temp;
                j--;
            }
        }//end for
    }//end insertionSort

    public static void mergeSort(int nums[]) {   //driver method
        int[] temp = new int[nums.length];//array to temporarily store elements
                                          //as they are sorted being sorted
        mergeSort(nums, 0, nums.length, temp);
        String alogrithm="Merge Sort";
        checkSorted(nums,alogrithm);
    }//end mergeSort

    private static void merge(int[] nums, int start, int mid, int end) {  //merging two sorted halves
        int leftIndex = start; //index to keep track of elements in the left half
        int rightIndex = mid;  //index to keep track of elements in the right half
        int currIndex;       //index to copy elements to temp array in sorted order

        for (currIndex = start; currIndex < end; currIndex++) //currIndex is index in the temp array
        {
            if ((leftIndex < mid) && ((rightIndex >= end) || nums[leftIndex] < nums[rightIndex]))
            {   //if element in left half is smaller than element in
                //the right half or there are no more elements in the
                //right half then it is copied to temp array
                temp[currIndex] = nums[leftIndex];
                leftIndex++;
            } else {
                temp[currIndex] = nums[rightIndex];
                rightIndex++;
            }
        }
        for (currIndex = start; currIndex < end; currIndex++) {  //copies all remaining elements to temp array
            nums[currIndex] = temp[currIndex];
        }
    }//end merge

    private static void mergeSort(int[] nums, int start, int end)
    {   //recursive merge sort that divided lists into halves up to
        //when each of the halves have 2 elements, sorts all the halves and the merges them

        int midIndex;//holds the middle index of each half

        if (2 > end - start) { //base case-if the halves can no longer be divided into two
            return;
        } else {
            midIndex = start + (end - start) / 2;    //middle index calculated for each half
            mergeSort(nums, start, midIndex); //recursive merge sort
            mergeSort(nums, midIndex, end);
            merge(nums, start, midIndex, end); //merges all sorted halves and the list is sorted!
        }
    }//end mergeSort

    public static void quickSort(int [] nums)
    {//driver method
        quickSort(nums,0,nums.length-1);
        String algorithm="Quick Sort";
        checkSorted(nums,algorithm);
    }//end quickSort

    private static void quickSort(int[] nums,int start,int end)
    {//helper method
        if(start>=end)
        {//base case
            return;
        }
        else
            {//recursive part
                int partitionIndex=partition(nums,start,end);  //divides list into two, one smaller than the pivot
                                                              //and the other greater than the pivot then, returns
                                                             //the pivot position(which separates both the lists)
                quickSort(nums,start,partitionIndex-1); //recursive method calls
                quickSort(nums,partitionIndex+1, end);

            }
    }//end quickSort

    private static int choosePivot(int[] nums, int min, int max)
    { //choosing pivot using median of three method
        int pivotIndex=min;
        if(max-min>2){
        int midIndex=min+(max-min)/2;//identifies the value in the middle of the list passed on
        //conditions
        if(((nums[min]>=nums[midIndex])&&(nums[min]<=nums[max]))||((nums[min]>=nums[max])&&(nums[min]<=nums[midIndex])))
        {
            pivotIndex=min;
        }
        else if(((nums[max]>=nums[midIndex])&&(nums[max]<=nums[min]))||((nums[max]>=nums[min]&&nums[max]<=nums[midIndex])))
        {
            pivotIndex=max;
        }
        else
            {
            pivotIndex=midIndex;
        }}
        return pivotIndex;//pivot is selected and its index is passed on
    }//end choosePivot

    private static void swap(int[]nums,int i,int j)
    { //swapping two values in an array
        int temp=nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
    }//end swap

    private static int partition(int[]nums,int start,int end)
    {
        swap(nums,choosePivot(nums,start,end),end);//sets the pivot at end position in the array passed
        int pIndex=start;//all elements before this index are smaller than the pivot

        for(int i=start; i<end; i++)
        { //looping through the array
            if(nums[i]<=nums[end]) //swap takes place if any value is <= pivot
            {
                swap(nums,i,pIndex);
                pIndex++;
            }
        }//end for
        swap(nums,pIndex,end);//pivot is placed just before all the values greater than it start
        return pIndex;//pivot index is returned
    }//end partition

    public static void hybridQuickSort(int nums[])
    { //if there are BREAKPOINT or greater elements in an array, use hybridQuickSort else use Insertion sort
        String algorithm;
         if (nums.length<BREAKPOINT)
        {
            insertionSort(nums);
            algorithm="Insertion Sort in Hybrid Quick Sort";
        }
        else{
            hybridQuickSort(nums,0,nums.length-1);
            algorithm="Hybrid Quick Sort";}
        checkSorted(nums,algorithm);
    }//end hybridQuickSort

    private static void hybridQuickSort(int[]nums,int start,int end) { //functions same as quickSort
        if (end-start<BREAKPOINT ) {
            insertionSort(nums,start,end+1);
        } else {
            int partitionIndex = partition(nums, start, end);
            hybridQuickSort(nums, start, partitionIndex -1);
            hybridQuickSort(nums, partitionIndex +1, end);
        }
    }//end hybridQuickSort

    public static void checkSorted(int[]nums,String algorithm)
    {
        boolean result=true;//flag that signals not to go into the for loop once we find an
                           // element is greater than an element after it
        for(int i=0; i<nums.length-1&&result; i++)
        {
          if(nums[i+1]<nums[i])
          {
              result=false;
              System.out.println("ERROR!!! Array is not sorted!"+ "\n"+algorithm+" "+"was used");
          }
        }//end for
    }//end checkSorted

    public static void fillRandomArray(int[]nums,int n)
    { //randomly fills array and performs n swaps within the array
        Random numberGenerator=new Random();
        for(int i=0; i<nums.length; i++)
        {
            {
            nums[i] = i;
            }
        }//array is filled

        while(n>0)
        {
            swap(nums,numberGenerator.nextInt(nums.length),numberGenerator.nextInt(nums.length));
            n--;
        }//n swaps are done
    }//end fillRandomArray

    public static void testMethod()
    {
        long start, stop, elapsedTime;  // variables recording how long it take to compute an algorithm

        long[] insertionSortTimings= new long[NUM_OF_TESTS];
        long[] mergeSortTimings=new long[NUM_OF_TESTS];
        long[] quickSortTimings=new long[NUM_OF_TESTS];
        long[] hybridQuickSortTimings=new long[NUM_OF_TESTS];
        int[] testArray=new int[ARRAY_SIZE];


        for(int i=0; i<NUM_OF_TESTS; i++)
        {
            fillRandomArray(testArray, NUM_OF_SWAPS);
            start = System.nanoTime();
            insertionSort(testArray);
            stop = System.nanoTime();
            elapsedTime = stop - start;
            insertionSortTimings[i] = elapsedTime;
        }
        for(int i=0; i<NUM_OF_TESTS; i++)
        {
            fillRandomArray(testArray,NUM_OF_SWAPS);
            start = System.nanoTime();
            mergeSort(testArray);
            stop = System.nanoTime();
            elapsedTime = stop - start;
            mergeSortTimings[i]=elapsedTime;
        }
        for(int i=0; i<NUM_OF_TESTS; i++)
        {
            fillRandomArray(testArray,NUM_OF_SWAPS);
            start = System.nanoTime();
            quickSort(testArray);
            stop = System.nanoTime();
            elapsedTime = stop - start;
            quickSortTimings[i]=elapsedTime;
        }
        for(int i=0; i<NUM_OF_TESTS; i++)
        {
            fillRandomArray(testArray,NUM_OF_SWAPS);
            start = System.nanoTime();
            hybridQuickSort(testArray);
            stop = System.nanoTime();
            elapsedTime = stop - start;
            hybridQuickSortTimings[i]=elapsedTime;
        }
        System.out.println("Insertion Sort Statistics  \n______________________________________");
        double insertionSortMean=Stats.mean(insertionSortTimings);
        double insertionSortStdDev=Stats.standardDeviation(insertionSortTimings);
        System.out.println("Insertion Sort Timings Mean is "+insertionSortMean + "\nInsertion Sort StdDev is "+insertionSortStdDev);

        System.out.println("\nMerge Sort Statistics  \n______________________________________");
        double mergeSortMean=Stats.mean(mergeSortTimings);
        double mergeSortStdDev=Stats.standardDeviation(mergeSortTimings);
        System.out.println("Merge Sort Timings Mean is "+mergeSortMean + "\nMerge Sort StdDev is "+mergeSortStdDev);

        System.out.println("\nQuick Sort Statistics  \n_______________________________________");
        double quickSortMean=Stats.mean(quickSortTimings);
        double quickSortStdDev=Stats.standardDeviation(quickSortTimings);
        System.out.println("Quick Sort Timings Mean is "+quickSortMean + "\nQuick Sort StdDev is "+quickSortStdDev);

        System.out.println("\nHybrid Quick Sort Statistics \n_______________________________________");
        double hybridQuickSortMean=Stats.mean(hybridQuickSortTimings);
        double hybridQuickSortStdDev=Stats.standardDeviation(hybridQuickSortTimings);
        System.out.println("Hybrid Quick Sort Timings Mean is "+hybridQuickSortMean + "\nHybrid Quick Sort StdDev is "+ hybridQuickSortStdDev);

        System.out.println("\n\nThe zStat between Insertion Sort and Quick Sort is "+Stats.zTest(insertionSortTimings,quickSortTimings));
        System.out.println("The zStat between Insertion Sort and Merge Sort is "+Stats.zTest(insertionSortTimings,mergeSortTimings));
        System.out.println("The zStat between Insertion Sort and Hybrid Quick Sort is "+Stats.zTest(insertionSortTimings,hybridQuickSortTimings));

        System.out.println("\n\nThe zStat between Merge Sort and Insertion Sort is "+Stats.zTest(mergeSortTimings,insertionSortTimings));
        System.out.println("The zStat between Merge Sort and Quick Sort is "+Stats.zTest(mergeSortTimings,quickSortTimings));
        System.out.println("The zStat between Merge Sort and Hybrid Quick Sort is "+Stats.zTest(mergeSortTimings,hybridQuickSortTimings));

        System.out.println("\n\nThe zStat between Quick Sort and Insertion Sort is "+Stats.zTest(quickSortTimings,insertionSortTimings));
        System.out.println("The zStat between Quick Sort and Merge Sort is "+Stats.zTest(quickSortTimings,mergeSortTimings));
        System.out.println("The zStat between Quick Sort and Hybrid Quick Sort is "+Stats.zTest(quickSortTimings,hybridQuickSortTimings));

        System.out.println("\n\nThe zStat between Hybrid Quick Sort and Insertion Sort is "+Stats.zTest(hybridQuickSortTimings,insertionSortTimings));
        System.out.println("The zStat between Hybrid Quick Sort and Merge Sort is "+Stats.zTest(hybridQuickSortTimings,mergeSortTimings));
        System.out.println("The zStat between Hybrid Quick Sort and Quick Sort is "+Stats.zTest(hybridQuickSortTimings,quickSortTimings));
    }
}
class Stats {
    /*
     * Creates a mean based from a passed array
     */
    public static double mean(long data[]) {
        double sum = 0;
        for (int i = 0; i < data.length; i++)
            sum += data[i];
        return sum / (double)data.length;
    }

    /*
     * Creates a standard deviation from a passed array
     */
    public static double standardDeviation(long data[]) {
        double mean = mean(data);

        double summation = 0;
        for (int i = 0; i < data.length; i++) {
            summation += Math.pow(data[i] - mean, 2);
        }
        return Math.sqrt(1/(double)data.length * summation);
    }

    /*
     * Return a z-statistic, difference, reported in standard deviations
     */
    public static double zTest(long left[], long right[]) {
        return (mean(left) - mean(right))/
                Math.sqrt(Math.pow(standardDeviation(left),2) + Math.pow(standardDeviation(right),2));
    }
}




