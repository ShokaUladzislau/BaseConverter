import java.math.BigInteger

// function to calculate LCM of two large numbers
fun lcm(a: String?, b: String?): BigInteger? {
    // convert string 'a' and 'b' into BigInteger
    val s = BigInteger(a)
    val s1 = BigInteger(b)

    // calculate multiplication of two bigintegers
    val mul = s.multiply(s1)

    // calculate gcd of two bigintegers
    val gcd = s.gcd(s1)

    // calculate lcm using formula: lcm * gcd = x * y
    return mul.divide(gcd)
}

// Driver Code

fun main(args: Array<String>) {

    // Input 'a' and 'b' are in the form of strings because
    // they can not be handled by integer data type
    val a = readLine()
    val b = readLine()
    print(lcm(a, b))
}