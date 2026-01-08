import chapter7_linear.product_of_array_except_self.ProductOfArrayExceptSelf;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        ProductOfArrayExceptSelf poae = new ProductOfArrayExceptSelf();
        int[] nums = {-1, 1, 0, -3, 3};
        poae.productExceptSelf(nums);
    }
}