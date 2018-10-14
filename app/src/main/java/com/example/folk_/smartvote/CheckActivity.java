package com.example.folk_.smartvote;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        Button check = findViewById(R.id.check_b);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText idcard = findViewById(R.id.code_t);
                String IdCode = idcard.getText().toString();
                String print = "";
                if (IdCode.length()==13){
                   if (IdCode.equals("1111111111111")||IdCode.equals("2222222222222")){
                       print = "คุณเป็นผู้มีสิทธิเลือกตั้ง";
                   }
                   else{
                       print= "คุณไม่มีสิทธิเลือกตั้ง";
                   }
                   AlertDialog.Builder dialog = new AlertDialog.Builder(CheckActivity.this);
                    dialog.setTitle("ผลการตรวจสอบสิทธิ์เลือกตั้ง");
                    dialog.setMessage(print);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }
                else if (IdCode.length()!=13){
                    Toast a = Toast.makeText(CheckActivity.this,"กรุณาใส่เลขบัตรประชาชน 13 หลัก",Toast.LENGTH_LONG);
                    a.show();
                }

            }
        });
    }
}
