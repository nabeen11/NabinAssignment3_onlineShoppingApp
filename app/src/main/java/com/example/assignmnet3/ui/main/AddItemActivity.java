package com.example.assignmnet3.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.assignmnet3.R;

import java.io.IOException;
import java.io.PrintStream;

public class AddItemActivity extends AppCompatActivity {

    private EditText name, price, imageName, description;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nabin_add_items);

        name = findViewById(R.id.etName);
        price = findViewById(R.id.etPrice);
        imageName = findViewById(R.id.etImageName);
        description = findViewById(R.id.etDescription);
        add = findViewById(R.id.btnAddItem);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    public void addItem(){
        try{
            PrintStream printStream = new PrintStream(openFileOutput("items.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(name.getText().toString() + "->"+ price.getText().toString()
                    + "->"+ imageName.getText().toString()+"->"+ description.getText().toString());
            Toast.makeText(this, "Saved to "+ getFilesDir(), Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Log.d("check", "Error: " + e.toString());
            e.printStackTrace();
        }
    }
}

