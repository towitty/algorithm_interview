package chapter7_linear.best_time_to_buy_and_sell_stock

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = prices[0]

    for (price in prices) {
        minPrice = minPrice.coerceAtMost(price)
        maxProfit = maxProfit.coerceAtLeast(price - minPrice)
    }

    return maxProfit
}