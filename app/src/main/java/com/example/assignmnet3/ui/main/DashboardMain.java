package com.example.assignmnet3.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.assignmnet3.R;

public class DashboardMain extends AppCompatActivity {

    Button addItem, showItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_act);

        addItem = findViewById(R.id.addItems);
        showItems = findViewById(R.id.showItems);


        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddItemActivity.class));

            }
        });

        showItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ViewItemsAct.class));
            }
        });

    }


}

