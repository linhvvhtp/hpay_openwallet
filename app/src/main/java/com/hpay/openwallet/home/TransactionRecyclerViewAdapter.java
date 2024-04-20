package com.hpay.openwallet.home;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.hpay.openwallet.R;
import com.hpay.openwallet.databinding.ItemTransactionBinding;

import java.util.List;

public class TransactionRecyclerViewAdapter extends RecyclerView.Adapter<TransactionRecyclerViewAdapter.ViewHolder> implements  CustomClickListener {

    private List<TransactionModel> transactionModels;
    private Context context;

    public TransactionRecyclerViewAdapter(List<TransactionModel> transactionModels, Context ctx) {
        Log.d("TransactionRecyclerViewAdapter", "TransactionRecyclerViewAdapter constructor");
        this.transactionModels = transactionModels;
        context = ctx;
    }

    @Override
    public TransactionRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                        int viewType) {
        ItemTransactionBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_transaction, parent, false);

        Log.d("TransactionRecyclerViewAdapter", "onCreateViewHolder");

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TransactionModel transactionModel = transactionModels.get(position);
//        holder.itemTransactionBinding.setModel(transactionModel);
        holder.bind(transactionModel);
        holder.itemTransactionBinding.setItemClickListener(this);
    }


    @Override
    public int getItemCount() {
        Log.d("TransactionRecyclerViewAdapter", "TransactionRecyclerViewAdapter: "+transactionModels.size());
        return transactionModels.size();
    }

    @Override
    public void cardClicked(TransactionModel f) {
        Log.d("TransactionRecyclerViewAdapter", "CARDCLICK");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemTransactionBinding itemTransactionBinding;

        public ViewHolder(ItemTransactionBinding itemTransactionBinding) {
            super(itemTransactionBinding.getRoot());
            this.itemTransactionBinding = itemTransactionBinding;
        }

        public void bind(Object obj) {
            itemTransactionBinding.setVariable(BR.model, obj);
            itemTransactionBinding.executePendingBindings();
        }
    }

}
