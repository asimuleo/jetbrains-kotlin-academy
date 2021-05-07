package org.hyperskill.calculator.tip

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edit_text)
        val slider = findViewById<Slider>(R.id.slider)
        val textView = findViewById<TextView>(R.id.text_view)
        editText.doAfterTextChanged {
            if (it.isNullOrEmpty()) {
                textView.text = ""
            } else {
                val f = "%.2f".format(it.toString().toDouble() * slider.value / 100)
                textView.text = "Tip amount: $f"
            }
        }
        slider.addOnChangeListener { slider: Slider, value: Float, fromUser: Boolean ->
            editText.text = editText.text
        }


    }
}