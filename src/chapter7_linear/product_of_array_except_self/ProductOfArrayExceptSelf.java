package chapter7_linear.product_of_array_except_self;

public class ProductOfArrayExceptSelf {

    /*
        곱은 항상 32bit 를 초과하지 않는다.
        나눗셈을 사용하지 않고, O(n) 으로 풀어야 한다.
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= p;
            p *= nums[i];
        }

        return result;
    }
}
