package com.hpay.openwallet.register;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hpay.openwallet.R;
import com.hpay.openwallet.databinding.FragmentInputPhoneBinding;

public class InputPhoneFragment extends Fragment {

    private InputPhoneViewModel mViewModel;

    private FragmentInputPhoneBinding fragmentInputPhoneBinding;

    public static InputPhoneFragment newInstance() {
        return new InputPhoneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentInputPhoneBinding fragmentBinding = FragmentInputPhoneBinding.inflate(inflater, container, false);

        fragmentInputPhoneBinding = fragmentBinding;
        return fragmentBinding.getRoot();

//        return inflater.inflate(R.layout.fragment_input_phone, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentInputPhoneBinding.setInputPhoneFragment(this);
    }

    public void nextAction(){
        // Navigate to the next destination to select the flavor of the cupcakes
        Navigation.findNavController(fragmentInputPhoneBinding.getRoot()).navigate(R.id.action_inputPhoneFragment_to_inputPasswordFragment);
    }
    public void nextActionIfAccountExits(){
        // Navigate to the next destination to select the flavor of the cupcakes
        Navigation.findNavController(fragmentInputPhoneBinding.getRoot()).navigate(R.id.action_inputPhoneFragment_to_homeFragment);
    }

}