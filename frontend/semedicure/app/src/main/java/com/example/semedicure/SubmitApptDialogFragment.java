package com.example.semedicure;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class SubmitApptDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {
        Intent intent = new Intent(getActivity(), PatientPortalActivity.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Bundle bundle = getArguments();
        String selDate = bundle.getString("APPTDATE", "");
        builder.setTitle("Submit Appointment")
                .setMessage("You have set an appointment for " + selDate + ", is this correct?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Appointment Successfully Scheduled", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                });
        return builder.create();
    }

}
