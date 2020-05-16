class divid_and_conquer {
    public int getSubLength(String s,int from, int to)
    {
        if(from-to==0)
            return 1;
        ArrayList currentList = new ArrayList();
        int left_max = 0,middle_max=0,right_max=0,count=0,i=from;
        char startChar=' ';
        //find max from left
        if(from-1>=0)
            startChar = s.charAt(from-1);

        for( ; i<=to; i++)
        {
            if(!currentList.contains(s.charAt(i)))
            {
                count++;
                currentList.add(s.charAt(i));
            }
            else
            {
                if(!currentList.contains(startChar) && startChar!=' ')
                    count++;
                if(count>left_max)
                    left_max=count;
                count=1;
                currentList.clear();
                currentList.add(s.charAt(i));
                if(i-1>=0)
                    startChar=s.charAt(i-1);
                else
                    startChar =' ';
            }
        }
        if(count>=left_max)
        {
            if(!currentList.contains(startChar) && startChar!=' ')
                count++;
            left_max=count;
        }

        //find max from right
        count = 0;
        currentList.clear();
        if(to+1<s.length())
            startChar=s.charAt(to+1);
        else
            startChar=' ';
        for(i=to; i>=0; i--)
        {
            if(!currentList.contains(s.charAt(i)))
            {
                count++;
                currentList.add(s.charAt(i));
            }
            else
            {
                if(!currentList.contains(startChar) && startChar!=' ')
                    count++;
                if(count>right_max)
                    right_max=count;
                count=1;
                currentList.clear();
                currentList.add(s.charAt(i));
                if(i+1<s.length())
                    startChar=s.charAt(i+1);
                else
                    startChar=' ';
            }
        }
        if(count>=right_max)
        {
            if(!currentList.contains(startChar) && startChar!=' ')
                count++;
            right_max=count;
        }



        //find max in from middle
        count=0;
        i = (from+to)/2;
        if(i>=from && i<=to)
        {
            currentList.add(s.charAt(i));
            count++;
        }
        int j=i-1, k=i+1;
        while (true)
        {
            if(j<=from && k>=to)
                break;
            if(from<=j && !currentList.contains(s.charAt(j)))
            {
                count++;
                currentList.add(s.charAt(j));
                j--;
            }
            else j=from-1;
            if(k<=to && !currentList.contains(s.charAt(k)))
            {
                count++;
                currentList.add(s.charAt(k));
                k++;
            }
            else k=to+1;

        }

        int max =Math.max(Math.max(left_max,right_max),middle_max);
        int max2 = Math.max( getSubLength(s,from,(from+to)/2),
                getSubLength(s,((from+to)/2)+1,to));
        return  Math.max(max,max2);

    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1)
            return s.length();
        return getSubLength(s,0,s.length()-1);
    }
}