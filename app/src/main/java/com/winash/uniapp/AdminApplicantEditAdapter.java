package com.winash.uniapp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminApplicantEditAdapter extends RecyclerView.Adapter<AdminApplicantEditAdapter.MyViewHolder>{
    ArrayList<ComponentsClass> list;
    Context context;

    public AdminApplicantEditAdapter(Context context, ArrayList<ComponentsClass> items){
        this.context = context;
        this.list = items;
    }

    @NonNull
    @Override
    public AdminApplicantEditAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.admin_add_applicant_components,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,  int position) {
        holder.coursename.setText(list.get(position).getName());
        holder.percentage.setText(list.get(position).getPercentage());



    }
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView coursename,percentage;
        Button b;
        ImageView remove;
        String cn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            coursename = itemView.findViewById(R.id.Component_name_edit_admin);
            percentage = itemView.findViewById(R.id.Component_Marks_edit_admin);
            percentage.setHint("Enter Component marks");
            percentage.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    ComponentsClass c = list.get(getAbsoluteAdapterPosition());
                    c.setPercentage(charSequence.toString());
                    list.set(getAbsoluteAdapterPosition(), c);
                }
                @Override
                public void afterTextChanged(Editable editable) {
                }
            });

        }
    }
}
