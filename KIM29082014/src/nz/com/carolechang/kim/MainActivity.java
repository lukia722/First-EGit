package nz.com.carolechang.kim;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView txvDate, txvMonth, txvYear;
	ImageButton btnAdd, btnMemory, btnTraining, btnSetting;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setupViewComponent();
		showDate();
	}

	private void setupViewComponent() {
		// TODO Auto-generated method stub
		txvDate = (TextView) findViewById(R.id.txvDate);
		txvMonth = (TextView) findViewById(R.id.txvMonth);
		txvYear = (TextView) findViewById(R.id.txvYear);

		btnAdd = (ImageButton) findViewById(R.id.btnAdd);
		btnMemory = (ImageButton) findViewById(R.id.btnMemory);
		btnTraining = (ImageButton) findViewById(R.id.btnTraining);
		btnSetting = (ImageButton) findViewById(R.id.btnSetting);

		btnAdd.setOnClickListener(btnAddOnClick);
		btnMemory.setOnClickListener(btnMemoryOnClick);
		btnTraining.setOnClickListener(btnTrainingOnClick);
		btnSetting.setOnClickListener(btnSettingOnClick);
	}

	private void showDate() {
		// TODO Auto-generated method stub

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd");
		String strDate = sdfDate.format(calendar.getTime());
		SimpleDateFormat sdfMonth = new SimpleDateFormat("MMM");
		String strMonth = sdfMonth.format(calendar.getTime());
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		String strYear = sdfYear.format(calendar.getTime());

		txvDate.setText(strDate);
		txvMonth.setText(strMonth);
		txvYear.setText(strYear);

	}

	private Button.OnClickListener btnAddOnClick = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(MainActivity.this, AddActivity.class);
			startActivity(intent);
		}
	};

	private Button.OnClickListener btnMemoryOnClick = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(MainActivity.this, MemoryActivity.class);
			startActivity(intent);
		}
	};

	private Button.OnClickListener btnTrainingOnClick = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(MainActivity.this,
					TrainingActivity.class);
			startActivity(intent);
		}
	};

	private Button.OnClickListener btnSettingOnClick = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(MainActivity.this, SettingActivity.class);
			startActivity(intent);

		}
	};
}
