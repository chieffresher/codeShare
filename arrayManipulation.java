  // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long max = 0;
        int i=0,j=0;
        long[] result = new long[n];
        HashMap<Integer,Long> nonZeros = new HashMap<>();
        long curval = 0;
        for(i=0; i<queries.length; i++)
        {
            for(j=queries[i][0]-1; j<queries[i][1]; j++)
            {
                curval = nonZeros.get(j)==null ? queries[i][2] : queries[i][2] + nonZeros.get(j);
               nonZeros.put(j,curval);
               if(curval>max)
                   max = curval;
            }
        }
        
        return max;

    }