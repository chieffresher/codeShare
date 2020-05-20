import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;

class Codes {
    //works for most input but failed for [1,3] [2,4,5]
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        if(nums1.length>1 && nums2.length>1)
        sortedList = getSortedList(nums1,0,nums1.length-1,
                nums2,0,nums2.length-1);
        else if(nums1.length<=0 && nums2.length>0)
        {
            for(int i=0; i<nums2.length;i++)
                sortedList.add(nums2[i]);
        }
        else if(nums2.length<=0 && nums1.length>0) {
            for(int i=0; i<nums1.length;i++)
                sortedList.add(nums1[i]);
        }
        else if(nums1.length==1 && nums2.length>1)
            sortedList = insertOneIntoMany(nums1,nums2);

        else if(nums2.length==1 && nums1.length>1)
            sortedList = insertOneIntoMany(nums2,nums1);

        //debug
        int count = sortedList.size();
        for(int i=0; i<count; i++)
            System.out.print(sortedList.get(i));
        System.out.println();

        if(count%2!=0)
            return sortedList.get(count/2);
        else
        {
            int lastMiddle = count/2;
            double median = 0;
            median+=sortedList.get(lastMiddle)+sortedList.get(lastMiddle-1);
            return median/2;
        }

    }

   public static ArrayList<Integer> insertOneIntoMany(int[] one_item,int[] many_items)
    {
        ArrayList<Integer> sortedList = new ArrayList<>();
        int i =0;
        if(one_item[0]<many_items[0])
        {
            sortedList.add(one_item[0]);
            for(i=0; i<many_items.length; i++)
                sortedList.add(many_items[i]);
        }
        else if(many_items[many_items.length-1]<one_item[0])
        {
            for(i=0; i<many_items.length; i++)
                sortedList.add(many_items[i]);
            sortedList.add(one_item[0]);
        }
        else {

            boolean inserted = false;
            for(i=0; i<many_items.length; i++)
            {
                sortedList.add(many_items[i]);
                if(inserted==false && many_items[i]<one_item[0] && i+1<many_items.length
                        && one_item[0]<=many_items[i+1])
                {
                    sortedList.add(one_item[0]);
                    inserted=true;
                }

            }
        }

        return  sortedList;
    }

    public static ArrayList<Integer> getSortedList(int[] num1,int num1_start,int num1_end,
                                            int[] num2,int num2_start, int num2_end)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int i=0;
        if(num1[num1_end]<=num2[num2_start])
        {
            for(i=num1_start;i<=num1_end;i++)
                result.add(num1[i]);
            for (i=num2_start;i<=num2_end;i++)
                result.add(num2[i]);
            return result;
        }
        else  if(num2[num2_end]<=num1[num1_start])
        {
            for(i=num2_start;i<=num2_end;i++)
                result.add(num2[i]);
            for (i=num1_start;i<=num1_end;i++)
                result.add(num1[i]);
            return result;
        }
        else
        {
           int left_middle = (num1_start+num1_end)/2;
           int right_middle = (num2_start+num2_end)/2;
           ArrayList<Integer> leftList = getSortedList(num1,num1_start,left_middle,
                   num2,num2_start,right_middle);
           ArrayList<Integer> rightList = getSortedList(num2,right_middle+1,num2_end,num1,
                   left_middle+1,num1_end);

           //add items in list from left to right
           for(i=0; i<leftList.size();i++)
               result.add(leftList.get(i));
           for(i=0;i<rightList.size();i++)
               result.add(rightList.get(i));
           return result;
        }

    }

    //works at nlogn runtime
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        ArrayList<Integer> outputList = new ArrayList<>();
        int i=0;
        for(i=0; i<nums1.length; i++)
            outputList.add(nums1[i]);
        for(i=0; i<nums2.length; i++)
            outputList.add(nums2[i]);
        Collections.sort(outputList);
        int count = outputList.size();
        if(count%2!=0)
            return outputList.get(count/2);
        else
        {
            int lastMiddle = count/2;
            double median = 0;
            median+=outputList.get(lastMiddle)+outputList.get(lastMiddle-1);
            return median/2;
        }

    }


    public static void main(java.lang.String[] args)
    {
        int[] arr1 = new int[]{1,1};
        int[] arr2 = new int[]{1,2};
        System.out.println(findMedianSortedArrays2(arr1,arr2));
    }

}