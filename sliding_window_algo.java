   public static int subarraySum(int[] nums, int k)
    {

        if(nums.length==0)
            return 0;
        if(nums.length==1 && nums[0]==k)
            return 1;
        else if(nums.length==1 && nums[0]!=k)
            return 0;

        int totalCount=0,currentSum=0,startPt=0;
        int backSum=0;
        int len = nums.length;
        for(int i=0; i<len; i++)
        {
            currentSum+=nums[i];
            if(currentSum==k)
                totalCount++;
            //slide from the back (index 0 up to index i-1)
            backSum = currentSum;
            while (startPt<i)
            {
                backSum-=nums[startPt];
                startPt++;
                if(backSum==k)
                    totalCount++;
            }
            startPt=0;
        }

        return totalCount;
    }

    public static int lengthOfLongestSubstring(String s) {
        //base cases
        if(s.length()==0 || s.length()==1)
            return s.length();

        int max = 0, count=0;
        char curChar=' ';
        LinkedHashMap<Character,Character> curList = new LinkedHashMap<>();
        ArrayList<Character> removeList = new ArrayList<>();

        for(int i=0; i<s.length(); i++)
        {
            if(curList.get(s.charAt(i))==null)
            {
               count++;
               curList.put(s.charAt(i),s.charAt(i));
            }
            else
                {
                    if(count>max)
                      max=count;
                 //shrink list from back until you find s.charAt(i)
                    removeList.clear();
                     for (HashMap.Entry<Character, Character> entry : curList.entrySet())
                     {
                         curChar = entry.getKey();
                         removeList.add(curChar);
                         count--;
                         if(curChar==s.charAt(i))
                             break;
                     }
                     for(int k=0; k<removeList.size();k++)
                         curList.remove(removeList.get(k));
                 //add current item to list
                  count++;
                 curList.put(s.charAt(i),s.charAt(i));
            }
        }
        if(count>max)
            max=count;

        return max;

    }