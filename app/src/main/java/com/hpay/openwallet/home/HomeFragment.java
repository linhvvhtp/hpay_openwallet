package com.hpay.openwallet.home;

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
import com.hpay.openwallet.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    private FragmentHomeBinding fragmentHomeBinding;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHomeBinding fragmentBinding = FragmentHomeBinding.inflate(inflater, container, false);

        fragmentHomeBinding = fragmentBinding;

        getListTransaction();

        Toolbar toolbar = (Toolbar) fragmentHomeBinding.getRoot().findViewById(R.id.toolbar_home);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Navigation.findNavController(fragmentHomeBinding.getRoot()).popBackStack();
            }
        });
        return fragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentHomeBinding.setHomeFragment(this);
    }


    private void getListTransaction() {
        List<TransactionModel> dataModelList = new ArrayList<>();

        dataModelList.add(new TransactionModel("Thanh toan hoa don 1", "1. 200.000đ", "11:50 11-05-2023"));
        dataModelList.add(new TransactionModel("Thanh toan hoa don 2", "2. 200.000đ", "12:50 12-05-2023"));
        dataModelList.add(new TransactionModel("Thanh toan hoa don 3", "3. 200.000đ", "13:50 13-05-2023"));
        dataModelList.add(new TransactionModel("Thanh toan hoa don 4", "4. 200.000đ", "14:50 14-05-2023"));
        dataModelList.add(new TransactionModel("Thanh toan hoa don 5", "5. 200.000đ", "15:50 15-05-2023"));

        Log.d("TransactionRecyclerViewAdapter", "getListTransaction: "+dataModelList.size());

        TransactionRecyclerViewAdapter transactionRecyclerViewAdapter = new TransactionRecyclerViewAdapter(dataModelList, getContext());
        fragmentHomeBinding.setRecyclerViewAdapter(transactionRecyclerViewAdapter);
    }

    public void gotoBankLinkScreen(){
        // Navigate to the next destination to select the flavor of the cupcakes
        Navigation.findNavController(fragmentHomeBinding.getRoot()).navigate(R.id.action_homeFragment_to_bankLinkInfoFragment);
    }

    public void gotoBankAllTransactionScreen(){
        // Navigate to the next destination to select the flavor of the cupcakes
        Navigation.findNavController(fragmentHomeBinding.getRoot()).navigate(R.id.action_homeFragment_to_allTransactionFragment);
    }

}