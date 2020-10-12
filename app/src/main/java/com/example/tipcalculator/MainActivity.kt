package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lowTipButton.setOnClickListener {
            fillTip(lowTipButton.text)
        }

        midTipButton.setOnClickListener {
            fillTip(midTipButton.text)
        }

        highTipButton.setOnClickListener {
            fillTip(highTipButton.text)
        }

    }

    fun calculate(view: View) {
        val tip = customTip.text.toString().toIntOrNull() ?: -1
        val bill: Float = billTotal.text.toString().toFloatOrNull() ?: -1.0f

        if (tip > 0 && bill > 0) {
            billText.text = formatString(bill)
            tipText.text = formatString(calculateTipAmount(bill, tip))
            calcTotalText.text = formatString(calculateTotalBill(bill, tip))
            val tipPercent = "($tip%)"
            tipPercentOutput.text = tipPercent
        }
    }

    private fun formatString(num: Float): String {
        return "$%.2f".format(num)
    }

    private fun calculateTipAmount(bill: Float, tip: Int): Float {
        return (tip / 100f) * bill
    }

    private fun calculateTotalBill(bill: Float, tip: Int): Float {
        return calculateTipAmount(bill, tip) + bill
    }

    private fun fillTip(text: CharSequence) {
        customTip.setText(text.substring(0, text.indexOf("%")))
    }

}