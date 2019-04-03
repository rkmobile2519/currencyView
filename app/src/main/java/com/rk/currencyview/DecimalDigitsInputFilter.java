package com.rk.currencyview;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright © 2018 SynsoftGlobal. All rights reserved.
 */
public class DecimalDigitsInputFilter implements InputFilter {

    private Pattern mPattern;
    private String currency;

    public DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero, String currency) {
        this.currency = currency;
        mPattern = Pattern.compile("[0-9]{0," + digitsBeforeZero + "}+((\\.[0-9]{0," + digitsAfterZero + "})?)||(\\.)?");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String lsStart;
        String lsInsert = "";
        String lsEnd;
        String lsText;
        lsText = dest.toString();

        // If the length is greater then 0, then insert the new character
        // into the original text for validation
        if (lsText.length() > 0) {
            lsStart = lsText.substring(0, dstart);
            // Check to see if they have deleted a character
            if (source != "") {
                lsInsert = source.toString();
            } // if
            lsEnd = lsText.substring(dend);

            lsText = lsStart + lsInsert + lsEnd;
        }

        if (lsText.contains(currency)) {
            lsText = lsText.replace(currency, "");
        }

        Matcher loMatcher = mPattern.matcher(lsText);
        if (!loMatcher.matches()) {
            return "";
        }
        return null;
    }
}


