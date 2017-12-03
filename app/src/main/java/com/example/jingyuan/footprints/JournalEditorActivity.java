package com.example.jingyuan.footprints;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class JournalEditorActivity extends AppCompatActivity {

    private static final String JOURNAL_OBJECT = "journalObj";
    private static final int JOURNAL_EDITOR_REQ = 1;
    private EditText et_title;
    private EditText et_content;
    private TextView tv_date;
    private FloatingActionButton fab_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_editor);

        // Initialization
        initialization();

        // Get intent
        Intent intent = getIntent();
        Journal j = (Journal) intent.getSerializableExtra(JOURNAL_OBJECT);
        // TODO: edit journal if j != null
        Log.v("Journal Editor", "journal: " + j);
        if (j != null) {
            et_title.setText(j.getTitle());
            et_content.setText(j.getContent());
        }

        // Set date
        String[] date = Calendar.getInstance().getTime().toString().split(" ");
        TextView tv_date = (TextView) findViewById(R.id.textView_date);
        tv_date.setText(date[0] + ", " + date[1] + " " + date[2] + ", " + date[5]);
    }

    private void initialization() {
        et_title = (EditText) findViewById(R.id.editText_title);
        et_content = (EditText) findViewById(R.id.editText_content);
        fab_save = (FloatingActionButton) findViewById(R.id.floatingActionButton_save);

        // Set save button and image button
        // TODO: set image button add photo
        fab_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: set return value (save to database)
                Intent intent = new Intent(JournalEditorActivity.this, MainActivity.class);
//                intent.putExtra("addPerson", add);
//                intent.putExtra("size", relation.size());

                setResult(JOURNAL_EDITOR_REQ, intent);
                finish();
            }
        });
    }
}