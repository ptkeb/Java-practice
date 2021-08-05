package movie.service;

import java.util.ArrayList;

import movie.model.MovieModel;
import movie.model.dto.Movie;
import movie.model.dto.Reservation;
import movie.model.dto.Theater;

import movie.exception.NotExistException;

public class MovieService {
	
	private static MovieService instance = new MovieService();
	
	private static MovieModel movieModel = MovieModel.getInstance();
	
	private MovieService() {}
	
	public static MovieService getInstance() {
		return instance;
	}
	
	/**
	 * ��� Movie �˻�  >> ����
	 */
	public static ArrayList<Movie> getMovieList() {
		ArrayList<Movie> movieList = MovieModel.getMovieList();
		return movieList;
	}
	
	public static ArrayList<Theater> getTheaterList() {
		ArrayList<Theater> theaterList = MovieModel.getTheaterList();
		return theaterList;
	}

	public static ArrayList<Reservation> getReservationList() {
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
	public static Reservation getReservation(String name) {
		ArrayList<Reservation> reservationList = getReservationList();
		
		for(Reservation reservation : reservationList) {
			if (reservation.getName().equals(name)) {
				return reservation;
			} 
		}
		return null;
	}
	
//	------------------------------------------------------------------------------------------
	
	/**
	 * ���ο� Reservation �߰� 
	 * ���� �����ϰ��� �ϴ� Reservation�� �̹� ������ ��� DuplicateException ���� �߻�
	 * 
	 * @param newReservation      �����ϰ��� �ϴ� ���ο� ����
	 * @throws DuplicateException
	 */
//	public void reservationInsert(Reservation newReservation) throws DuplicateException {
//		Reservation reservation = getReservation(newReservation.getName());
//
//		// �ܼ��� �̸��� ���� �����ڴ� ������ �� ���� �ٸ� ��� ���
//		
//		if (reservation != null) {
//			throw new DuplicateException("�ش� �����ڸ�� ������ �̸��� �����ڰ� �̹� ���� ������ �����մϴ�.");
//		}
//		movieModel.insertReservation(newReservation);
//	}
	

	
	/**
	 * Reservation�� ��ȭ ���� ���� - ������ �̸����� �˻��ؼ� �ش� ������ ��ȭ ���� ����
	 * �����ϰ��� �ϴ� ������ �������� ���� ��� NotExistException �߻�
	 * 
	 * @param name ������ �̸�
	 * @param movieTitle ��ȭ ����
	 * @throws NotExistException
	 */
	public void reservationUpdate(String name, String movieTitle) throws NotExistException {
		Reservation reservation = getReservation(name);
		
		if(reservation == null){
			throw new NotExistException("�����ϰ��� �ϴ� ���� ������ �������� �ʴ� ������ �߻��߽��ϴ�.");
		}else {
			reservation.setMovieTitle(movieTitle);
		}
	}

	
	/**
	 * Reservation ���� - ������ �̸����� �ش� ���� ����
	 * 
	 * @param name ������ �̸�
	 * @throws NotExistException
	 */
	public void reservationDelete(String name) throws NotExistException{
		Reservation reservation = getReservation(name);
		
		if(reservation == null) {
			throw new NotExistException("�����ϰ��� �ϴ� ���� ������ �������� �ʴ� ������ �߻��߽��ϴ�.");
		}else {
			getReservationList().remove(reservation);
		}
	}
	
}
