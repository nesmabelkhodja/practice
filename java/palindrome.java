class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length()==1)
            return s;
        int start = 0, end = 0, min = 0, max = 0;
        int maxLength = 1;
        
        for (int i=1; i<s.length(); i++){
            //checks for even pal
            min = i-1;
            max = i;
            while (min>=0 && max <s.length() && s.charAt(min)==s.charAt(max)){
                if (maxLength < (max-min+1)){
                    maxLength = max - min +1;
                    start = min;
                    end = max;
                }
                min--;
                max++;
                
            }
            
            //checks for odd pal
            min = i-1;
            max = i+1;
            while (min>=0 && max <s.length() && s.charAt(min)==s.charAt(max)){
                if (maxLength < (max-min+1)){
                    maxLength = max - min +1;
                    start = min;
                    end = max;
                }
                min--;
                max++;
                
            }
        }
        
        return s.substring(start, end+1);
    }
}