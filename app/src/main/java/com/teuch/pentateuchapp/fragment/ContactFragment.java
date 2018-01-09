package com.teuch.pentateuchapp.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.model.MarkerOptions;
import com.teuch.pentateuchapp.R;
import com.teuch.pentateuchapp.activity.MainActivity;
import com.teuch.pentateuchapp.activity.MapsActivity;


public class ContactFragment extends Fragment {
    private Button button1, button2, button3, button4, button5;
 private View rootview;
     Context context;
    public ContactFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_contact, container, false);
        button1 = (Button)rootview.findViewById(R.id.btn1);
        button2 = (Button)rootview.findViewById(R.id.btn2);
        button3 = (Button) rootview.findViewById(R.id.btn3);
        button4 = (Button)rootview.findViewById(R.id.btn4);
        button5 = (Button) rootview.findViewById(R.id.btn5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                String[] to={"jonah@pentateuch.in"};
                email.putExtra(Intent.EXTRA_EMAIL, to);
                email.putExtra(Intent.EXTRA_SUBJECT, "hi");
                email.putExtra(Intent.EXTRA_TEXT, "message");

                //need this to prompts email client only
                email.setType("message/rfc822");
                 startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com")));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://l.facebook.com/l.php?u=https%3A%2F%2Fwww.linkedin.com%2Fin%2Fjonah-bhasme-26b4684&h=ATNYsge-RhsQaiUQpUZhboCFR08GnN928nVXGsw50J6PKl1_KzApPTkFNnIiwDeqJuC_LvoSeq3_Ufj-quJ8ztY_gXDsftktW99x2ytjLsrEY9KK_pqiBdZy76zsRwUj_SmuKDmjQxZctg")));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:08023240477"));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:12.951678,77.492052?q=12.951678,77.492052(PENTATEUCH TECHNOLOGIES)"));
                startActivity(intent);

            }
        });
           return rootview;
    }
    }


