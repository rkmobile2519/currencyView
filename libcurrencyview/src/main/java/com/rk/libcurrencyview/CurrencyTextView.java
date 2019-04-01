package com.rk.libcurrencyview;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyTextView extends AppCompatTextView {

    private final String TAG = CurrencyTextView.class.getSimpleName();

    private String sCurrency;

    public CurrencyTextView(Context context) {
        super(context);
    }

    public CurrencyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CurrencyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (text != null && !text.toString().isEmpty()) {
            String formatedString = null;
            try {
                // The comma in the format specifier does the trick
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                formatter.applyPattern("#,##,##,##,###.##");
                formatedString = sCurrency + formatter.format(Double.parseDouble(text.toString()));  // adds rupee symbol and thousand seperater
            } catch (NumberFormatException e) {
                Log.d(TAG, "Rupee TextView NumberFormatException");
                e.printStackTrace();
            }
            super.setText(formatedString, type);
        } else {
            super.setText(text, type);
        }
    }

    public void setCurrecy(String sCurrency) {
        this.sCurrency = sCurrency;
    }

    public double getRateWithoutCurrency() {
        return Double.parseDouble(getText().toString().trim().replace(sCurrency, ""));
    }

    public String getRateWithCurrency() {
        return getText().toString().trim();
    }
}
