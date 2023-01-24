package com.example.recyclerview_layerout;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtName,etdAge,edtGrade,edtAddress,edtDistance;
    Button View, Add;
    List<Students> StudentsList = new ArrayList<>();
    RecyclerView StudentRV;
    StudentAdapter studentAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName =findViewById(R.id.edt_Name);
        etdAge = findViewById(R.id.edt_Age);
        edtGrade = findViewById(R.id.edt_Grade);
        edtAddress = findViewById(R.id.edt_Address);
        edtDistance = findViewById(R.id.edt_distance);

        View =findViewById(R.id.add_btn);
        Add = findViewById(R.id.view_btn);




        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                Students student1 = new Students();

                student1.name = edtName.getText().toString();
                student1.age = Integer.parseInt(etdAge.getText().toString());
                student1.Grade = Integer.parseInt(edtGrade.getText().toString());
                student1.address = edtAddress.getText().toString();
                student1.Distance = Double.parseDouble(edtDistance.getText().toString());
                StudentsList.add(student1);

                Toast.makeText(MainActivity.this,"data is saved",Toast.LENGTH_LONG).show();

            }
        });


        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                StudentRV = findViewById(R.id.Student_recycler);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
                StudentRV.setLayoutManager(layoutManager);


                studentAdapter = new StudentAdapter(StudentsList);
                StudentRV.setAdapter(studentAdapter);





            }
        });




    }
}