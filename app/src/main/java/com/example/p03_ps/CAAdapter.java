package com.example.p03_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CAAdapter extends ArrayAdapter<DailyCA> {
    private ArrayList<DailyCA> dailyCA;
    private Context context;
    private TextView tvGrade;
    private TextView week;
    private TextView tvDG;

    public CAAdapter(Context context, int resource, ArrayList<DailyCA> objects){
        super(context,resource,objects);
        dailyCA = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.dgrow,parent,false);

        DailyCA results = dailyCA.get(position);

        week = rowView.findViewById(R.id.week);
        tvGrade = rowView.findViewById(R.id.tvGrade);

        week.setText("Week " + results.getWeek());
        tvGrade.setText(results.getDgGrade());

        return rowView;
    }
}
