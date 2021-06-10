import java.math.BigDecimal
import java.math.RoundingMode

fun main() {

    val a = BigDecimal(readLine())
    val b = BigDecimal(readLine())

    println(a.setScale(b.toInt(), RoundingMode.HALF_DOWN))

}