package com.example.dailynote10117003.info;

//5-Juni-2021. Achmad Zhaki - 10117003 - IF8

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailynote10117003.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {

    private List<Onboardingitem> onboardingitems;

    public OnboardingAdapter(List<Onboardingitem> onboardingitems) {
        this.onboardingitems = onboardingitems;
    }

    @NotNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_onboarding, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OnboardingAdapter.OnboardingViewHolder holder, int position) {
        holder.setOnboardingData(onboardingitems.get(position));
    }

    @Override
    public int getItemCount() {
        return onboardingitems.size();
    }

    class  OnboardingViewHolder extends RecyclerView.ViewHolder{

        private TextView textTitle, textDescription;
        private ImageView imageOnboarding;

        OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageOnboarding = itemView.findViewById(R.id.imageOnboarding);
        }

        void setOnboardingData(Onboardingitem onboardingitem){
            textTitle.setText(onboardingitem.getTitle());
            textDescription.setText(onboardingitem.getDescription());
            imageOnboarding.setImageResource(onboardingitem.getImage());
        }
    }
}

