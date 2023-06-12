class Solution {
    public List<String> summaryRanges(int[] arr) {
        List<String> res = new ArrayList<String>();
        
//         String st = "";
//         if(arr.length==0)   return res;         // 0 length array
        
//         if(arr.length==1)  {                    // 1 length array
//             st += arr[0];
//             res.add(st);
//             return res;
//         } 
//         // more than 1 length
//         int i=0,j=1;
//         st += arr[0];
//         while(j<arr.length){
//             if(arr[j]==arr[i]+1){
//                 i++;
//                 j++;
//             }
//             else{
//                 st = st+"->"+arr[i];
//                 if(st.charAt(0) != st.charAt(3)) 
//                     res.add(new String(st));
//                 else res.add(new String(""+st.charAt(0)));
                
//                 i++; j++;
//                 st = ""+arr[i];
//             }
//         }
//         st = st+"->"+arr[i];
//         System.out.println(st.charAt(0) +"   "+ st.charAt(3));
//         if(st.charAt(0) != st.charAt(3)) 
//             res.add(new String(st));
//         else res.add(new String(""+st.charAt(0)));
//         return res;
            
        int prev = 0;
        if(arr.length==0)   return res;         // 0 length array
        
        if(arr.length==1)  {                    // 1 length array
            prev = arr[0];
            res.add(""+prev);
            return res;
        } 
        // more than 1 length
        int i=0,j=1;
        prev = arr[0];
        while(j<arr.length){
            if(arr[j]==arr[i]+1){
                i++;
                j++;
            }
            else{
                
                if(prev != arr[i]) 
                    res.add(prev+"->"+arr[i]);
                else res.add(""+ prev);
                
                i++; j++;
                prev = arr[i];
            }
        }
       
        //System.out.println(st.charAt(0) +"   "+ st.charAt(3));
        if(prev != arr[i]) 
            res.add(prev+"->"+arr[i]);
        else res.add(""+ prev);
        return res;
    }
}



