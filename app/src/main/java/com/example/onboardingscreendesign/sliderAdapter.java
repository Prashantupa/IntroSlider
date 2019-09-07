package com.example.onboardingscreendesign;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class sliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public sliderAdapter(Context context) {
        this.context = context;
    }


    public  int[] slide_images = {
            R.drawable.responsive,
            R.drawable.notepad,
            R.drawable.settings,
    };

    public String[] slide_headings = {
            "Personalize",
            "Introduction",
            "Settings",
    };

    public String[] slide_description = {
            "We are going to Personalize our Images,Text,Dp's,Saved Settings and many more things..by Using our this Amazing Interface",
            "We are going to Personalize our Images,Text,Dp's,Saved Settings and many more things..by Using our this Amazing Interface",
            "We are going to Personalize our Images,Text,Dp's,Saved Settings and many more things..by Using our this Amazing Interface",
    };



    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view,Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView)view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView)view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView)view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_description[position]);

        container.addView(view);

        return view;
    }



    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {

        container.removeView((RelativeLayout)object);
    }
}
