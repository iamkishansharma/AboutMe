package com.ks.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.ks.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Kishan Kr Sharma")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

//        lateinit var editText:EditText
//        editText = findViewById<EditText>(R.id.nickname_edit)
//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            if(editText.length() == 0){
//                editText.error = getString(R.string.error)
//            }else{
//                addNickname(it)
//            }
//        }
        binding.doneButton.setOnClickListener{
            if(binding.nicknameEdit.length() == 0){
                binding.nicknameEdit.error = getString(R.string.error)
            }else{
                addNickname(it)
            }
        }

    }
    private fun addNickname(view: View){

//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        //Hide the Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
