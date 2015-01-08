public class Candy {
	// copy from http://fisherlei.blogspot.com/2013/11/leetcode-candy-solution.html
	public int candy(int[] ratings) {
        int n = ratings.length;
        if ( n == 0 )
            return 0;       //  特殊情况，直接返回0
        int[] candy = new int[n];
        candy[0] = 1;        // give 1 candy to leftmost child 
        for ( int i = 1; i < n ; ++i )
            if ( ratings[i] >ratings[i-1]   ) 
                candy[i] = candy[i-1]+1;         // increase
            else
                candy[i] = 1;           // 非递增情况只给一块糖，等从右到左扫描时再修正
        for ( int i = n-2; i >= 0; --i)      // 从右到左
            if ( ratings[i] > ratings[i+1] && candy[i]<=candy[i+1] )        // give more candies to children who had inappropriate candies
                candy[i] = candy[i+1] + 1;
        // calculate sum
        int sum = 0;
        for ( int i = 0; i < n; ++i )
            sum += candy[i];
        return sum;
    }
}
