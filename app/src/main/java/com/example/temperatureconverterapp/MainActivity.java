package com.example.temperatureconverterapp;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;//ForAndroid Studio 3.5 Version
import java.text.DecimalFormat; //For Older APIs
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private EditText tempEditText;
    private Button celButton;
    private Button fButton;
    private TextView showTempTextView;

    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText) findViewById(R.id.editTextID);
        celButton = (Button) findViewById(R.id.buttonID1);
        fButton = (Button) findViewById(R.id.buttonID2);
        showTempTextView = (TextView) findViewById(R.id.textView3);

        celButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //call convertToCelsius()
                String editTextVal = tempEditText.getText().toString();
                if (editTextVal.isEmpty()){
                    // display a short message to the screen if things go wrong
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                }else {
                    // we are good 16
                    double intEditText = Double.parseDouble(editTextVal);
                    // put the returned value into a variable so wecan use it (make things organized)
                    double convertedVal = convertToCelsius(intEditText);
                    //use the String.valueOf() method to convert our double value into it's corresponding string format so we can out put it
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + " C ");
                }
            }
        });
        fButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //call convertToFahrenheit()
                String editTextVal = tempEditText.getText().toString();
                if (editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }else {
                    // all is good
                    double doubleEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToFahrenheit(doubleEditText);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + " F");
                }
            }
        });
    }

    public double convertToCelsius(double farVal){
        // c--> From Fahrenheit to celsius
        double resultCel;
        resultCel = (farVal - 32) * 5/9;
        return resultCel;
    }
    public double convertToFahrenheit(double celVal){
        // [y°F] = ([y°C] * 9/5) + 32 --> From Celsius toFahrenheit
        double resultFahr;
        resultFahr = (celVal * 9/5) + 32;
        return resultFahr;
    }


}