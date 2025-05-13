package com.example.contactosapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    TextView txvName;
    TextView txvPhone;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        txvName = findViewById(R.id.txvName);
        txvPhone = findViewById(R.id.txvPhone);

        ContactStore contactStore = new ContactStore();

        String phoneNumber = getIntent().getStringExtra(BundleConstant.CONTACT_PHONE);
        if (phoneNumber != null) {

            contactStore = new ContactStore();
            contact = contactStore.findContactByPhone(phoneNumber);

            txvPhone.setText(contact.getPhone());
            txvName.setText(contact.getName());
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txvName), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

}
