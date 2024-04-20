package com.hpay.openwallet.bank_info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpay.openwallet.R;
import com.hpay.openwallet.databinding.FragmentBankLinkInfoBinding;
import com.hpay.openwallet.databinding.FragmentHomeBinding;
import com.hpay.openwallet.home.TransactionModel;
import com.hpay.openwallet.home.TransactionRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BankLinkInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BankLinkInfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentBankLinkInfoBinding fragmentBankLinkInfoBinding;

    public BankLinkInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BankLinkInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BankLinkInfoFragment newInstance(String param1, String param2) {
        BankLinkInfoFragment fragment = new BankLinkInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentBankLinkInfoBinding fragmentBinding = FragmentBankLinkInfoBinding.inflate(inflater, container, false);

        fragmentBankLinkInfoBinding = fragmentBinding;

        getListBank();

        Toolbar toolbar = (Toolbar) fragmentBankLinkInfoBinding.getRoot().findViewById(R.id.toolbar_bank_link);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Navigation.findNavController(fragmentBankLinkInfoBinding.getRoot()).popBackStack();
            }
        });

        return fragmentBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentBankLinkInfoBinding.setBankLinkInfoFragment(this);
    }

    private void getListBank() {
        List<BankModel> dataModelList = new ArrayList<>();

        dataModelList.add(new BankModel("BIDV", "97049704", true));
        dataModelList.add(new BankModel("MB", "97049705", false));
        dataModelList.add(new BankModel("VIETIN", "97049706", false));
        dataModelList.add(new BankModel("MSB", "97049707", false));

        Log.d("TransactionRecyclerViewAdapter", "getListTransaction: "+dataModelList.size());

        BankRecyclerViewAdapter bankRecyclerViewAdapter = new BankRecyclerViewAdapter(dataModelList, getContext());
        fragmentBankLinkInfoBinding.setBankRecyclerViewAdapter(bankRecyclerViewAdapter);
    }
}