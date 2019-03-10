package com.cheezycode.quotify;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder> {

    List<String> quotes = null;
    Context context;

    public QuotesAdapter(List<String> quotes, Context context) {
        this.quotes = quotes;
        this.context = context;
    }

    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_quote, viewGroup, false);
        return new QuotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewHolder quotesViewHolder, int i) {
        String[] colors = {"#448AFF", "#FFC107", "#009688", "#E91E63", "#FF5722"};
        final String quote = quotes.get(i);
        quotesViewHolder.txtQuote.setText(quote);
        int color = i % colors.length;
        final int intColor = Color.parseColor(colors[color]);
        quotesViewHolder.quoteContainer.setBackgroundColor(intColor);

    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder {

        TextView txtQuote;
        LinearLayout quoteContainer;

        public QuotesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtQuote = itemView.findViewById(R.id.txtQuote);
            quoteContainer = itemView.findViewById(R.id.quoteContainer);
        }
    }
}
