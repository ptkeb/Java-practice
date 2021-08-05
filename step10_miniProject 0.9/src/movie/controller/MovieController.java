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
	 * ��� Movie �˻�  >> ����
	 */
	public void getMovieList()
	{
		ArrayList<Movie> movieList = service.getMovieList();
		
		if (movieList.size() != 0){
			EndView.movieListView(movieList);
		}else {
			EndView.messageView("���� ��ȭ �����Ͱ� �������� �ʽ��ϴ�.");
		}
	}
	
	public void getTheaterList()
	{
		ArrayList<Theater> theaterList = service.getTheaterList();
		if (theaterList.size() != 0){
			EndView.theaterListView(theaterList);
		}else {
			EndView.messageView("���� �󿵰� �����Ͱ� �������� �ʽ��ϴ�.");
		}
	}
	
	public void getReservationList()
	{
		ArrayList<Reservation> ReservationList = service.getReservationList();
		if (ReservationList.size() != 0){
			EndView.reservationListView(ReservationList);
		}else {
			EndView.messageView("���� ���� �����Ͱ� �������� �ʽ��ϴ�");
		}
	}

	
	
	
	/**
	 * ��ȭ �������� Ư�� Movie �˻� >> ����
	 * 
	 * @param movieTitle
	 */
	public void getMovie(String movieTitle) {
		Movie movie = service.getMovie(movieTitle);
		if(movie != null) {
			EndView.movieView(movie);
		}else {
			EndView.messageView("�˻��Ͻ� ������ ��ȭ�� �������� �ʽ��ϴ�.");
		}
	}
	
	
	/**
	 * �󿵰� �̸����� Ư�� Theater �˻�  >> ����
	 * 
	 * @param theaterName
	 */
	public void getTheater(String theaterName) {
		Theater theater = service.getTheater(theaterName);
		if(theater != null) {
			EndView.theatertView(theater);
		}else {
			EndView.messageView("�˻��Ͻ� �̸��� �󿵰��� �������� �ʽ��ϴ�.");
		}
	}

	
	/**
	 * ������ �̸����� Ư�� Reservation �˻�  >> ����
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
	 * ������ �̸����� Ư�� Reservation ����  >> ����
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
	 * ������ �̸����� Ư�� Reservation ����  >> ���
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
				EndView.messageView(name + "���� ������ �����Ǿ����ϴ�.");
			}
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			}
	}
		

	
}
