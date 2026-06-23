class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        int ab = a | b;
        //System.out.println(ab);
        for(int i = 0; i < 32; i++) {
            int cBit = ((c>>i)&1);
            int abBit = ((ab>>i)&1);
            if(cBit != abBit) {
                if(abBit == 0) count++;
                else if(abBit == 1) {
                    if(((a>>i) & 1) == 1) count++;
                    if(((b>>i) & 1) == 1) count++;
                }

            }
        }
        return count;
    }
}