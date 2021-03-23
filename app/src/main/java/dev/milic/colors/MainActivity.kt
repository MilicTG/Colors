package dev.milic.colors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import dev.milic.colors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        checkForColors()
    }

    private fun checkForColors() {
        var redChannel = ""
        var greenChannel = ""
        var blueChannel = ""

        binding.inputRedChannel.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                redChannel = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.inputGreenChannel.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                greenChannel = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        binding.inputBlueChannel.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                blueChannel = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        binding.createButton.setOnClickListener {
            if (redChannel.isNotEmpty() && greenChannel.isNotEmpty() && blueChannel.isNotEmpty()) {
                createColor(redChannel, greenChannel, blueChannel)
            } else {
                Toast.makeText(this, "Please fill all fields!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun createColor(red: String, green: String, blue: String) {
        val colorAsInt = Color.parseColor("#".plus(red).plus(green).plus(blue))
        binding.colorDisplay.setBackgroundColor(colorAsInt)
        binding.createdColor.text = "#".plus(red).plus(green).plus(blue)
    }
}