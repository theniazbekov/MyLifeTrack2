package com.example.mylifetrack.ui.fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mylifetrack.R;
import com.example.mylifetrack.databinding.FragmentCreateTaskBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;


public class CreateTaskFragment extends BottomSheetDialogFragment {
    private ViewDialog viewDialog = new ViewDialog();
    private FragmentCreateTaskBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListener();

    }

    private void setListener() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("title", binding.etTask.getText().toString().trim());
                result.putString("regular", binding.tvChooseRegular.getText().toString());
                result.putString("date", binding.tvChooseDate.getText().toString());
                getParentFragmentManager().setFragmentResult("requestKey", result);
                dismiss();
            }
        });
        binding.tvChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog().show();
            }
        });
        binding.tvChooseRegular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDialog.showDialog();
            }
        });
    }

    public DatePickerDialog showDateDialog() {
        final Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog StartTime = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear + 1, dayOfMonth);
                if (monthOfYear < 10) {
                    int month = monthOfYear + 1;
                    binding.tvChooseDate.setText(dayOfMonth + ".0" + month + "." + year);

                }
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        return StartTime;
    }

    public class ViewDialog {

        public void showDialog() {
            final Dialog dialog = new Dialog(requireActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.dialog);
            RadioButton day = (RadioButton) dialog.findViewById(R.id.btn_eDay);
            RadioButton week = (RadioButton) dialog.findViewById(R.id.btn_eWeek);
            RadioButton month = (RadioButton) dialog.findViewById(R.id.btn_eMonth);
            RadioButton year = (RadioButton) dialog.findViewById(R.id.btn_eYear);
            TextView cancel = (TextView) dialog.findViewById(R.id.tv_cancel);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            day.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.tvChooseRegular.setText(day.getText().toString());
                }
            });
            week.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.tvChooseRegular.setText(week.getText().toString());
                }
            });
            month.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.tvChooseRegular.setText(month.getText().toString());
                }
            });
            year.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.tvChooseRegular.setText(year.getText().toString());
                }
            });


            dialog.show();
        }
    }
}
