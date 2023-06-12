class Solution {
    public List<String> summaryRanges(int[] arr) {
        List<String> res = new ArrayList<String>();
        int a = 0;
        if(arr.length==0)   return res;         // 0 length array
        
        if(arr.length==1)  {                    // 1 length array
            a = arr[0];
            res.add(""+a);
            return res;
        } 
        // more than 1 length
        int i=0,j=1;
        a = arr[0];
        while(j<arr.length){
            if(arr[j]==arr[i]+1){
                i++;
                j++;
            }
            else{
                int b = arr[i];
                if(a == b) 
                    res.add(""+ a);
                else res.add(a+"->"+b);
                
                i++; j++;
                a = arr[i];
            }
        }
       
        int b = arr[i];
       if(a == b) 
            res.add(""+ a);
        else res.add(a+"->"+b);
        return res;
    }
}



