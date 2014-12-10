package nz.com.carolechang.kim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends Activity {
	TextView txtDate, txtTime, txtPlace, txtTitle, txtPerson, txtActivity,
			txtFeeling, txtNotes;
	Button btnFinish;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);

		setupViewComponent();
		showMemory();
	}

	private void setupViewComponent() {
		// TODO Auto-generated method stub
		txtDate = (TextView) findViewById(R.id.txtDate);
		txtTime = (TextView) findViewById(R.id.txtTime);
		txtPlace = (TextView) findViewById(R.id.txtPlace);
		txtTitle = (TextView) findViewById(R.id.txtTitle);
		txtPerson = (TextView) findViewById(R.id.txtPerson);
		txtActivity = (TextView) findViewById(R.id.txtActivity);
		txtFeeling = (TextView) findViewById(R.id.txtFeeling);
		txtNotes = (TextView) findViewById(R.id.txtNotes);
		btnFinish = (Button) findViewById(R.id.btnFinish);

		btnFinish.setOnClickListener(btnFinishOnClick);
	}

	private Button.OnClickListener btnFinishOnClick = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			DisplayActivity.this.finish();
		}
	};

	private void showMemory() {
		// TODO Auto-generated method stub
		Bundle bundle = getIntent().getExtras();
		MemoryItem memoryItem = bundle.getParcelable("MemoryItem");

		txtDate.setText(memoryItem.getDate());
		txtTime.setText(memoryItem.getTime());
		txtPlace.setText(memoryItem.getPlace());
		txtTitle.setText(memoryItem.getEvent() + ": " + memoryItem.getPurpose());
		txtPerson.setText(memoryItem.getPerson());
		txtActivity.setText(memoryItem.getActivity());
		txtFeeling.setText(memoryItem.getFeeling());
		txtNotes.setText(memoryItem.getNotes());

	}

}
