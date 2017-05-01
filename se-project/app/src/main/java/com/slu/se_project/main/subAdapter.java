package com.slu.se_project.main;

import android.animation.ValueAnimator;
import android.content.Context;
import android.media.Image;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.slu.se_project.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sean on 4/20/2017.
 */

public class subAdapter extends RecyclerView.Adapter<subAdapter.ViewHolder> {


    private List<card_data> data;
    int maxHeight = 200;
    int minHeight;
    int height;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView label,time;
        LinearLayout expandedContent;
        ImageView icon;
        ImageButton expand;
        private boolean isExpanded =false;
        private int originalHeight = 0, expandedHeight = 0;

        ViewHolder(final View itemView){
            super(itemView);
            label = (TextView)itemView.findViewById(R.id.label);
            time = (TextView)itemView.findViewById(R.id.time);
            icon = (ImageView)itemView.findViewById(R.id.icon);
            expand = (ImageButton) itemView.findViewById(R.id.expand);
            expandedContent = (LinearLayout) itemView.findViewById(R.id.expanded_content);


            expand.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    if(originalHeight == 0){
                        originalHeight = itemView.getHeight();
                        Log.v("View Height", "equals: "+ v.getHeight());
                        List<String> expandables = data.get(getAdapterPosition()).getExpandables();

                        if(expandables != null){
                            for(int i=0; i<expandables.size(); i++){
                                TextView t = new TextView(itemView.getContext());
                                t.setText(expandables.get(i));
                                t.setId(i);
                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                                expandedContent.addView(t, params);

                            }
                        }


                        expandedContent.setVisibility(View.VISIBLE);
                        expandedContent.setEnabled(true);
                        expandedContent.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        expandedHeight = expandedContent.getMeasuredHeight();
                    }
                    ValueAnimator anim;

                    if(!isExpanded){
                        expandedContent.setVisibility(View.VISIBLE);
                        expandedContent.setEnabled(true);
                        isExpanded = true;
                        anim = ValueAnimator.ofInt(originalHeight, originalHeight*2);
                        v.findViewById(R.id.expand).setBackgroundResource(R.drawable.ic_expand_less_36pt);
                    }else {
                        isExpanded = false;
                        v.findViewById(R.id.expand).setBackgroundResource(R.drawable.ic_expand_more_36pt);
                        anim = ValueAnimator.ofInt(originalHeight*2, originalHeight);
                        Animation a = new AlphaAnimation(1.00f, 0.00f);

                        a.setDuration(200);
                        a.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {

                            expandedContent.setVisibility(View.GONE);
                            expandedContent.setEnabled(false);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        itemView.startAnimation(a);
                    }
                    anim.setDuration(200);
                    anim.setInterpolator(new AccelerateDecelerateInterpolator());
                    anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            Integer value = (Integer) animation.getAnimatedValue();
                            itemView.getLayoutParams().height = value;
                            itemView.requestLayout();
                        }
                    });
                    anim.start();
                }
            });
        }
    }

    @Override
    public subAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_event, viewGroup, false);
        subAdapter.ViewHolder vh = new subAdapter.ViewHolder(v);
        height = v.getHeight();

        return vh;
    }
    @Override
    public void onBindViewHolder(subAdapter.ViewHolder ViewHolder, int i) {
        card_data day_events = data.get(i);

        ViewHolder.icon.setImageResource(day_events.getImgUrl());
        ViewHolder.label.setText(day_events.getLabel());
        ViewHolder.time.setText(day_events.getTime());
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    subAdapter(List<card_data> data){
        this.data = data;
        Collections.sort(data, new DateComparator());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}

