public class TrappedRainWater {
    public static int trap(int[] height) {
        // two pointers solution
        if (height.length <= 2) return 0; // at least three "bars" needed to trap water

        int n = height.length;
        int maxLeft = height[0];
        int maxRight = height[n-1];

        int left = 1;
        int right = n - 2;
        int ans = 0;

        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left]; // new left max, no trapped water
                } else {
                    ans += maxLeft - height[left]; // water trapped
                }
                left++; // advance left pointer
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right]; // new right max, no trapped water
                } else {
                    ans += maxRight - height[right]; // water trapped
                }
                right--; // advance right pointer
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        int[] elevationMap = {1, 2, 1, 4, 1, 2, 1, 5, 0, 0, 2, 1, 5};
        System.out.println(trap(elevationMap));
    }
}
