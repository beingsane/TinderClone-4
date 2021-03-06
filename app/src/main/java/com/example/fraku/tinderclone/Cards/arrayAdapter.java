package com.example.fraku.tinderclone.Cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fraku.tinderclone.Cards.Cards;
import com.example.fraku.tinderclone.R;

import java.util.List;

/**
 * Created by Z710 on 2018-02-13.
 */

public class arrayAdapter extends ArrayAdapter<Cards>{

    Context context;

    public arrayAdapter(Context context, int resourceId, List<Cards> items){
        super(context, resourceId, items);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Cards card_item = getItem(position);

        if (convertView == null){
            //Przypisanie pliku xml item
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);

        name.setText(card_item.getName());
        //Pobranie zdjecia i zapisanie go w imageView
        switch(card_item.getProfileImageUrl()){
            case "default":
                //domyslne
                Glide.with(convertView.getContext()).load(R.mipmap.ic_defaultphoto).into(image);
                break;
            default:
                //z Firebase
                Glide.clear(image);
                Glide.with(convertView.getContext()).load(card_item.getProfileImageUrl()).into(image);
                break;
        }


        return convertView;

    }
}
