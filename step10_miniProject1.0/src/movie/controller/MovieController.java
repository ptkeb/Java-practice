package movie.controller;

import java.util.ArrayList;

import movie.model.dto.Movie;
import movie.model.dto.Reservation;
import movie.model.dto.Theater;
import movie.service.MovieService;

import movie.view.EndView;
import movie.view.FailView;

import movie.exception.NotExistException;

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
	public void getMovieList() {
		ArrayList<Movie> movieList = service.getMovieList();
		
		if (movieList.size() != 0){
			EndView.movieListView(movieList);
		}else {
			EndView.messageView("���� ��ȭ �����Ͱ� �������� �ʽ��ϴ�.");
		}
	}
	
	public void getTheaterList() {
		ArrayList<Theater> theaterList = service.getTheaterList();
		if (theaterList.size() != 0){
			EndView.theaterListView(theaterList);
		}else {
			EndView.messageView("���� �󿵰� �����Ͱ� �������� �ʽ��ϴ�.");
		}
	}
	
	public void getReservationList() {
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
			Reservation reservation = service.getReservation(name);
			if(reservation != null) {
				EndView.reservationView(reservation);
			}else {
				EndView.messageView("�˻��Ͻ� �̸��� ���� ������ �������� �ʽ��ϴ�.");
		}
	}
	
//	---------------------------------------------------------------------------------
	
	
	
	
	/**
	 * ������ �̸����� Ư�� Reservation ����  >> ����
	 * 
	 * @param name
	 */
	public void updateReservation(String name, String movieTitle) {
		Reservation reservation = service.getReservation(name);
		if(reservation != null) {
			reservation.setMovieTitle(movieTitle);
		}else {
			EndView.messageView("�˻��Ͻ� �̸��� ���� ������ �������� �ʽ��ϴ�.");
		}
	}

	
	/**
	 * ������ �̸����� Ư�� Reservation ����  >> ���
	 * 
	 * @param name
	 */
	public void deleteReservation(String name) {
		Reservation reservation = service.getReservation(name);
		if(reservation != null) {
			service.getReservationList().remove(reservation);
			EndView.messageView(name + "���� ������ �����Ǿ����ϴ�.");
		}else {
			EndView.messageView("�˻��Ͻ� �̸��� ���� ������ �������� �ʽ��ϴ�.");
		}
	}
	
//	----------------------------------------------------------------------
	
	/**
	 * ���ο� Reservation ����
	 * 
	 * @param newReservation
	 */
	// ��ü ���� ����!!!
//	public void insertProject(TalentDonationProject newProject) {
//		if(newProject != null) {
//			try {
//				service.projectInsert(newProject);
//				EndView.messageView(newProject.getTalentDonationProjectName() + " ���� ����");
//			}catch(DuplicateException e) {
//				FailView.failMessageView(e.getMessage());
//			}
//		}else {
//			EndView.messageView("���� �����ϰ��� �ϴ� ������Ʈ�� �Է� ������ �����ϴ�. ��Ȯ�� �� �ּ���");
//		}
//	}
	
	
	/**
	 * �����ϴ� Reservation�� ��ȭ ���� ���� 
	 * ������ �̸����� �˻��ؼ� �ش��ϴ� ������ ��ȭ ���� ����
	 * 
	 * @param name
	 * @param movieTitle
	 */
	public void updateReservation2(String name, String movieTitle) {
		if(movieTitle != null) {
			try {
				service.reservationUpdate(name, movieTitle);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}	
		}else {
			EndView.messageView("�����ϰ��� �ϴ� ��ȭ ������ ��ȿ�մϴ�, �� Ȯ�� �� �ּ���");
		}
	}
	
	
	/** 
	 * �����ϴ� Reservation ���� 
	 * ������ �̸����� �˻��ؼ� �ش��ϴ� ���� ����
	 * 
	 * @param name
	 */
	public void deleteReservation2(String name) {
		if(name != null) {
			try {
				service.reservationDelete(name);
				EndView.messageView(name + "���� ������ �����Ǿ����ϴ�.");
			}catch(NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}	
		}else {
			EndView.messageView("�����ϰ��� �ϴ� ������ �����ڸ��� ��ȿ�մϴ�. �� Ȯ�� �� �ּ���");
		}
	}
	
}
