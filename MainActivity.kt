package com.example.personal

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.personal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
            addName(it)
        }

        binding.nicknameText.setOnClickListener{
            updateName(it)
        }

//        val done: Button = findViewById(R.id.button) //Previous Task 2
//        done.setOnClickListener{addName(it)}

//        val textView: TextView = findViewById(R.id.nicknameText)
//        textView.setOnClickListener{updateName(it)}
    }


    private fun addName(view: View){
//        val editText = findViewById<EditText>(R.id.nicknameEdit)
//        val editName = findViewById<TextView>(R.id.nicknameText)

        binding.apply {
            nicknameText.text = nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            button.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

//        editName.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        editName.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateName(view: View){
        val editT = findViewById<EditText>(R.id.nicknameEdit)
        val doneB = findViewById<Button>(R.id.button)

        editT.visibility = View.VISIBLE
        doneB.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        editT.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editT, 0)
    }

}