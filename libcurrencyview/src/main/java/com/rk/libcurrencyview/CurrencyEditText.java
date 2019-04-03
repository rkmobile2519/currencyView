package com.rk.libcurrencyview;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;

public class CurrencyEditText extends AppCompatEditText {

    private CurrencyEditText editText = CurrencyEditText.this;
    private double maxLimit;
    private String strCurrency = "";

    public CurrencyEditText(Context context) {
        super(context);
        init();
    }

    public CurrencyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CurrencyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    String lsText = editable.toString();
                    editText.removeTextChangedListener(this);
                    if (lsText.equalsIgnoreCase(strCurrency)) {
                        editText.setText("");
                        editText.addTextChangedListener(this);
                        return;
                    }

                    if (lsText.contains(strCurrency)) {
                        lsText = lsText.replace(strCurrency, "").trim();
                    }

                    StringBuilder stringBuilder = new StringBuilder();
                    // If the length is greater then 0, then insert the new character
                    // into the original text for validation
                    if (lsText.length() > 0) {
                        if (!stringBuilder.toString().contains(strCurrency)) {
                            stringBuilder.append(strCurrency).append(" ");
                        }
                        if (maxLimit != 0 && Double.valueOf(lsText) > maxLimit) {
                            editText.setText("");
                            editText.addTextChangedListener(this);
                            return;
                        }
                        stringBuilder.append(lsText);
                    }

                    editText.setText(stringBuilder.toString());
                    Selection.setSelection(editText.getText(), editText.getText().length());

                    editText.addTextChangedListener(this);
                }
            }
        });
    }

    public double getRateWithOutCurrency() {
        if (isNullOrEmpty(getText().toString().trim())) {
            return 0;
        } else {
            String amount = getText().toString().trim().replace(strCurrency, "");
            if (amount.equals(".")) {
                return 0;
            } else {
                return Double.parseDouble(amount);
            }
        }
    }

    public String getRateWithCurrency() {
        String amount = getText().toString().trim();
        if (amount.equals(".")) {
            return strCurrency + 0;
        } else {
            return isNullOrEmpty(amount) ? strCurrency + 0 : amount;
        }
    }

    public void setCurrency(String currencySymbol) {
        this.strCurrency = currencySymbol;
    }

    public void setMaxLimit(double maxLimit) {
        this.maxLimit = maxLimit;
    }

    private boolean isNullOrEmpty(String s) {
        //return (s == null) || (s.length() == 0) || (s.equalsIgnoreCase("null"));
        if (s == null)
            return true;
        if (s.length() == 0)
            return true;
        return s.equalsIgnoreCase("null");
    }
}
