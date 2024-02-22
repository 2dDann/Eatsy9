package com.example.eatsy9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HelpCenterAdapter extends RecyclerView.Adapter<HelpCenterAdapter.ViewHolder> {

    private List<HelpItem> helpItems;

    public HelpCenterAdapter(List<HelpItem> helpItems) {
        this.helpItems = helpItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_help_center, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(helpItems.get(position));
    }

    @Override
    public int getItemCount() {
        return helpItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView helpItemTextView;
        TextView extraInfoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            helpItemTextView = itemView.findViewById(R.id.helpItemTextView);
            extraInfoTextView = itemView.findViewById(R.id.extraInfoTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toggle visibility of extraInfoTextView when item is clicked
                    extraInfoTextView.setVisibility(extraInfoTextView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                }
            });
        }

        public void bind(HelpItem helpItem) {
            helpItemTextView.setText(helpItem.getTitle());
            extraInfoTextView.setText(helpItem.getExtraInfo());
            // Set extraInfoTextView visibility initially to GONE
            extraInfoTextView.setVisibility(View.GONE);
        }
    }
}
