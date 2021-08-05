package movie.model.dto;

public class Reservation {
	private String name;
	private String movieTitle;
	private String theaterName;
	private String screeningDate;
	private int runningTime;
	private String reservationDate;
	
	public Reservation() {
		super();
	}

	public Reservation(String name, String movieTitle, String theaterName, String screeningDate, int runningTime,
			String reservationDate) {
		super();
		this.name = name;
		this.movieTitle = movieTitle;
		this.theaterName = theaterName;
		this.screeningDate = screeningDate;
		this.runningTime = runningTime;
		this.reservationDate = reservationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getScreeningDate() {
		return screeningDate;
	}

	public void setScreeningDate(String screeningDate) {
		this.screeningDate = screeningDate;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[예약자 이름]");
		builder.append(name);
		builder.append(", [영화 제목]");
		builder.append(movieTitle);
		builder.append(", [상영관 이름]");
		builder.append(theaterName);
		builder.append(", [상영 날짜]");
		builder.append(screeningDate);
		builder.append(", [러닝타임]");
		builder.append(runningTime);
		builder.append(", [예약 날짜]");
		builder.append(reservationDate);
		return builder.toString();
	}
}
