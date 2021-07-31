package com.android.example.droidcafe;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView textView = findViewById(R.id.order_textview);
        textView.setText(getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));

        RadioButton nextDay = findViewById(R.id.nextday);
        nextDay.setChecked(true);

        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    } // onClick()

    public void onRadioButtonClicked(View view) {
        RadioButton clickedButton = (RadioButton) view;
        if (clickedButton.getId() == R.id.sameday) {
            displayToast(getString(R.string.same_day_messenger_service));
        } else if (clickedButton.getId() == R.id.nextday) {
            displayToast(getString(R.string.next_day_ground_delivery));
        } else if (clickedButton.getId() == R.id.pickup) {
            displayToast(getString(R.string.pick_up));
        }
    } // onRadioButtonClicked()

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(@NonNull AdapterView adapter, View view, int i, long l) {
        String spinnerLabel = adapter.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(@NonNull AdapterView adapter) {

    }
}