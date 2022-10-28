package com.example.w7_p2;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Adapters extends RecyclerView.Adapter<Adapters.ViewHolder> {


    private ArrayList<Model> modelarr;
    private Context context;

    public Adapters(ArrayList<Model> modelarr, Context context) {
        this.modelarr = modelarr;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewit, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model mod = modelarr.get(position);
        holder.trv.setText(mod.getCst());
        holder.fsv.setText(mod.getCsf());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(context,Update.class);

                i.putExtra("Correct", mod.getCst());
                i.putExtra("Wrong", mod.getCsf());
                context.startActivity(i);
            }
        });
        }

    @Override
    public int getItemCount(){
        return modelarr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView trv,fsv;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            trv = itemView.findViewById(R.id.truew);
            fsv = itemView.findViewById(R.id.falsew);

        }



    }
}

