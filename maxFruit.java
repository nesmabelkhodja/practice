class Solution {
    public static int max = 0;
    
    //uses a forloop that uses each location as the starting point, then prints the max
    public static int totalFruit(int[] tree) {
        for (int i =0; i<tree.length; i++){
            findMaxFruit(tree, i);
        }
        return max;
    }
    
    //find the max fruit using the parameter start as the starting point
    public static void findMaxFruit(int[] tree, int start){
        int currMax = 1;
        int fruit1 = tree[start];
        int fruit2 = -1;
        
        for (int i = start + 1; i< tree.length; i++){
            int curr = tree[i];
            
            //sets 2nd fruit value
            if (curr != fruit1 && fruit2 == -1){
                fruit2 = curr;
                currMax++;
            }
            else{
                if (curr == fruit1 || curr == fruit2){
                    currMax++;
                }
                else{
                    i = tree.length;
                }
            }
        }

        //if the max for this starting position is greater than the previous max, update
        if (currMax > max){
            max = currMax;
        }
    }
    
    //main method that prints result
    public static void main(int[] args){
        totalFruit(args);
    }
    
}