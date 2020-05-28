 class MinStack {

        int minVal ;
        Stack<Integer> stack ;
        /** initialize your data structure here. */
        public MinStack() {
              stack = new Stack<>();
              minVal = Integer.MAX_VALUE;
        }

        public void push(int x) {
              if(x<minVal)
                  minVal = x;
              stack.push(x);
        }

        public void pop() {
             int popped = stack.pop();
                //check if popped value is min val
             if(popped==minVal)
             {
                 //find new min value
                 Stack<Integer> tempStack = new Stack<>();
                 minVal = Integer.MAX_VALUE;
                 while(!stack.empty())
                 {
                     popped =  stack.pop();
                     if(popped<minVal)
                         minVal=popped;
                     tempStack.push(popped);
                 }
                 while (!tempStack.empty())
                     stack.push(tempStack.pop());
             }
        }

        public int top() {
              return stack.peek();
        }

        public int getMin() {
             return minVal;
        }
    }

