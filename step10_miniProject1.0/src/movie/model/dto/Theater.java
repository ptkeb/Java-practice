package movie.model.dto;

public class Theater {

	private String theaterName;
	
	private String theaterLoc;
	
	private int seat;
	
	public Theater() {}
	public Theater(String theaterName, String theaterLoc, int seat) {
		super();
		this.theaterName = theaterName;
		this.theaterLoc = theaterLoc;
		this.seat = seat;
	}
	
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTheaterLoc() {
		return theaterLoc;
	}
	public void setTheaterLoc(String theaterLoc) {
		this.theaterLoc = theaterLoc;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
//	@Override
//	public String toString() {
//		return "Theater [theaterName=" + theaterName + ", theaterLoc=" + theaterLoc + ", seat=" + seat + "]";
//	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("��ȭ�� �̸� : ");
		builder.append(theaterName);
		builder.append(", ��ȭ�� ��ġ : ");
		builder.append(theaterLoc);
		builder.append(", �¼��� : ");
		builder.append(seat);

		return builder.toString();
	}
}

