package com.example.calculatorapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView

    private var firstNumber = 0.0
    private var operator = ""
    private var newNumber = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.resultText)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2,
            R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8,
            R.id.btn9
        )

        for (id in buttons) {

            findViewById<Button>(id).setOnClickListener {

                val button = findViewById<Button>(id)

                if (newNumber) {
                    resultText.text = button.text
                    newNumber = false
                } else {
                    resultText.append(button.text)
                }
            }
        }

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            setOperator("+")
        }

        findViewById<Button>(R.id.btnMinus).setOnClickListener {
            setOperator("-")
        }

        findViewById<Button>(R.id.btnMultiply).setOnClickListener {
            setOperator("*")
        }

        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            setOperator("/")
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {

            resultText.text = "0"
            firstNumber = 0.0
            operator = ""
            newNumber = true
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {

            val secondNumber = resultText.text.toString().toDouble()

            val result = when(operator) {

                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                else -> 0.0
            }

            resultText.text = result.toString()
            newNumber = true
        }
    }

    private fun setOperator(op: String) {

        firstNumber = resultText.text.toString().toDouble()
        operator = op
        newNumber = true
    }
}