interface MyServiceInterface {
    fun addUser()
    fun showUsers()

    fun searchUser()
    fun removeUser()

    fun writeFile(list: ArrayList<User>)
    fun readFile():ArrayList<User>

    fun gsonStringToList(gsonString:String):ArrayList<User>
    fun listToGsonString(list: ArrayList<User>):String


}