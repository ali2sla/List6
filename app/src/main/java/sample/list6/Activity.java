package sample.list6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;

public class Activity extends AppCompatActivity {
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        TextView questionList = findViewById(R.id.questionList);
        TextView question = findViewById(R.id.question);
        EditText bottomTextField = findViewById(R.id.bottomTextField);
        Button backButton = findViewById(R.id.backButton);
        Button nextButton = findViewById(R.id.nextButton);
        Button submitButton = findViewById(R.id.submitButton);

        ListView bottomListView = findViewById(R.id.responses);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        bottomListView.setAdapter(arrayAdapter);

        controller = new Controller(questionList, question, bottomTextField, backButton, nextButton, submitButton, bottomListView, getApplicationContext());
    }

    @Override
    protected void onStop() {
        controller.save();
        super.onStop();
    }
}
