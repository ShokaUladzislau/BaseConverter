import java.math.BigInteger

fun main() {
    val a = BigInteger.valueOf(readLine()!!.toLong())
    val b = BigInteger.valueOf(Math.pow(2.toDouble(), 63.toDouble()).toLong())
    val c = BigInteger.valueOf(1)
    println((a * b).plus(a)) }


