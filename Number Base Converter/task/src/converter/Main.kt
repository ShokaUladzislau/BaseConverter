package converter

import java.math.BigInteger
import kotlin.math.abs
import kotlin.math.log10

fun main() {

    var sourceBaseAndTarget = List<String>(2) { " " }

    while (sourceBaseAndTarget[0] != "/exit") {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit) > ")
        sourceBaseAndTarget = readLine()!!.toString().split(" ")
        if (sourceBaseAndTarget[0] != "/exit") {
            var sourceNumber = ""
            while (sourceNumber != "/back") {
                print("Enter number in base ${sourceBaseAndTarget[0]} to convert to base ${sourceBaseAndTarget[1]} (To go back type /back) > ")
                sourceNumber = readLine()!!.toString()

                if (sourceNumber.contains(".")) {
                    val numbersAroundPoint = sourceNumber.split(".")

                    val firstElement = convertIntegerToNewBase(numbersAroundPoint[0], sourceBaseAndTarget)
                    val lastElement = convertFractionToNewBase(numbersAroundPoint[1], sourceBaseAndTarget)

                    val result = "$firstElement.$lastElement"
                    println("Conversion result: $result")

                } else {
                    if (sourceNumber != "/back") {
                        val result = convertIntegerToNewBase(sourceNumber, sourceBaseAndTarget)
                        println("Conversion result: ${result}")
                    }
                }
            }
        }
    }
}

fun convertIntegerToNewBase(sourceNumber: String, sourceBaseAndTarget: List<String>): String {
    val decimalNumber = convertToDecimal(sourceNumber, sourceBaseAndTarget[0])
    val result = convertFromDecimal(decimalNumber, sourceBaseAndTarget[1])
    return result
}

fun convertFractionToNewBase(sourceNumber: String, sourceBaseAndTarget: List<String>): String {
    val decimalNumber = convertToDecimal(sourceNumber, sourceBaseAndTarget[0])

    var fraction = decimalNumber.toDouble()
    repeat(sourceNumber.length) {
        fraction = fraction / sourceBaseAndTarget[0].toInt()
    }

    var result = ""
    var parameter1 = (fraction * sourceBaseAndTarget[1].toInt())


    while (result.length < 5) {

        result += convertFromDecimal(parameter1.toInt().toBigInteger(), sourceBaseAndTarget[1])

        fraction = (fraction * sourceBaseAndTarget[1].toInt()) - (fraction * sourceBaseAndTarget[1].toInt()).toInt()

    }

    return result

}

fun convertToDecimal(sourceNumber: String, sourceBase: String): BigInteger {
    return sourceNumber.toBigInteger(sourceBase.toInt())
}

fun convertFromDecimal(decimalNumber: BigInteger, targetBase: String): String {
    return decimalNumber.toString(targetBase.toInt());
}


fun Int.length() = when(this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}



