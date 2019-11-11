class Solution {
    public int trap(int[] height) {
        int water = 0, curr = 0;
        int length = height.length;
        Stack<Integer> st = new Stack<Integer>();
        
        while (curr < length){

            while (st.size()!=0 && (height[curr] > height[st.peek()])){

                int top = st.peek();
                st.pop();
                if (st.size() != 0){
                    int dist = curr - st.peek() - 1;
                    //finds the minumum common height and subtracts the floor
                    int bounded_height = Math.min(height[curr], height[st.peek()]) - height[top];
                    water+= dist * bounded_height;
                }
                
            }
            
            st.push(curr++);
        }
        
        return water;
    }
}