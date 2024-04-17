package com.hpay.openwallet.register;

import android.os.Bundle;

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
import com.hpay.openwallet.databinding.FragmentInputOtpBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputOtpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputOtpFragment extends Fragment {

    private FragmentInputOtpBinding fragmentInputOtpBinding;

    private OtpEditText inputOTPEditText;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InputOtpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InputOtpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InputOtpFragment newInstance(String param1, String param2) {
        InputOtpFragment fragment = new InputOtpFragment();
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
        FragmentInputOtpBinding fragmentBinding = FragmentInputOtpBinding.inflate(inflater, container, false);

        fragmentInputOtpBinding = fragmentBinding;

        inputOTPEditText = fragmentInputOtpBinding.getRoot().findViewById(R.id.et_input_otp);

        inputOTPEditText.addTextChangedListener(new TextWatcher() {
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
                    inputOTPEditText.getText().clear();
                    doneInputOTP();
                }
            }
        });

        Toolbar toolbar = (Toolbar) fragmentInputOtpBinding.getRoot().findViewById(R.id.toolbar_input_otp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Navigation.findNavController(fragmentInputOtpBinding.getRoot()).popBackStack();
            }
        });

        return fragmentBinding.getRoot();
    }

    public void doneInputOTP() {
        // Navigate to the next destination to select the flavor of the cupcakes
        Navigation.findNavController(fragmentInputOtpBinding.getRoot()).navigate(R.id.action_inputOtpFragment_to_homeFragment);
    }
}