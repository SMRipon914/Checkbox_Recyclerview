package com.experiencedappbuilder.checkrecy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    public static ArrayList<Model> name;
    Context context;

    public CustomAdapter(Context context, ArrayList<Model> name) {

        this.name = name;
        this.context = context;
    }

    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.MyViewHolder holder, int position) {

       // holder.checkBox.setText("Checkbox " + position);
        holder.checkBox.setChecked(name.get(position).getSelected());
        holder.tvAnimal.setText(name.get(position).getAnimal());

       // holder.checkBox.setTag(R.integer.btnplusview, convertView);
        holder.checkBox.setTag(position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer pos = (Integer) holder.checkBox.getTag();
                Toast.makeText(context, name.get(pos).getAnimal() + " clicked!", Toast.LENGTH_SHORT).show();

                if (name.get(pos).getSelected()) {
                    name.get(pos).setSelected(false);
                } else {
                    name.get(pos).setSelected(true);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        protected CheckBox checkBox;
        private TextView tvAnimal;

        public MyViewHolder(View itemView) {
            super(itemView);

            checkBox = (CheckBox) itemView.findViewById(R.id.cb);
            tvAnimal = (TextView) itemView.findViewById(R.id.animal);
        }

    }
}


