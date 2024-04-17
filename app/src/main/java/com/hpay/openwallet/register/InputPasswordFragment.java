package com.hpay.openwallet.register;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpay.openwallet.R;
import com.hpay.openwallet.customview.OtpEditText;
import com.hpay.openwallet.databinding.FragmentInputPasswordBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputPasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputPasswordFragment extends Fragment {

    private FragmentInputPasswordBinding fragmentInputPasswordBinding;
    private OtpEditText inputPasswordEditText;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InputPasswordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InputPasswordFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InputPasswordFragment newInstance(String param1, String param2) {
        InputPasswordFragment fragment = new InputPasswordFragment();
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
        FragmentInputPasswordBinding fragmentBinding = FragmentInputPasswordBinding.inflate(inflater, container, false);

        fragmentInputPasswordBinding = fragmentBinding;
        inputPasswordEditText = fragmentInputPasswordBinding.getRoot().findViewById(R.id.et_input_password);

        inputPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void onTextChanged(final CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 6) {
                    Log.d("otpEditText", " otpEditText okie");
                    inputPasswordEditText.getText().clear();
                    doneInputPassword();
                }
            }
        });



        Toolbar toolbar = (Toolbar) fragmentInputPasswordBinding.getRoot().findViewById(R.id.toolbar_inputpass);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Navigation.findNavController(fragmentInputPasswordBinding.getRoot()).popBackStack();
            }
        });

        return fragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentInputPasswordBinding.setInputPasswordFragment(this);
    }

    public void doneInputPassword() {
        // Navigate to the next destination to select the flavor of the cupcakes
        Navigation.findNavController(fragmentInputPasswordBinding.getRoot()).navigate(R.id.action_inputPasswordFragment_to_confirmPasswordFragment);
    }
}