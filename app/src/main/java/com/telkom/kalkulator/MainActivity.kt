
package com.telkom.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import com.telkom.myapplication.R

class MainActivity : AppCompatActivity(){

    private var gender: String = "Laki-laki"
    val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
    val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
    val editTextWeight = findViewById<EditText>(R.id.editTextHeight)
    val textViewResult = findViewById<TextView>(R.id.textViewResult)
    val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalculate.setOnClickListener {
            calculateBMI()
        }
    }

private fun calculateBMI() {
    val height = editTextHeight.text.toString().toDouble()
    val weight = editTextWeight.text.toString().toDouble()

    val selectedGenderId = radioGroupGender.checkedRadioButtonId

    gender = when (selectedGenderId) {
        R.id.radioButtonMale -> "Laki-laki"
        R.id.radioButtonFemale -> "Perempuan"
        else -> "Laki-laki"
    }
    val bmi = when (gender) {
        "Laki-laki" -> weight / ((height / 100) * (height / 100))
        "Perempuan" -> weight / ((height / 100) * (height / 100)) * 0.9
        else -> 0.0
    }
    val result = when {
        bmi < 18.5 -> "Berat badan kurang"
        bmi >= 18.5 && bmi < 24.9 -> "Berat badan normal"
        bmi >= 25 && bmi < 29.9 -> "Berat badan berlebih"
        else -> "Obesitas"
    }
    textViewResult.text = "BMI:%.2f\n$result".format(bmi)
}
}
