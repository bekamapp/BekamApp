package com.bekamapp.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bekamapp.Adapter;
import com.bekamapp.MainActivity;
import com.bekamapp.R;
import com.bekamapp.Vendor.AddProductActivity;
import com.bekamapp.Vendor.MyProductsActivity;
import com.bekamapp.Vendor.MyProfileActivityVendor;
import com.google.firebase.auth.FirebaseAuth;

public class MyProfileActivityUser extends AppCompatActivity {

    FirebaseAuth auth;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_my_profile_activity_user);

        listView =(ListView)findViewById(R.id.lv_user_profile);
        String []content={"My Reviews","Edit My Profile","LogOut"};
        Adapter adapter = new Adapter(this, content);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(MyProfileActivityUser.this, MyProductsActivity.class)); //hn3'yr dy,, hyft7 el reviews bt3to
                        break;
                    case 1:
                        startActivity(new Intent(MyProfileActivityUser.this, MyProductsActivity.class)); //hn3'er el profile elly hytft7,, ana 3mlah dlw2ty ay 7aga
                        break;
                    case 2:
                        auth = FirebaseAuth.getInstance();
                        auth.signOut();
                        startActivity(new Intent(MyProfileActivityUser.this, MainActivity.class));
                        break;
                }
            }
        });
    }
}
