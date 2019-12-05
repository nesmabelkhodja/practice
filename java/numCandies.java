class Solution {
    public int[] numCandies;
    public int candy(int[] ratings) {
        int length = ratings.length;
        numCandies = new int[length];
        int total = length;
   
        //check and make sure it makes sense
        for (int j = 0; j<length; j++){
            for (int i =0; i<length; i++){
                total = compareLeft(ratings, i, total);
            }
            for (int i =0; i<length; i++){
                total = compareRight(ratings, i, total);
            }
        }
        
        return total;
    }
  
    //compares the current child with their right neighbor and updates numCandies
    public int compareRight(int[] ratings, int curr, int total){
        int currCount = numCandies[curr];
        int currRating = ratings[curr];
    
        //right neighbor
        if (curr != ratings.length -1){
            int rightCount = numCandies[curr+1];
            int rightRating = ratings[curr+1];
            //compare with current child
            if (currRating > rightRating && (currCount == rightCount || currCount<rightCount)){
                numCandies[curr] = rightCount+1;
                total +=(numCandies[curr] - currCount);
                currCount = numCandies[curr];
            }
        }
        
        return total;
       
    }
    
    //compares the current child with their left neighbor and updates numCandies
    public int compareLeft(int[] ratings, int curr, int total){
        int currCount = numCandies[curr];
        int currRating = ratings[curr];
        
        //left neighbor
        if (curr != 0){
            int leftCount = numCandies[curr-1];
            int leftRating = ratings[curr-1];
            //compare with current child
            if (currRating > leftRating && (currCount == leftCount || currCount<leftCount)){
                numCandies[curr] = leftCount+1;
                total +=(numCandies[curr]- currCount);
                currCount = numCandies[curr];
            }
        }  
        
        return total;
       
    }
  
}