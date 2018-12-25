package com.example.valentinpoisson.embeddedsystem;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by valentinpoisson on 23/12/2018.
 */

public class RVAdapter extends RecyclerView.ViewHolder{

    private TextView textViewView;
    private ImageView imageView;
    public ClipData.Item currentItem;

    //itemView est la vue correspondante à 1 cellule
    public RVAdapter(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView

        textViewView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(MyObject myObject){
        textViewView.setText(myObject.getText());
        Picasso.with(imageView.getContext()).load(myObject.getImageUrl()).centerCrop().fit().into(imageView);
    }

}

class MyAdapter extends RecyclerView.Adapter<RVAdapter> {

    List<MyObject> list;

    //ajouter un constructeur prenant en entrée une liste
    public MyAdapter(List<MyObject> list) {
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public RVAdapter onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.coach_card,viewGroup,false);
        return new RVAdapter(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(RVAdapter myViewHolder, int position) {
        MyObject myObject = list.get(position);
        myViewHolder.bind(myObject);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}

class MyObject {
    private String text;
    private String imageUrl;

    public MyObject(String text, String imageUrl) {
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public String getText(){
        return this.text;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }
}