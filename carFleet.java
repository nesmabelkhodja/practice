class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        //map of position, time
        HashMap<Integer, Double> map = new HashMap<>();
        for (int i = 0; i<n; i++){
            map.put(position[i], ((target - position[i])/ (double)speed[i]));
        }
        Arrays.sort(position);
        int curr = n;
        int result= 0;
        while (--curr > 0){
            System.out.println(map.get(position[curr-1]));
            if (map.get(position[curr]) < map.get(position[curr-1])){
                result++;   
            }
            else {
                map.put(position[curr-1], map.get(position[curr]));
            }
        }
        //see if there is lone car
        if (curr == 0){
            result++;
        }
        return result;
        
    }
}