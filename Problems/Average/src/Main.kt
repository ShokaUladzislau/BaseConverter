import java.math.BigDecimal
import java.math.RoundingMode

fun main() {

    var number = BigDecimal("2.001")
    number += BigDecimal.ONE
    number = -number
    number.setScale(1, RoundingMode.HALF_DOWN)
    print(number)

}
