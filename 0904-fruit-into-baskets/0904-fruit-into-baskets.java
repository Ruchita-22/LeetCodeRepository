class Solution {
    public int totalFruit(int[] fruits) {
        
        var map = new HashMap<Integer,Integer>();
        
        int i=0,len=0;
        
        for(int j =0; j<fruits.length; j++){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);

            while(map.size()>2){
                int a = fruits[i];
                map.put(a,map.get(a)-1);
                if(map.get(a)==0)   map.remove(a);
                i++;
            }
            len = Math.max(len,j-i+1);             
                
        }
        if(map.size()<2)
            return map.get(fruits[i]);
        return len;
    }
}
//variation of len of the longest substring with k unique character
//pick toy varaiation