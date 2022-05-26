import java.text.SimpleDateFormat
import java.util.*

fun main(){
    val input=Scanner(System.`in`)
    val simpleDateFormat=SimpleDateFormat("dd.MM.yyyy")

    while (true) {
        println("Sanani 'dd.MM.yyyy' formatida kiriting: ")

        println("Birinchi date ni kiriting: ")
        val date1 = simpleDateFormat.parse(input.next())

        println("Ikkinchi date ni kiriting: ")
        val date2 = simpleDateFormat.parse(input.next())

        val fClendar = Calendar.getInstance()
        fClendar.time = date1

        val sCalendar = Calendar.getInstance()
        sCalendar.time = date2

        var farqYil = sCalendar[Calendar.YEAR] - fClendar[Calendar.YEAR]
        var farqOy = farqYil * 12 + (sCalendar[Calendar.MONTH] - fClendar[Calendar.MONTH])


        var yil = 0
        var farqKun = 0

        while (yil <= farqYil - 1) {
            farqKun += dayInYear(yil)
            yil++
        }
        farqKun += sCalendar[Calendar.DAY_OF_YEAR]
        farqKun -= fClendar[Calendar.DAY_OF_YEAR]

        println("Ikki sana orasidagi farq:\nYil: ${farqYil} \nOy: ${farqOy} \nKun: ${farqKun}")
    }
}

fun dayInYear(yil:Int):Int{
    var december31=Calendar.getInstance()
    december31[Calendar.DAY_OF_MONTH]=31
    december31[Calendar.MONTH]=11
    december31[Calendar.YEAR]=yil

    return  december31[Calendar.DAY_OF_YEAR]
}