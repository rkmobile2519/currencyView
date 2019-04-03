package com.rk.currencyview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;

import com.rk.libcurrencyview.CurrencyEditText;
import com.rk.libcurrencyview.CurrencyTextView;

public class MainActivity extends AppCompatActivity {

    private static final String currency = "₹";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputFilter[] amountInputFilters = new InputFilter[]{
                new DecimalDigitsInputFilter(10, 3, currency + " ")};

        final CurrencyEditText currency_edt = findViewById(R.id.currency_edt);
        currency_edt.setFilters(amountInputFilters);
        currency_edt.setCurrency(currency);
//        currency_edt.setMaxLimit(999);

        final CurrencyTextView currency_tv = findViewById(R.id.currency_tv);
        currency_tv.setCurrency(currency);

        findViewById(R.id.btnDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currency_tv.setText(currency_edt.getRateWithOutCurrency());
            }
        });
    }
}
