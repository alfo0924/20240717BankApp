package com.example.a20240717bankapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TWDTransaction extends AppCompatActivity {

    private int currentBalance = 10000; // Initial balance, you can adjust as needed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twdtransaction);

        // Set padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        EditText amountEditText = findViewById(R.id.editTextText);
        Button btnDeposit = findViewById(R.id.button4);
        Button btnWithdraw = findViewById(R.id.button5);
        TextView resultTextView = findViewById(R.id.textView8);

        // Deposit button click listener
        btnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amountEditText.getText().toString().isEmpty()) {
                    resultTextView.setText("請輸入存款金額");
                } else {
                    int depositAmount = Integer.parseInt(amountEditText.getText().toString());
                    currentBalance += depositAmount;
                    resultTextView.setText("存款成功！\n目前餘額：" + currentBalance);
                }
            }
        });

        // Withdraw button click listener
        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amountEditText.getText().toString().isEmpty()) {
                    resultTextView.setText("請輸入提款金額");
                } else {
                    int withdrawAmount = Integer.parseInt(amountEditText.getText().toString());
                    if (withdrawAmount > currentBalance) {
                        resultTextView.setText("餘額不足");
                    } else {
                        currentBalance -= withdrawAmount;
                        resultTextView.setText("提款成功！\n目前餘額：" + currentBalance);
                    }
                }
            }
        });
    }
}