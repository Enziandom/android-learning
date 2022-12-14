package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.survey.callbacks.Callback;
import com.example.survey.fragments.TimePickerFragment;
import com.example.survey.vms.TimePickerViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initSpinner();

    findViewById(R.id.time_picker_btn).setOnClickListener(this);
    findViewById(R.id.submit_btn).setOnClickListener(this);
  }

  private void initSpinner() {
    Spinner spinner = findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
      R.array.spinner_values, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
  }

  private void Log(String msg) {
    Log.d("Message", msg);
  }

  private void getChild(int layoutId, Callback cb) {
    ViewGroup view = findViewById(layoutId);
    CheckBox checkBox;
    for (int index = 0; index < view.getChildCount(); index++) {
      if (view.getChildAt(index) instanceof CheckBox) {
        checkBox = (CheckBox) view.getChildAt(index);
        if (checkBox.isChecked()) {
          cb.callback(checkBox.getText().toString(), index);
        }
      }
    }
  }

  @Override
  public void onClick(View view) {
    int viewId = view.getId();
    if (viewId == R.id.time_picker_btn) {
      TimePickerFragment timePicker = new TimePickerFragment();
      timePicker.show(getSupportFragmentManager(), "datePicker");
      TextView textview = findViewById(R.id.time_picker_text);
      // ?????? ViewModel ????????????????????? UI
      TimePickerViewModel timePickerVM = new ViewModelProvider(this).get(TimePickerViewModel.class);
      timePickerVM.getDateValue().observe(this, e -> {
        textview.setText(timePickerVM.getDateValue().getValue());
      });
    } else if (viewId == R.id.submit_btn) {
      // 1. ????????????1??????
      RadioGroup rg = findViewById(R.id.radio_group);
      RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
      String ques1 = rb.getText().toString();
      Log("??????1 -> " + ques1);
      // 2. ????????????2??????
      getChild(R.id.ques2_layout, (value, index) -> Log("??????2 -> " + "(???" + index + "???)" + value));
      // 3. ????????????3??????
      getChild(R.id.ques3_layout, (value, index) -> Log("??????3 -> " + "(???" + index + "???)" + value));
      // 4. ????????????4??????
      EditText ques4 = findViewById(R.id.ques4_edit_text);
      Log("??????4 -> " + ques4.getText().toString());
      // 5. ????????????5??????
      EditText ques5 = findViewById(R.id.ques5_edit_text);
      Log("??????5 -> " + ques5.getText().toString());
      // 6. ????????????6??????
      TextView ques6 = findViewById(R.id.time_picker_text);
      Log("??????6 -> " + ques6.getText().toString());
    }
  }
}