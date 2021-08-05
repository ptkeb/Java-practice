package movie.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import movie.exception.NotExistException;
import movie.model.MovieModel;
import movie.model.dto.Movie;
import movie.model.dto.Reservation;
import movie.model.dto.Theater;
import movie.view.EndView;

public class MovieService {
	
	private static MovieService instance = new MovieService();
	
	private MovieService() {}
	
	public static MovieService getInstance() {
		return instance;
		
	}
	
	/**
	 * 모든 Movie 검색  >> 경준
	 */
	public static ArrayList<Movie> getMovieList()
	{
		ArrayList<Movie> movieData = MovieModel.getMovieList();
		return movieData;
	}
	
	public static ArrayList<Theater> getTheaterList()
	{
		ArrayList<Theater> theaterData = MovieModel.getTheaterList();
		return theaterData;
	}

	public static ArrayList<Reservation> getReservationList()
	{
		ArrayList<Reservation> reservationList = MovieModel.getReservationList();
		return reservationList;
	}

	

	
	/**
	 * 영화 제목으로 특정 Movie 검색 - movie 반환 >> 지수
	 * 
	 * @param movieTitle
	 * @return Movie 검색된 영화, 검색하고자 하는 영화가 없을 경우 null 반환
	 */
	public Movie getMovie(String movieTitle) {
		ArrayList<Movie> movieList = getMovieList();
		
		for(Movie movie : movieList) {
			if (movie.getMovieTitle().equals(movieTitle)) {
				return movie;
			}
		}
		return null;
	}
	
	
	/**
	 * 상영관 이름으로 특정 Theater 검색 - theater 반환 >> 지수
	 * 
	 * @param theaterName
	 * @return Theater 검색된 상영관, 검색하고자 하는 상영관이 없을 경우 null 반환
	 */
	public Theater getTheater(String theaterName) {
		ArrayList<Theater> theaterList = getTheaterList();
		
		for(Theater theater : theaterList) {
			if (theater.getTheaterName().equals(theaterName)) {
				return theater;
			}
		}
		return null;
	}
	
	
	
	/**
	 * 예약자 이름으로 특정 Reservation 검색 - reservation 반환  >> 지수
	 * 
	 * @param name
	 * @return Reservation 검색된 예약, 검색하고자 하는 예약 내역이 없을 경우 null 반환
	 */
	public static Reservation getReservation(String name) throws NotExistException{
		ArrayList<Reservation> reservationList = getReservationList();
		
		for(Reservation reservation : reservationList) {
			if (reservation.getName().equals(name)) {
				return reservation;
			}
			throw new NotExistException("검색하신 성함의 예약자가 존재하지않습니다");
		}
		return null;
	}
	
}
