package com.example.codeelevate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    String data[];
    Context context;
    View view;
    String language_name;

    public RecyclerAdapter(Context context,String[] data, String language_name) {
        this.data = data;
        this.context = context;
        this.language_name = language_name;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.custom_design,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        holder.button.setText(data[position]);
        String pos = Integer.toString(position+1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), C_Plus_Plus_Lessons.class);
                intent.putExtra("L_name", language_name);
                intent.putExtra("Lesson_name", pos);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView button;


        public ViewHolder(View itemView) {
            super(itemView);

            button= itemView.findViewById(R.id.lessson_button);


        }
    }
}
