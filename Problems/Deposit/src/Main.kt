import java.math.BigDecimal
import java.math.RoundingMode

fun main() {

    val startingAmount = BigDecimal(readLine())
    val yearlyPercentage = BigDecimal(readLine())
    val years = BigDecimal(readLine())

    val result = startingAmount * (BigDecimal.ONE + yearlyPercentage.setScale(2 + yearlyPercentage.scale()) / BigDecimal(100)).pow(years.toInt())

    println("Amount of money in the account: " + result.setScale(2, RoundingMode.CEILING))
}