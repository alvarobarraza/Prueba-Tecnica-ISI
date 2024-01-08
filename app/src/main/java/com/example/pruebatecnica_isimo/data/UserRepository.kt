package com.example.pruebatecnica_isimo.data

import com.example.pruebatecnica_isimo.R
import com.example.pruebatecnica_isimo.model.User

class UserRepository {

    private val userList: List<User> = listOf(
        User("Dana Little", R.drawable.img1),
        User("Warren Silva", R.drawable.img2),
        User("Olivia Mckinney",R.drawable.img3),
        User("Dustin Rice",R.drawable.img4),
        User("Jean Lucas",R.drawable.img5),
        User("Miriam Allen",R.drawable.img6),
        User("Daryl Reid",R.drawable.img7),
        User("Kitty Phillips",R.drawable.img8),
        User("Marcus Oliver",R.drawable.img9),
        User("Luke Owens",R.drawable.img10),
        User("Ann Terry",R.drawable.img11),
        User("Georgia Chapman",R.drawable.img12),
        User("Fred Myers",R.drawable.img13),
        User("Louise Adams",R.drawable.img14),
        User("Peggy Richardson",R.drawable.img15),
        User("sara larson",R.drawable.img16),
        User("doris carroll",R.drawable.img17),
        User("stephen jimenez",R.drawable.img18),
        User("gary sims",R.drawable.img19),
        User("mario hughes",R.drawable.img20),
    )

    fun getUserList(): List<User> {
        return userList
    }

}