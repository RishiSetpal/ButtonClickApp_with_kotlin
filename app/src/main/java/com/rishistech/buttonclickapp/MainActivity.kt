package com.rishistech.buttonclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// Log has 2 arguments (TAG, "message")
// to mark form which log
private val TAG = "MainActivity"
private const val TEXT_CONTENTS = "Text Contents"

class MainActivity : AppCompatActivity() {
    //making this var to val as we are not changing them again and again
    //it will remove redundant code in ?. to . while using methods
    // bacially no need to create it nullable
//        var userInput :EditText ?= null // We need to initialize var in kotlin
//        var button: Button ?= null //nullable ?=
//        var numTimesClicked = 0
    var textView:TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate: called")


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setContentView- inflate a Layout //inflate- Takes out xml Definition for layout and create a widgets those are defined

        //Binding
        val userInput = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        textView = findViewById(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()
        userInput.setText("")

        //setOnClickListener -> what to do when the button is Clicked
        //onClick-> This method is called when the button is Clicked
        //Interface is defined in view Class
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
//                numTimesClicked+=1
//                textView?.append("The button got tapped $numTimesClicked time")
//                if (numTimesClicked!=1){
//                    textView.append("s")
//                }
//                textView.append("\n")
                textView?.append(userInput.text.toString()+"\n")
                //userInput.text.clear()//This will keep it CharSequence //we can also use setText("")
                userInput.setText("")//This will keep it String
                Log.d(TAG,"onClick: called")

            }
        })

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart: called")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG,"onRestoreInstanceState: called")
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS,"")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume: called")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause: called")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val d = Log.d(TAG, "onSaveInstanceState: called")
        outState.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop: called")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart: called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy: called")

    }


}
