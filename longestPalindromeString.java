
class Palindrome {

    public static String longestPalindrome(String s) {

        if(s.length()<=1)
            return s;
        if(s.length()==2 && s.charAt(0)==s.charAt(1))
            return s;
        else if(s.length()==2 && s.charAt(0)!=s.charAt(1))
            return ""+s.charAt(0);

        int main_index,max_start=0,max_end=0,current_max=0,
                left_pointer,right_pointer,strLen=s.length(),
                max=0;
        String answer ="";

        for(main_index=1; main_index<s.length(); main_index++)
        {
            //case 1 : check for odd palindrome
           left_pointer=main_index-1;
           right_pointer=main_index+1;
           while (left_pointer>=0 && right_pointer<strLen)
           {
               if(s.charAt(left_pointer)==s.charAt(right_pointer))
               {
                   left_pointer--;
                   right_pointer++;
               }
               else break;
           }
           current_max = (right_pointer-1) - (left_pointer + 1)+1;
           if(current_max>max)
           {
               max = current_max;
               max_start = left_pointer+1;
               max_end = right_pointer-1;
           }
           //case 2 : check for even palindrome
            if(main_index+1<strLen && s.charAt(main_index)==s.charAt(main_index+1))
            {
                left_pointer = main_index-1;
                right_pointer = main_index+2;
                while (left_pointer>=0 && right_pointer<strLen)
                {
                    if(s.charAt(left_pointer)==s.charAt(right_pointer))
                    {
                        left_pointer--;
                        right_pointer++;
                    }
                    else break;
                }
                current_max = (right_pointer-1) - (left_pointer + 1)+1;
                if(current_max>max)
                {
                    max = current_max;
                    max_start = left_pointer+1;
                    max_end = right_pointer-1;
                }
            }

           //case 3 : check for palindrome where same character is repeated
            left_pointer=main_index-1;
            right_pointer=main_index+1;
            boolean shouldContinue = false;
            while (left_pointer>=0 || right_pointer<strLen)
            {
                shouldContinue = false;
                if(left_pointer>=0 && s.charAt(main_index)==s.charAt(left_pointer))
                {
                    left_pointer--;
                    shouldContinue=true;
                }

                if(right_pointer<strLen && s.charAt(main_index)==s.charAt(right_pointer))
                {
                    right_pointer++;
                    shouldContinue = true;
                }
                if(!shouldContinue)
                    break;

            }
            current_max = (right_pointer-1) - (left_pointer + 1)+1;
            if(current_max>max)
            {
                max = current_max;
                max_start = left_pointer+1;
                max_end = right_pointer-1;
            }

        }
        for(int i=max_start; i<=max_end; i++)
            answer+=s.charAt(i);
        return answer;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("cbaba"));
    }
}