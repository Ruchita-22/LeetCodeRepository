class Solution {
    public int[] sortedSquares(int[] arr) {
        Arrays.sort(arr);
        arr = Arrays.stream(arr).map(x-> x*x).toArray();
        Arrays.sort(arr);
        return arr;
    }
}