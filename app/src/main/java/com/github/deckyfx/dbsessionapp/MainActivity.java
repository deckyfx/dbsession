package com.github.deckyfx.dbsessionapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.deckyfx.dbsession.DBSession;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        DBSession dbsession = new DBSession(this, SampleSession.class);
        SampleSession session = dbsession.get();
    }
}
