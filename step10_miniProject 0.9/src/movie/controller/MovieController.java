package movie.controller;

import java.util.ArrayList;

import movie.exception.NotExistException;
import movie.model.MovieModel;
import movie.model.dto.Movie;
import movie.model.dto.Reservation;
import movie.model.dto.Theater;
import movie.service.MovieService;
import movie.view.EndView;
import movie.view.FailView;

public class MovieController {

	private static MovieController instance = new MovieController();
	private MovieService service = MovieService.getInstance();
	
	private MovieController() {}
	
	public static MovieController getInstance() {
		return instance;
	}
	
	/**
	 * 모든 Movie 검색  >> 경준
	 */
	public void getMovieList()
	{
		ArrayList<Movie> movieList = service.getMovieList();
		
		if (movieList.size() != 0){
			EndView.movieListView(movieList);
		}else {
			EndView.messageView("현재 영화 데이터가 존재하지 않습니다.");
		}
	}
	
	public void getTheaterList()
	{
		ArrayList<Theater> theaterList = service.getTheaterList();
		if (theaterList.size() != 0){
			EndView.theaterListView(theaterList);
		}else {
			EndView.messageView("현재 상영관 데이터가 존재하지 않습니다.");
		}
	}
	
	public void getReservationList()
	{
		ArrayList<Reservation> ReservationList = service.getReservationList();
		if (ReservationList.size() != 0){
			EndView.reservationListView(ReservationList);
		}else {
			EndView.messageView("현재 예약 데이터가 존재하지 않습니다");
		}
	}

	
	
	
	/**
	 * 영화 제목으로 특정 Movie 검색 >> 지수
	 * 
	 * @param movieTitle
	 */
	public void getMovie(String movieTitle) {
		Movie movie = service.getMovie(movieTitle);
		if(movie != null) {
			EndView.movieView(movie);
		}else {
			EndView.messageView("검색하신 제목의 영화는 존재하지 않습니다.");
		}
	}
	
	
	/**
	 * 상영관 이름으로 특정 Theater 검색  >> 지수
	 * 
	 * @param theaterName
	 */
	public void getTheater(String theaterName) {
		Theater theater = service.getTheater(theaterName);
		if(theater != null) {
			EndView.theatertView(theater);
		}else {
			EndView.messageView("검색하신 이름의 상영관은 존재하지 않습니다.");
		}
	}

	
	/**
	 * 예약자 이름으로 특정 Reservation 검색  >> 지수
	 * 
	 * @param name
	 */
	public void getReservation(String name) {
		try {
			Reservation reservation = service.getReservation(name);
			if(reservation != null) {
				EndView.reservationView(reservation);
			}
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	
	
	
	/**
	 * 예약자 이름으로 특정 Reservation 수정  >> 지혜
	 * 
	 * @param name
	 */
	public void updateReservation(String name, String movieTitle) {
		Reservation reservation;
		try {
			reservation = service.getReservation(name);
			if(reservation != null) {
				reservation = service.getReservation(name);
				reservation.setMovieTitle(movieTitle);
			}
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			}
	}

	
	/**
	 * 예약자 이름으로 특정 Reservation 삭제  >> 대안
	 * 
	 * @param name
	 */
	public void deleteReservation(String name) {
		Reservation reservation;
		try {
			reservation = service.getReservation(name);
			if(reservation != null) {
				reservation = service.getReservation(name);
				service.getReservationList().remove(reservation);
				EndView.messageView(name + "님의 예약이 삭제되었습니다.");
			}
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			}
	}
		

	
}
