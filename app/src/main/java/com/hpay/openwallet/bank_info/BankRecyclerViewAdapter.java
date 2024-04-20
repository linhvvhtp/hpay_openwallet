package com.hpay.openwallet.bank_info;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.hpay.openwallet.R;
import com.hpay.openwallet.databinding.ItemBankBinding;

import java.util.List;


public class BankRecyclerViewAdapter extends RecyclerView.Adapter<BankRecyclerViewAdapter.ViewHolder> implements BankClickListener {

    private List<BankModel> dataModelList;
    private Context context;

    public BankRecyclerViewAdapter(List<BankModel> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        ItemBankBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_bank, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BankModel bankModel = dataModelList.get(position);
        holder.bind(bankModel);
        holder.itemBankBinding.setItemClickListener(this);
    }


    @Override
    public int getItemCount() {
        return dataModelList.size();
    }



    @Override
    public void cardClicked(BankModel bankModel) {
        Toast.makeText(context, "You clicked " + bankModel.bankName,
                Toast.LENGTH_LONG).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemBankBinding itemBankBinding;

        public ViewHolder(ItemBankBinding itemBankBinding) {
            super(itemBankBinding.getRoot());
            this.itemBankBinding = itemBankBinding;
        }

        public void bind(Object obj) {
            itemBankBinding.setVariable(BR.model, obj);
            itemBankBinding.executePendingBindings();
        }
    }

}


