package es.iessaladillo.pedrojoya.tipcalculator.model

import kotlin.math.roundToInt


// TipCalculator class. Its constructor receives bill, percentage and diners

class TipCalculator(private var bill: Float, private var percentage: Float, private var diners: Int) {
    init {
        if(bill<0||percentage<0||diners<=0) throw IllegalArgumentException()
    }
    fun calculateTip(): Float {
        return (percentage/100)*bill
    }

    fun calculateTotal(): Float {
        return calculateTip()+bill
    }

    fun calculatePerDiner(): Float {
        return calculateTotal()/diners
    }

    fun calculatePerDinerRounded(): Float {
        return calculatePerDiner().roundToInt().toFloat()
    }

}