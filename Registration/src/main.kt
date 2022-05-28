import java.util.*

fun main() {
    val input=Scanner(System.`in`)
    val myService=Myservice()

    while (true){
        println("1-qoshish, 2-korish, 3-qidirish, 4-ochirish")
        when(input.nextInt()){
            1->myService.addUser()
            2->myService.showUsers()
            3->myService.searchUser()
            4->myService.removeUser()
        }
    }
}