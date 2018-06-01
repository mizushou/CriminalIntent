package com.example.shouhei.criminaintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.security.MessageDigest;
import java.time.LocalDate;

public class DatePickerFragment extends DialogFragment {

  public static final String EXTRA_DATE = "com.example.shouhei.criminalintent.date";

  private static final String ARG_DATE = "date";

  private DatePicker mDatePicker;

  // use LocalDate insteadof Date because Crime model has LocalDate attribute.
  public static DatePickerFragment newInstance(LocalDate date) {
    Bundle args = new Bundle();
    args.putSerializable(ARG_DATE, date);

    DatePickerFragment fragment = new DatePickerFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    LocalDate date = (LocalDate) getArguments().getSerializable(ARG_DATE);

    int year = date.getYear();
    int month = date.getMonthValue() - 1;
    int day = date.getDayOfMonth();
    View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);

    mDatePicker = v.findViewById(R.id.dialog_date_picker);
    mDatePicker.init(year, month, day, null);

    return new AlertDialog.Builder(getActivity())
        .setView(v)
        .setTitle(R.string.date_picker_title)
        //        .setPositiveButton(android.R.string.ok, null)
        .setPositiveButton(
            android.R.string.ok,
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                int year = mDatePicker.getYear();
                int month = mDatePicker.getMonth() + 1;
                int day = mDatePicker.getDayOfMonth();
                LocalDate date = LocalDate.of(year, month, day);
                sendResult(Activity.RESULT_OK, date);
              }
            })
        .create();
  }

  private void sendResult(int resultCode, LocalDate date) {
    if (getTargetFragment() == null) {
      return;
    }

    Intent intent = new Intent();
    intent.putExtra(EXTRA_DATE, date);

    getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
  }
}
