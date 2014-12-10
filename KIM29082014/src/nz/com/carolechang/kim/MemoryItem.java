package nz.com.carolechang.kim;

import android.os.Parcel;
import android.os.Parcelable;

public class MemoryItem implements Parcelable {

	private int Id;
	private String Date;
	private String Time;
	private String Place;
	private String Event;
	private String Purpose;
	private String Person;
	private String Activity;
	private String Feeling;
	private String Notes;

	/*
	 * A constructor that initializes the MemoryItem object
	 */
	public MemoryItem(int id, String date, String time, String place,
			String event, String purpose, String person, String activity,
			String feeling, String notes) {
		super();
		Id = id;
		Date = date;
		Time = time;
		Place = place;
		Event = event;
		Purpose = purpose;
		Person = person;
		Activity = activity;
		Feeling = feeling;
		Notes = notes;
	}

	/*
	 * Retrieving MemroyItem data from Parcel object This constructor is invoked
	 * by the method createFromParcel(Parcel source) of the object CREATOR
	 */
	public MemoryItem(Parcel source) {
		this.Id = source.readInt();
		this.Date = source.readString();
		this.Time = source.readString();
		this.Place = source.readString();
		this.Event = source.readString();
		this.Purpose = source.readString();
		this.Person = source.readString();
		this.Activity = source.readString();
		this.Feeling = source.readString();
		this.Notes = source.readString();
	}

	public MemoryItem() {
		// TODO Auto-generated constructor stub
	}

	public static final Parcelable.Creator<MemoryItem> CREATOR = new Parcelable.Creator<MemoryItem>() {

		@Override
		public MemoryItem createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new MemoryItem(source);
		}

		@Override
		public MemoryItem[] newArray(int size) {
			// TODO Auto-generated method stub
			return new MemoryItem[size];
		}

	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * Storing the MemroyItem data to Parcel Object
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(Id);
		dest.writeString(Date);
		dest.writeString(Time);
		dest.writeString(Place);
		dest.writeString(Event);
		dest.writeString(Purpose);
		dest.writeString(Person);
		dest.writeString(Activity);
		dest.writeString(Feeling);
		dest.writeString(Notes);
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getPlace() {
		return Place;
	}

	public void setPlace(String place) {
		Place = place;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getPurpose() {
		return Purpose;
	}

	public void setPurpose(String purpose) {
		Purpose = purpose;
	}

	public String getPerson() {
		return Person;
	}

	public void setPerson(String person) {
		Person = person;
	}

	public String getActivity() {
		return Activity;
	}

	public void setActivity(String activity) {
		Activity = activity;
	}

	public String getFeeling() {
		return Feeling;
	}

	public void setFeeling(String feeling) {
		Feeling = feeling;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

}
