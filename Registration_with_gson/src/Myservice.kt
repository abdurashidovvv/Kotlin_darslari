import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileWriter
import java.util.*
import kotlin.collections.ArrayList

class Myservice:MyServiceInterface {
    val file=File("register.txt")
    val input=Scanner(System.`in`)


    override fun addUser() {
        println("Username kiriting: ")
        val userName=input.next()
        println("Password kiriting: ")
        val password=input.next()
        val user=User(userName, password)

        if(file.isFile){
            file.createNewFile()
        }

        val list=readFile()
        list.add(user)
        writeFile(list)
        println("Saqlandi")

    }


    override fun showUsers() {
        val list=readFile()
        for (user in list) {
            println(user)
        }

    }

    override fun searchUser() {
        println("Username ni kiriting: ")
        val sName=input.next()
        val searchList=readFile()
        var has=false
        for (k in searchList) {
            if(sName==k.userName){
                println(k)
                has=true
            }
        }
        if(has==false){
            println("Foydalanuvchi topilmadi")
        }
    }



    override fun removeUser() {
        val list=readFile()
        println("Usernameni kiriting: ")
        val rUser=input.next()
        val rList=readFile()
        for (r in rList) {
            if(rUser==r.userName){
                list.remove(r)
                println("O'chirildi")
                break
            }
        }
        writeFile(list)

    }




    override fun writeFile(list: ArrayList<User>) {
        val fileWriter=FileWriter(file)
            fileWriter.write(listToGsonString(list))
        fileWriter.close()
    }

    override fun readFile(): ArrayList<User> {
        val gsonStringList=file.readLines()
        return gsonStringToList(gsonStringList[0])
    }

    override fun gsonStringToList(gsonString: String): ArrayList<User> {
        val gson= Gson()
        val type=object : TypeToken<ArrayList<User>>(){}.type
        return gson.fromJson(gsonString, type)
    }

    override fun listToGsonString(list: ArrayList<User>): String {
        return Gson().toJson(list)
    }
}