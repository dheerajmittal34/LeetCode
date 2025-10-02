public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Make sure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int left = 0;
        int right = m;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = totalLeft - i;

            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found the correct partition
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }

    // Main method for testing
    public static void main(String[] args) {
        MedianSortedArrays sol = new MedianSortedArrays();

        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};

        double median = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median is: " + median);  // Output: 2.0
    }
}
