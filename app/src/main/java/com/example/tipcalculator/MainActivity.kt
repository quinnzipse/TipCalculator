package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

abstract class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var tip: Float = -1.0f

    fun calculate(view: View) {
        if(!customTip.text.equals("")){
            tip = customTip.text.toString().toFloat()
        }

        val bill: Float = billTotal.text.toString().toFloat()

        // TODO: Assign this to output.
        Log.d("Calculate","Bill: " + bill + "Tip Amount: " + calculateTipAmount(bill) + " Total: " + calculateTotalBill(bill))
    }

    private fun calculateTipAmount(bill: Float): Float {
        return (tip / 100f) * bill
    }

    private fun calculateTotalBill(bill: Float): Float {
        return calculateTipAmount(bill) + bill
    }
}