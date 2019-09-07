package com.example.onboardingscreendesign;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import javax.xml.datatype.Duration;

import static android.view.FrameMetrics.ANIMATION_DURATION;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private sliderAdapter sliderAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotslayout);


        sliderAdapter = new sliderAdapter(this);


        mSlideViewPager.setAdapter(sliderAdapter);
        mSlideViewPager.setCurrentItem(0);
        addDotsIndicater(0);
        mSlideViewPager.addOnPageChangeListener(viewlistener);

        //auto setup timer task

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimer(),1000,2000);




    }

    public void skip(View view) {
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    //setup for auto Image slider with viewPager
    public class MyTimer extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mSlideViewPager.getCurrentItem() == 0){
                        mSlideViewPager.setCurrentItem(1);

                    }else if (mSlideViewPager.getCurrentItem() == 1){
                        mSlideViewPager.setCurrentItem(2);
                    }else {
                        mSlideViewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }




    public void addDotsIndicater(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorWhite));


            mDotLayout.addView(mDots[i]);

        }

        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }


    }
   ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
       @Override
       public void onPageScrolled(int i, float v, int i1) {
       }

       @Override
       public void onPageSelected(int i) {
           addDotsIndicater(i);
       }
       @Override
       public void onPageScrollStateChanged(int i) {

       }

   };

}
