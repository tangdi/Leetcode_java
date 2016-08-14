/**
 * ClassName: SuperPow Function: TODO
 *
 * @Author: dtang
 * @Date: 8/10/16, 5:40 PM
 */
public class SuperPow {
    public int superPow(int a, int[] b) {

        int result = 1;
        for(int i =0; i<b.length; i++){
            result = power(result, 10, 1337) ;
            result = result * power(a, b[i], 1337) % 1337;
        }
        return result;
    }

    private int power(int x, int n, int mod) {
        x %= mod;
        int ret = 1;
        if(n ==0){
            return ret;
        }
        if( (n & 1) !=0){
            ret = ret * x % mod;
            n--;
        }
        int temp = power(x, n /2, mod);
        temp = temp * temp % mod;
        return ret * temp % mod;
    }
}
