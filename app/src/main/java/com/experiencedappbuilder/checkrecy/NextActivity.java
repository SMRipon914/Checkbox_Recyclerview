package com.experiencedappbuilder.checkrecy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        textView =findViewById(R.id.textView);

        for (int i = 0; i < CustomAdapter.name.size(); i++){
            if(CustomAdapter.name.get(i).getSelected()) {
                textView.setText(textView.getText() + "\n" + CustomAdapter.name.get(i).getAnimal());
            }
        }
    }
}
