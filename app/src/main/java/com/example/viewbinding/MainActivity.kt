package com.example.viewbinding

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
           val username = binding.name.text.toString()
            val useremail  =binding.email.text.toString()

            if(username.trim().equals("")){
                binding.name.setError("Name Required")
                return@setOnClickListener
            }else{
                if(useremail.trim().equals("")){
                    binding.email.setError("Email Required")
                    return@setOnClickListener
                }else{


                    if (binding.checkbox.isChecked){
                        Toast.makeText(this,"View Binding Is Working",Toast.LENGTH_SHORT).show()

                        binding.name.text?.clear()
                        binding.email.text?.clear()
                        binding.checkbox.isChecked= false
                    }else{
                        Toast.makeText(this,"Plaese accept all T&C",Toast.LENGTH_SHORT).show()

                        binding.checkbox.buttonTintList = ColorStateList.valueOf(Color.RED)
                }
            }


            }
        }

    }
}