package nz.com.carolechang.kim;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class AddActivity extends Activity {
	EditText edtDate, edtLocation, edtDetails, edtPerson, edtNotes;
	Spinner spnTime, spnEvent, spnActivity, spnFeeling;
	String mDate, strTime, strEvent, strActivity, strFeeling;
	ImageButton btnCancel, btnSave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);

		setupViewComponent();
	}

	private void setupViewComponent() {
		// TODO Auto-generated method stub
		edtDate = (EditText) findViewById(R.id.edtDate);
		edtLocation = (EditText) findViewById(R.id.edtLocation);
		edtDetails = (EditText) findViewById(R.id.edtDetails);
		edtPerson = (EditText) findViewById(R.id.edtPerson);
		edtNotes = (EditText) findViewById(R.id.edtNotes);
		spnTime = (Spinner) findViewById(R.id.spnTime);
		spnEvent = (Spinner) findViewById(R.id.spnEvent);
		spnActivity = (Spinner) findViewById(R.id.spnActivity);
		spnFeeling = (Spinner) findViewById(R.id.spnFeeling);
		btnCancel = (ImageButton) findViewById(R.id.btnCancel);
		btnSave = (ImageButton) findViewById(R.id.btnSave);

		// Time Spinner
		ArrayAdapter<CharSequence> adapTime = ArrayAdapter.createFromResource(
				this, R.array.time,
				android.R.layout.simple_spinner_dropdown_item);
		spnTime.setAdapter(adapTime);
		spnTime.setOnItemSelectedListener(spnTimeItmeSelLis);

		// Event Spinner
		ArrayAdapter<CharSequence> adapEvent = ArrayAdapter.createFromResource(
				this, R.array.event,
				android.R.layout.simple_spinner_dropdown_item);
		spnEvent.setAdapter(adapEvent);
		spnEvent.setOnItemSelectedListener(spnEventItemSelLis);

		// Activity Spinner
		ArrayAdapter<CharSequence> adapActivity = ArrayAdapter
				.createFromResource(this, R.array.activity,
						android.R.layout.simple_spinner_dropdown_item);
		spnActivity.setAdapter(adapActivity);
		spnActivity.setOnItemSelectedListener(spnActivityItemSelLis);

		// Feeling Spinner
		ArrayAdapter<CharSequence> adapFeeling = ArrayAdapter
				.createFromResource(this, R.array.feeling,
						android.R.layout.simple_spinner_dropdown_item);
		spnFeeling.setAdapter(adapFeeling);
		spnFeeling.setOnItemSelectedListener(spnFeelingItemSelLis);

		edtDate.setOnClickListener(edtDateOnClick);
		btnCancel.setOnClickListener(btnCancelOnClick);
		btnSave.setOnClickListener(btnSaveOnClick);
	}

	private Spinner.OnItemSelectedListener spnTimeItmeSelLis = new Spinner.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			strTime = parent.getSelectedItem().toString();

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}
	};

	private Spinner.OnItemSelectedListener spnEventItemSelLis = new Spinner.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			strEvent = parent.getSelectedItem().toString();

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}
	};

	private Spinner.OnItemSelectedListener spnActivityItemSelLis = new Spinner.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			strActivity = parent.getSelectedItem().toString();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}
	};

	private Spinner.OnItemSelectedListener spnFeelingItemSelLis = new Spinner.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			strFeeling = parent.getSelectedItem().toString();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}
	};

	private EditText.OnClickListener edtDateOnClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			Calendar eDate = Calendar.getInstance();
			DatePickerDialog datePicDlg = new DatePickerDialog(
					AddActivity.this, datePicDlgOnDateSelLis,
					eDate.get(Calendar.YEAR), eDate.get(Calendar.MONTH),
					eDate.get(Calendar.DATE));
			datePicDlg.setTitle("Select Date");
			datePicDlg.setMessage("Please select the date for this memory");
			datePicDlg.setIcon(android.R.drawable.ic_dialog_info);
			datePicDlg.show();
		}
	};

	private DatePickerDialog.OnDateSetListener datePicDlgOnDateSelLis = new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			mDate = Integer.toString(dayOfMonth) + "/"
					+ Integer.toString(monthOfYear + 1) + "/"
					+ Integer.toString(year);
			edtDate.setText(mDate);
		}
	};

	private Button.OnClickListener btnSaveOnClick = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			MemoryItem memoryItem = new MemoryItem();
			memoryItem.setDate(mDate);
			memoryItem.setTime(strTime);
			memoryItem.setPlace(edtLocation.getText().toString());
			memoryItem.setEvent(strEvent);
			memoryItem.setPurpose(edtDetails.getText().toString());
			memoryItem.setPerson(edtPerson.getText().toString());
			memoryItem.setActivity(strActivity);
			memoryItem.setFeeling(strFeeling);
			memoryItem.setNotes(edtNotes.getText().toString());

			Intent intent = new Intent(AddActivity.this, DisplayActivity.class);
			Bundle bundle = new Bundle();

			bundle.putParcelable("MemoryItem", memoryItem);
			intent.putExtras(bundle);
			startActivity(intent);

		}
	};

	private Button.OnClickListener btnCancelOnClick = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}
	};
}
