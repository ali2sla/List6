package sample.list6;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Controller {

    private TextView questionList;
    private TextView question;
    private EditText bottomTextField;
    private Button backButton;
    private Button nextButton;
    private Button submitButton;
    private ListView bottomListView;
    private ArrayAdapter<String> arrayAdapter;
    Context cntxt;

    private Model model;

    int currentQuestion;
    int totalQuestions;

    String[] questions;

    Controller(TextView t1, TextView t2, EditText e1, Button b1, Button b2, Button b3, ListView lv1, Context context) {
        questionList = t1;
        question = t2;
        bottomTextField = e1;
        backButton = b1;
        nextButton = b2;
        submitButton = b3;
        bottomListView = lv1;
        cntxt = context;

        model = new Model(cntxt);

        arrayAdapter = (ArrayAdapter<String>)lv1.getAdapter();

        currentQuestion = 0;
        totalQuestions = 5;
        questions = new String[totalQuestions + 1];
        questions[0] = "Are you ready to start the survey?";
        questions[1] = "Question 1: What will you bring if you were stranded on an island?";
        questions[2] = "Question 2: If you receive a request to make dinner for the president, would you do it?";
        questions[3] = "Question 3: If someone was coughing repeatedly at your restaurant after eating, what will you do?";
        questions[4] = "Question 4: What is something that is in your closet?";
        questions[5] = "Question 5: If free candy is free candy, would you go to the haunted house?";

        question.setText(questions[currentQuestion]);
        questionList.setText("Question " + currentQuestion + " of " + totalQuestions);

        // Now that model has been initialized from a file, update View with saved values from Model
        bottomTextField.setText(model.getBottomTextFieldText());
        ArrayList sideListViewTexts = model.getSideListViewTexts();
        for (int i = 0; i < sideListViewTexts.size(); i++) {
            //sideListView.getItems().add(new TextView((String)sideListViewTexts.get(i)));
        }
    }

    void save() {
        System.out.println("Controller save");
        // push the latest GUI text into the model
        //model.setAllData(bottomTextField.getText(), sideListView.getItems());
        model.save();
    }

    public void bottomTextFieldReady() {
        System.out.println("bottomTextFieldReady: " + bottomTextField.getText());
        // Update the list view with the text from the bottom text field
        //sideListView.getItems().add(new Label(question.getText()));
        //sideListView.getItems().add(new Label(bottomTextField.getText()));
        // Clear the bottom text field because it has been used.
        bottomTextField.setText("");

        // Go to next question
        currentQuestion = currentQuestion + 1;
        question.setText(questions[currentQuestion]);
        questionList.setText("Question " + currentQuestion + " of " + totalQuestions);
    }

    public void backTextReady() {
        currentQuestion = currentQuestion - 1;
        question.setText(questions[currentQuestion]);
        questionList.setText("Question " + currentQuestion + " of " + totalQuestions);
    }

    public void nextTextReady() {
        currentQuestion = currentQuestion + 1;
        question.setText(questions[currentQuestion]);
        questionList.setText("Question " + currentQuestion + " of " + totalQuestions);
    }
}

