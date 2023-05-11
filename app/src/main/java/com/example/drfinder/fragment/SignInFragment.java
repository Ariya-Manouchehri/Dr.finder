package com.example.drfinder.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.drfinder.activity.DetailsActivity;
import com.example.drfinder.R;
import com.example.drfinder.backend.BackEnd;
import com.example.drfinder.databinding.FragmentSignInBinding;
import com.example.drfinder.viewmodel.SignUpSignInViewModel;

public class SignInFragment extends Fragment {
    FragmentSignInBinding binding;
    SignUpSignInViewModel viewModel;

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SignInFragmentEventListener listener = new SignInFragmentEventListener();
        viewModel = new ViewModelProvider(getActivity()).get(SignUpSignInViewModel.class);
        binding.setListener(listener);
        binding.setViewBackend(viewModel);
    }

    public class SignInFragmentEventListener {
        public void goToSignupFragment(View view) {
            Navigation.findNavController(view).navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment());
        }

        public void goToDetailsFragment(View view, SignUpSignInViewModel viewBackend) {
            viewBackend.signInButtonPressed(binding.inputUsername.getText().toString(), binding.inputPassword.getText().toString()).observe(getViewLifecycleOwner(), new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    switch (integer) {
                        case -1:
                            Toast.makeText(getActivity(), "لطفا نام خود را به صورت صحیح وارد کنید.", Toast.LENGTH_SHORT).show();
                            break;
                        case 0:
                            Toast.makeText(getActivity(), "لطفا رمز عبور خود را به صورت صحیح وارد کنید.", Toast.LENGTH_SHORT).show();
                            break;
                        case -2:
                            Toast.makeText(getActivity(), "کاربری یافت نشد.", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Intent intent = new Intent(getActivity(), DetailsActivity.class);
                            intent.putExtra("username",binding.inputUsername.getText().toString());
                            intent.putExtra("password",binding.inputPassword.getText().toString());
                            startActivity(intent);
                            getActivity().finish();
                            break;
                    }
                }
            });
        }
    }
}