package com.erodev.pointsaccrual;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



import java.util.List;


public class AcrualRecyclerViewAdapter extends RecyclerView.Adapter<AcrualRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Employee> mEmployee;

    PrefManager prefManager;




    public AcrualRecyclerViewAdapter(Context mContext, List<Employee> mEmployee) {
        this.mContext = mContext;
        this.mEmployee = mEmployee;
    }


    @Override
    public AcrualRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater= LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.list_points,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AcrualRecyclerViewAdapter.MyViewHolder holder, final int position) {

        PointsComputation pc=new PointsComputation();
        Double points = pc.calculatePoints(mEmployee.get(position).getEmpdate(), mEmployee.get(position).getSeniority());

        holder.tvempid.setText(Integer.toString(mEmployee.get(position).getEmpid()));


        holder.tvpoints.setText(Double.toString(points));
        holder.tvempname.setText(mEmployee.get(position).getEmpname());

        holder.btnwithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefManager = new PrefManager(mContext);
                if (!prefManager.isFirstTimeLaunch()) {
                    Intent intent = new Intent(mContext,Withdraw.class);
                    intent.putExtra("empposition", String.valueOf(mEmployee.get(position)));
                    intent.putExtra("Name", mEmployee.get(position).getEmpname());
                    mContext.startActivity(intent);


                }else {
                    Intent login = new Intent(mContext, LoginActivity.class);
                    mContext.startActivity(login);
                }
            }
        });



    }



    @Override
    public int getItemCount() {
            return mEmployee.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvempid,tvpoints, tvempname;
        Button btnwithdraw;



        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);

            tvempid = itemView.findViewById(R.id.tvempid);
            tvpoints = itemView.findViewById(R.id.tvpointsno);
            tvempname = itemView.findViewById(R.id.tvempname);
            btnwithdraw = itemView.findViewById(R.id.btnwithdraw);
            cardView = itemView.findViewById(R.id.cardview_id);


        }
    }



}
