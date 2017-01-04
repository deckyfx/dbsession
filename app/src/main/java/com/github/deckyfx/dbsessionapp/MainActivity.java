package com.github.deckyfx.dbsessionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.deckyfx.dbsession.DBSession;
import com.github.deckyfx.dbsessionapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        DBSession dbsession = new DBSession(this, SampleSession.class);
        SampleSession session = dbsession.get();
    }
}
