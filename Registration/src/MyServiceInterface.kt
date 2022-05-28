interface MyServiceInterface {
    fun addUser()
    fun showUsers()

    fun searchUser()
    fun removeUser()

    fun writeFile(list: List<User>)
    fun readFile():ArrayList<User>

}