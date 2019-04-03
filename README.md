# currencyView

A view where user can add or view currency with amount. This library provide an editfield  and textview feature both.

EditField -  user have to add only amount and currency will automatically append to start. Validate your amount with last 2 decimal, 3 decimal etc.

TextView : user have to add only amount and currency will automatically append currency synbol to start.

![device20190403143419](https://user-images.githubusercontent.com/48977807/55467267-89a7e480-561e-11e9-9187-a8fced4cc8b7.gif)

# Usage

Step 1 : Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Step 2 : Add the dependency

	dependencies {
	        implementation 'com.github.rkmobile2519:customedittext:1.0.0'
	}


Step 3 : Add edittext to your xml layout.

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:orientation="vertical"
      tools:context=".MainActivity">

        <com.rk.libcurrencyview.CurrencyEditText
            android:id="@+id/currency_edt"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:hint="Enter Amount"
            android:inputType="numberDecimal"
            android:padding="15dp"
            android:textColor="@android:color/black"
            android:textColorHint="@android:color/darker_gray" />

        <Button
            android:id="@+id/btnDone"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="10dp"
            android:text="Done" />

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:orientation="horizontal"
            android:padding="10dp">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginEnd="5dp"
                android:layout_marginRight="5dp"
                android:text="Entered Amount" />

            <com.rk.libcurrencyview.CurrencyTextView
                android:id="@+id/currency_tv"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textColor="@android:color/black"
                tools:text="@string/app_name" />
        </LinearLayout>

    </LinearLayout>

Step 4 : How to set currency

    CurrencyEditText currency_edt = findViewById(R.id.currency_edt);
    currency_edt.setCurrency("₹");
    
    CurrencyTextView currency_tv = findViewById(R.id.currency_tv);
    currency_tv.setCurrency("₹")
    
Step 5 : Methods to get amount

  * currency_edt.getRateWithOutCurrency()
  * currency_edt.getRateWithCurrency()
  
  * currency_tv.getRateWithoutCurrency()
  * currency_tv.getRateWithCurrency()

# Contact
 
 Feel free to contact for any question or bugs:
 
 * Email : rkmobile2519@gmail.com
 
# Licence

Copyright 2019 RKMobile

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License
