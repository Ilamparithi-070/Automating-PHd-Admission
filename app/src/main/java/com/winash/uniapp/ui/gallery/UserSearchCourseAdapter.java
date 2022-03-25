package com.winash.uniapp.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.winash.uniapp.ui.AddCourse.Course;
import com.winash.uniapp.R;

import java.io.Serializable;
import java.util.ArrayList;

public class UserSearchCourseAdapter extends RecyclerView.Adapter<UserSearchCourseAdapter.MyViewHolder> {
    public ArrayList<Course> list;
    public Context context;


    public UserSearchCourseAdapter(ArrayList<Course> a, Context context) {
        this.list=a;
        this.context=context;
    }


    public void filterList (ArrayList<Course> filterlist){
        list=filterlist;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.search_card_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Course course=list.get(position);
        holder.coursename.setText(course.getCoursename());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView coursename,campus,syllabus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            coursename=itemView.findViewById(R.id.CourseNameDisplay1);
            itemView.findViewById(R.id.buttoncard1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        Toast.makeText(view.getContext(), "Need to register", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}