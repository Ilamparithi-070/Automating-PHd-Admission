package com.winash.uniapp.ui.Blacklist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.winash.uniapp.AdminCourseView;
import com.winash.uniapp.AdminDashboard;
import com.winash.uniapp.Applicant;
import com.winash.uniapp.R;
import com.winash.uniapp.ui.AddCourse.Course;
import com.winash.uniapp.ui.SearchCourse.SearchCourseAdapter;

import java.util.ArrayList;

public class BlacklistAdapter extends RecyclerView.Adapter<BlacklistAdapter.MyViewHolder> {
    public ArrayList<Applicant> list;
    public Context context;
    public BlacklistAdapter(ArrayList<Applicant> a, Context context){
        this.list=a;
        this.context=context;
    }
    @NonNull
    @Override
    public BlacklistAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.admin_applicant_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlacklistAdapter.MyViewHolder holder, int position) {
        holder.email.setText(list.get(position).getEmail().toString());
        holder.fname.setText(list.get(position).getFname().toString());
        holder.lname.setText(list.get(position).getLname().toString());
        holder.phone.setText(list.get(position).getPhone().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fname,lname,email,phone;
        DatabaseReference db;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fname=itemView.findViewById(R.id.ApplicantNameDisplay);
            lname=itemView.findViewById(R.id.ApplicantlnameDisplay);
            email=itemView.findViewById(R.id.ApplicantEmail);
            phone=itemView.findViewById(R.id.applicantPhone);

            itemView.findViewById(R.id.blacklist_applicant).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db= FirebaseDatabase.getInstance().getReference("Applicant");
                    db.child(list.get(getAdapterPosition()).getApplicantid()).child("black").setValue(true);
                    list.clear();
                    view.getContext().startActivity(new Intent(view.getContext(), AdminDashboard.class));
                }
            });
        }
    }

}
