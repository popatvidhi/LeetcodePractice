package Array;

public class MedianOfTwoSortedArrays {

    public static void main(String args[]){
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;
        int total = a.length + b.length;
        int half = total / 2;
        if(a.length > b.length){
            int[] temp = a;
            a = b;
            b = temp;
        }

        int l = 0, r = a.length - 1;
        while(l <= r){
            int i = (l + r) / 2;
            int j = half - i;

            double aLeft = i == 0 ?  Double.NEGATIVE_INFINITY :  a[i - 1];
            double aRight = i == a.length ? Double.POSITIVE_INFINITY : a[i] ;
            double bLeft = j == 0 ? Double.NEGATIVE_INFINITY : b[j - 1] ;
            double bRight = j == b.length ? Double.POSITIVE_INFINITY : b[j];

            if (aLeft <= bRight && bLeft <= aRight){
                if(total % 2 == 1){
                    return Math.min(aRight, bRight);
                }else{
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight))/2;
                }
            }else if(aLeft > bRight){
                r = i - 1;
            }else{
                l = i + 1;
            }
        }
        return 0.0;
    }
}
