package com.example.userssp

import android.app.ProgressDialog.show
import android.content.Context
import android.content.DialogInterface
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userssp.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), OnClickListener {

   private lateinit var userAdapter: UserAdapter
   private lateinit var linearLayoutManager: RecyclerView.LayoutManager

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getPreferences(Context.MODE_PRIVATE)

        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        Log.i("SP", "${getString(R.string.sp_first_time)} = $isFirstTime")

        if (isFirstTime) {
           val dialgoView = layoutInflater.inflate(R.layout.dialog_register, null)
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title)
                .setView(dialgoView)
                .setCancelable(false)
                .setPositiveButton(R.string.dialog_confirm, { dialogInterface, i ->
                    val username = dialgoView.findViewById<TextInputEditText>(R.id.etUserName)
                        .text.toString()
                    with(preferences.edit()){
                        putBoolean(getString(R.string.sp_first_time), false)
                        putString(getString(R.string.sp_username), username)
                            .apply()
                    }
                    Toast.makeText(this, R.string.register_success, Toast.LENGTH_SHORT)
                        .show()
                })
                .show()

        } else {
            val username = preferences.getString(getString(R.string.sp_username), getString(R.string.hint_username))
            Toast.makeText(this, "Bienvenido $username", Toast.LENGTH_SHORT).show()
        }

        userAdapter = UserAdapter(getUsers(), this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun getUsers(): MutableList<User>{
        val users = mutableListOf<User>()

        val santiago = User(1, "santiago", "Guido", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTc-BIM5ckxm15fh_Q4ZHCwbCDOT134mRbeWQ&usqp=CAU")
        val nancy = User(2, "Nancy", "Mendoza", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzBc3wwrEp7-fSziNDnw_l9Xk54Ju7T_SLkQ&usqp=CAU")
        val javier = User(3, "javier", "escobedo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqgOwT1DwNq0JcR8X0HF0hUOfIgtKfs-F6Gw&usqp=CAU")
        val sandra = User(4, "sandra", "herrera", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIV-dVRiXTVk2ee4AskQO8tlJRsu1DLYyd5Q&usqp=CAU")
        val juan = User(5, "juan", "pérez", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqUs_4FmX9o2PlI_NbAHm3RNid95AF-4T4PA&usqp=CAU")
        val thalia = User(6, "thalia", "mendez", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzvrbMUnV0aZv5XgxqvkVbdj1NLJ6lSXdW6w&usqp=CAU")
        val oscar = User(7, "oscar", "ortiz", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXPdr40-ZN2lJRkzI0K8OZaaFnLcm-f5Ez-g&usqp=CAU")
        val antonio = User(8, "antonio", "gomez", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnVmfMDg3Kde3XxZ0eGRijulcthutUDnYQkw&usqp=CAU")
        val fabiola = User(9, "fabiola", "torres", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBjElExeNF3kll0QOOJpzDvu9viewk1jGobA&usqp=CAU")


        users.add(santiago)
        users.add(nancy)
        users.add(javier)
        users.add(sandra)
        users.add(juan)
        users.add(thalia)
        users.add(oscar)
        users.add(antonio)
        users.add(fabiola)
        users.add(javier)
        users.add(sandra)
        users.add(juan)
        users.add(thalia)
        users.add(oscar)
        users.add(antonio)
        users.add(fabiola)
        users.add(javier)
        users.add(sandra)
        users.add(santiago)
        users.add(nancy)
        users.add(javier)
        users.add(sandra)
        users.add(juan)
        users.add(thalia)
        users.add(oscar)
        users.add(antonio)
        users.add(fabiola)
        users.add(javier)
        users.add(sandra)
        users.add(juan)
        users.add(thalia)
        users.add(oscar)
        users.add(antonio)
        users.add(fabiola)
        users.add(javier)
        users.add(sandra)
        users.add(santiago)

        return users

    }

    override fun onClick(user: User, position: Int) {
        Toast.makeText(this, "$position ${user.getFullName()}", Toast.LENGTH_SHORT) .show()
    }
}