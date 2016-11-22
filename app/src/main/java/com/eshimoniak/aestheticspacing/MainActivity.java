package com.eshimoniak.aestheticspacing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private EditText input;
	private TextView output;
	private SeekBar kerning;
	private SeekBar spacing;
	private CheckBox capitalize;
	private Button copy;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		input = (EditText) findViewById(R.id.input);
		output = (TextView) findViewById(R.id.output);
		kerning = (SeekBar) findViewById(R.id.kerning);
		spacing = (SeekBar) findViewById(R.id.spacing);
		capitalize = (CheckBox) findViewById(R.id.capitalize);
		copy = (Button) findViewById(R.id.copyButton);

		input.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				update();
			}
		});

		kerning.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				update();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});

		spacing.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				update();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});

//		capitalize.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				update();
//			}
//		});
		capitalize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				update(isChecked);
			}
		});

		copy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
				ClipData clip = ClipData.newPlainText("t e x t", output.getText());
				clipboard.setPrimaryClip(clip);

				Toast.makeText(getApplicationContext(), R.string.copy_confirmation, Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void update(boolean allCaps) {
		String str = SpaceModifier.addSpaces(input.getText().toString(), kerning.getProgress(), spacing.getProgress(), true);

		if (allCaps) {
			str = str.toUpperCase();
		}

		output.setText(str);
	}

	private void update() {
		update(capitalize.isPressed());
	}
}
