package com.example.triviaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
// creating list for dsplaying history
public class ListAdapter extends ArrayAdapter<Player>
{
    private Context context;
    List<Player> players;


// this constructer will connect the xml file too java program
    public ListAdapter(Context c, List<Player> p){
        super(c,R.layout.list,p);

        this.context=c;
        this.players=p;

    }

//to get view from another layout resource file
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView= inflater.inflate(R.layout.list,parent,false);
        TextView tvtime= convertView.findViewById(R.id.tvtime);
        TextView tvname= convertView.findViewById(R.id.tvname);
        TextView tvplayer= convertView.findViewById(R.id.tvplayer);
        TextView tvflag= convertView.findViewById(R.id.tvflag);

        tvtime.setText("Game 1 : "+players.get(position).getDate());
        tvname.setText("Name " + players.get(position).getName());
        tvplayer.setText("Answer " +players.get(position).getCric());
        tvflag.setText("Answer " +players.get(position).getFlag());
        return convertView;
    }
}
