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
	 * ��� Movie �˻�  >> ����
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
	 * ��ȭ �������� Ư�� Movie �˻� - movie ��ȯ >> ����
	 * 
	 * @param movieTitle
	 * @return Movie �˻��� ��ȭ, �˻��ϰ��� �ϴ� ��ȭ�� ���� ��� null ��ȯ
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
	 * �󿵰� �̸����� Ư�� Theater �˻� - theater ��ȯ >> ����
	 * 
	 * @param theaterName
	 * @return Theater �˻��� �󿵰�, �˻��ϰ��� �ϴ� �󿵰��� ���� ��� null ��ȯ
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
	 * ������ �̸����� Ư�� Reservation �˻� - reservation ��ȯ  >> ����
	 * 
	 * @param name
	 * @return Reservation �˻��� ����, �˻��ϰ��� �ϴ� ���� ������ ���� ��� null ��ȯ
	 */
	public static Reservation getReservation(String name) throws NotExistException{
		ArrayList<Reservation> reservationList = getReservationList();
		
		for(Reservation reservation : reservationList) {
			if (reservation.getName().equals(name)) {
				return reservation;
			}
			throw new NotExistException("�˻��Ͻ� ������ �����ڰ� ���������ʽ��ϴ�");
		}
		return null;
	}
	
}
