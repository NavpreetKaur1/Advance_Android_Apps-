package com.example.xcode.grocery;


import android.content.Context;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.LinkedList;


    public class GroceryListAdapter
            extends RecyclerView.Adapter<GroceryListAdapter.GroceryViewHolder> {

        private final LinkedList<Object> mGroceryList;
        private final LayoutInflater mInflater;

        class GroceryViewHolder extends RecyclerView.ViewHolder {
//                implements View.OnClickListener {

            public final TextView wordItemView;
            final GroceryListAdapter gAdapter;

            public GroceryViewHolder(View itemView, GroceryListAdapter adapter) {
                super(itemView);

                CardView cv;
                TextView vegetable_name;
                TextView vegetable_price;
                TextView vegetable_quantity;
                TextView vegetable_weight;
                ImageView vegetable_image;

                cv = (CardView) itemView.findViewById(R.id.cv);
                vegetable_name = (TextView) itemView.findViewById(R.id.vegetable_name);
                vegetable_price = (TextView) itemView.findViewById(R.id.vegetable_price);
                vegetable_image = (ImageView) itemView.findViewById(R.id.vegetable_photo);
                vegetable_quantity = (TextView) itemView.findViewById(R.id.vegetable_quantity);
                vegetable_weight = (TextView) itemView.findViewById(R.id.vegetable_weight);


                wordItemView = itemView.findViewById(R.id.vegetable_name);
                this.gAdapter = adapter;
            }

        }

        public GroceryListAdapter(Context context, LinkedList<Object> wordList) {
            mInflater = LayoutInflater.from(context);
            this.mGroceryList = wordList;
        }


        @Override
            public GroceryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Inflate an item view.
            View itemView = mInflater.inflate(R.layout.grocerylist_item, parent, false);
            return new GroceryViewHolder(itemView, this);
        }

        /**
         * Sets the contents of an item at a given position in the RecyclerView.
         *
         * @param holder   The view holder for that position in the RecyclerView.
         * @param position The position of the item in the RecycerView.
         */
        @Override
        public void onBindViewHolder(GroceryViewHolder holder, int position) {
            // Retrieve the data for that position.
            String current = mGroceryList.get(position).toString();

            // Add the data to the view holder.
            holder.wordItemView.setText(current);
        }

        /**
         * Returns the size of the container that holds the data.
         *
         * @return Size of the list of data.
         */
        @Override
        public int getItemCount() {
            return mGroceryList.size();
        }

    }
