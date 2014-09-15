package com.jillberthestillore.chikadora.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.InjectView;
import butterknife.OnClick;

import com.jillberthestillore.chikadora.R;

public class LoginFragment extends BaseFragment {

	@InjectView(R.id.username)
	protected EditText username;
	
	@InjectView(R.id.password)
	protected EditText password;
	
	@OnClick(R.id.login)
	public void login() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_login, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}
	
}
