package com.example.assignmnet3.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.example.assignmnet3.Adapter.ItemAdapter;
import com.example.assignmnet3.R;
import com.example.assignmnet3.models.Item;


public class ViewItemsAct extends AppCompatActivity {
        private RecyclerView recyclerView;
        List<Item> itemsList = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.item_view);

            recyclerView = findViewById(R.id.recyclerview);

            readItems();

            recyclerView.setAdapter(new ItemAdapter(getApplicationContext(),itemsList));
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }

        private void readItems() {
            try {
                FileInputStream fos=openFileInput("items.txt");
                InputStreamReader isr=new InputStreamReader(fos);

                BufferedReader br=new BufferedReader(isr);
                String line="";

                while ((line=br.readLine()) != null){
                    String[] parts = line.split("->");
                    String imgDrawagble =parts[2];
                    int id=getResources().getIdentifier(imgDrawagble,"drawable",getPackageName());
                    itemsList.add(new Item(parts[0],parts[1],parts[2],parts[3],id));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



