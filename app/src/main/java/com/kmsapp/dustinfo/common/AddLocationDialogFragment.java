package com.kmsapp.dustinfo.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.kmsapp.dustinfo.R;

public class AddLocationDialogFragment extends DialogFragment {

    private EditText mCicyEditText;

    private OnClickListener mOkClickListener;

    public interface OnClickListener {
        void onOkClicked(String city);
    }

    public void setOnClickListener(OnClickListener listener){
        this.mOkClickListener = listener;
    }

    public static AddLocationDialogFragment newInstance(OnClickListener listener){
        AddLocationDialogFragment fragment = new AddLocationDialogFragment();
        fragment.setOnClickListener(listener);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_add_location, null, false);

        mCicyEditText = view.findViewById(R.id.city_edit);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("위치추가");
        builder.setView(view);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String city = mCicyEditText.getText().toString();
                mOkClickListener.onOkClicked(city);
            }
        });
        builder.setNegativeButton("취소", null);

        return builder.create();
    }
}
