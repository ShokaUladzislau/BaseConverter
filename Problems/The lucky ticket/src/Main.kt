fun main() {

    val number =readLine()

    if (number != null) {
        if (number[0].toInt() + number[1].toInt() + number[2].toInt() == number[3].toInt() + number[4].toInt() + number[5].toInt())  println("Lucky") else println("Regular")
    }
}