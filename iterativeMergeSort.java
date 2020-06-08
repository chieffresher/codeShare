class Solution {
    public static int findKthLargest(int[] nums, int k) {
          ArrayList<Integer> sortedList = iterativelyMergeSort(nums);
          return sortedList.get(sortedList.size()-k);
        
     /*   //this solution is faster because Arrays.sort() uses the most optimal
         // algorithm for each case
           Arrays.sort(nums);
           return nums[nums.length-k];
        */
    }
   public static ArrayList<Integer> iterativelyMergeSort(int[] nums)
    {
         //Note : iterative mergesort is not as fast as recursive mergesort
       //for one main reason: it merges n-2 times whiles recursive merges logn times
       //Recursive has an overhead of pushing all logn calls onto a stack.

        if(nums.length==0)
            return new ArrayList<Integer>();
        else if(nums.length==1)
        {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(nums[0]);
            return ans;
        }

        ArrayList<Integer> sorted = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        boolean inserted = false;
        int toInsert=0, listNum=0;
        int j=0, i=0;
        //sort first two elements
        if(nums[0]<nums[1])
        {
            sorted.add(nums[0]);
            sorted.add(nums[1]);
        }
        else
        {
            sorted.add(nums[1]);
            sorted.add(nums[0]);
        }

        for(i=2; i<nums.length; i++)
        {
            //merge nums[i] with sorted list
              //copy sorted array into temp list
            temp = new ArrayList<>();
            //start merging process
            inserted = false;
            toInsert = nums[i];
            for(j=0; j<sorted.size();j++)
            {
                listNum = sorted.get(j);
                if(inserted)
                    temp.add(listNum);
                else
                {
                    if(toInsert<=listNum)
                    {
                        temp.add(toInsert);
                        inserted = true;
                        temp.add(listNum);
                    }
                    else
                        temp.add(listNum);
                }
            }
            if(!inserted)
                temp.add(toInsert);
            sorted = temp;
        }

        return sorted;

    }
}