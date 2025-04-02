package com.example.firelock
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.firelock.databinding.SignUpBinding
import com.google.firebase.auth.FirebaseAuth




class SignUpActivity : AppCompatActivity() {
private lateinit var binding:SignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmpass = binding.confirmPassEt.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty() && confirmpass.isNotEmpty() ){
                if(email == (confirmpass)){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent = Intent(this,SignInActivity::class.java)
                            startActivity(intent)

                        }
                        else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                }
                else{
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }

            }
            else{
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }

        }



    }

}