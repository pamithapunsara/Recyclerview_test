package com.example.recyclerview_layerout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    Context context;
    List<Students> StudentsList;

    public StudentAdapter(List<Students> studentsList) {
        this.StudentsList = studentsList;


    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =  LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.student_card,parent,false);
        return new StudentAdapter.StudentViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {

        Students student1 = StudentsList.get(position);

        holder.name.setText(student1.name);
        holder.age.setText(student1.age +"years old");
        holder.grade.setText(student1.Grade+ "");
        holder.address.setText(student1.address);
        holder.distance.setText(student1.Distance +" km");


    }

    @Override
    public int getItemCount() {

        return StudentsList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView name, age, grade, address, distance;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.edt_Name);
            age = itemView.findViewById(R.id.edt_Age);
            grade = itemView.findViewById(R.id.edt_Grade);
            address = itemView.findViewById(R.id.edt_Address);
            distance = itemView.findViewById(R.id.edt_distance);
        }
    }
}
