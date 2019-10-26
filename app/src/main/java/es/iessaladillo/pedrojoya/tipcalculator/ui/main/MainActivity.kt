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
    }

    private fun setTextChangedListeners() {
        txtBill.doOnTextChanged { text, _, _, _ -> checkChange(text,"bill") }
        txtPercentage.doOnTextChanged { text, _, _, _ -> checkChange(text,"percentage") }
        txtDiners.doOnTextChanged { text, _, _, _ -> checkChange(text, "diners") }
    }

    private fun checkChange(text: CharSequence?,txt: String ) {
        if(text.isNullOrBlank()){
            setDefault(txt)
        }else{
            calculateAll()
        }
    }

    private fun setDefault(txt: String) {
        when(txt) {
            "bill" -> txtBill.setText(R.string.defaultValue)
            "percentage" -> txtPercentage.setText(R.string.defaultValue)
            "diners" -> txtDiners.setText(R.string.defaultDiners)
        }
    }

    private fun calculateAll() {
        var tipCalculator = TipCalculator(txtBill.text.toString().toFloat(),
                                          txtPercentage.text.toString().toFloat(),
                                          txtDiners.text.toString().toInt())

        txtTotal.setText(tipCalculator.calculateTotal().toString())
        txtTip.setText(tipCalculator.calculateTip().toString())
        txtPerDiner.setText(tipCalculator.calculatePerDiner().toString())
        txtPerDinerRounded.setText(tipCalculator.calculatePerDinerRounded().toString())
    }


}
