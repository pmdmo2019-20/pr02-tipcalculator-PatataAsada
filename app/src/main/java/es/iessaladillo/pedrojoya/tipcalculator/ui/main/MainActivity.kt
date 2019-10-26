package es.iessaladillo.pedrojoya.tipcalculator.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import es.iessaladillo.pedrojoya.tipcalculator.R
import es.iessaladillo.pedrojoya.tipcalculator.model.TipCalculator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTextChangedListeners()
        setButtons()
    }

    private fun setButtons() {
        btnResetTip.setOnClickListener { resetTipAndBill() }
        btnResetDiners.setOnClickListener { resetDiners() }
    }

    private fun resetTipAndBill() {
        txtTip.setText(R.string.defaultTip)
        txtBill.setText(R.string.defaultValue)
        txtBill.requestFocus()
    }

    private fun resetDiners() {
        txtDiners.setText(R.string.defaultDiners)
        txtDiners.requestFocus()
    }

    private fun setTextChangedListeners() {
        txtBill.doOnTextChanged { text, _, _, _ -> checkChange(text, "bill") }
        txtPercentage.doOnTextChanged { text, _, _, _ -> checkChange(text, "percentage") }
        txtDiners.doOnTextChanged { text, _, _, _ -> checkChange(text, "diners") }
    }

    private fun checkChange(text: CharSequence?, txt: String) {
        if (text.isNullOrBlank() || text.isEmpty()) {
            setDefault(txt)
        } else {
            calculateAll()
        }
    }

    private fun setDefault(txt: String) {
        when (txt) {
            "bill" -> txtBill.setText(R.string.defaultValue)
            "percentage" -> txtPercentage.setText(R.string.defaultTip)
            "diners" -> txtDiners.setText(R.string.defaultDiners)
        }
    }

    private fun calculateAll() {
        var tipCalculator = TipCalculator(
            txtBill.text.toString().toFloat(),
            txtPercentage.text.toString().toFloat(),
            txtDiners.text.toString().toInt()
        )

        txtTotal.setText(String.format("%.2f",tipCalculator.calculateTotal()))
        txtTip.setText(String.format("%.2f",tipCalculator.calculateTip()))
        txtPerDiner.setText(String.format("%.2f",tipCalculator.calculatePerDiner()))
        txtPerDinerRounded.setText(String.format("%.2f",tipCalculator.calculatePerDinerRounded()))
    }


}
