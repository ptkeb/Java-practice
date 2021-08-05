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
	 * 모든 Movie 검색  >> 경준
	 */
	public void getMovieList() {
		ArrayList<Movie> movieList = service.getMovieList();
		
		if (movieList.size() != 0){
			EndView.movieListView(movieList);
		}else {
			EndView.messageView("현재 영화 데이터가 존재하지 않습니다.");
		}
	}
	
	public void getTheaterList() {
		ArrayList<Theater> theaterList = service.getTheaterList();
		if (theaterList.size() != 0){
			EndView.theaterListView(theaterList);
		}else {
			EndView.messageView("현재 상영관 데이터가 존재하지 않습니다.");
		}
	}
	
	public void getReservationList() {
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
			Reservation reservation = service.getReservation(name);
			if(reservation != null) {
				EndView.reservationView(reservation);
			}else {
				EndView.messageView("검색하신 이름의 예약 내역이 존재하지 않습니다.");
		}
	}
	
//	---------------------------------------------------------------------------------
	
	
	
	
	/**
	 * 예약자 이름으로 특정 Reservation 수정  >> 지혜
	 * 
	 * @param name
	 */
	public void updateReservation(String name, String movieTitle) {
		Reservation reservation = service.getReservation(name);
		if(reservation != null) {
			reservation.setMovieTitle(movieTitle);
		}else {
			EndView.messageView("검색하신 이름의 예약 내역이 존재하지 않습니다.");
		}
	}

	
	/**
	 * 예약자 이름으로 특정 Reservation 삭제  >> 대안
	 * 
	 * @param name
	 */
	public void deleteReservation(String name) {
		Reservation reservation = service.getReservation(name);
		if(reservation != null) {
			service.getReservationList().remove(reservation);
			EndView.messageView(name + "님의 예약이 삭제되었습니다.");
		}else {
			EndView.messageView("검색하신 이름의 예약 내역이 존재하지 않습니다.");
		}
	}
	
//	----------------------------------------------------------------------
	
	/**
	 * 새로운 Reservation 저장
	 * 
	 * @param newReservation
	 */
	// 전체 수정 전임!!!
//	public void insertProject(TalentDonationProject newProject) {
//		if(newProject != null) {
//			try {
//				service.projectInsert(newProject);
//				EndView.messageView(newProject.getTalentDonationProjectName() + " 저장 성공");
//			}catch(DuplicateException e) {
//				FailView.failMessageView(e.getMessage());
//			}
//		}else {
//			EndView.messageView("새로 저장하고자 하는 프로젝트의 입력 정보가 없습니다. 재확인 해 주세요");
//		}
//	}
	
	
	/**
	 * 존재하는 Reservation의 영화 제목 수정 
	 * 예약자 이름으로 검색해서 해당하는 예약의 영화 제목 수정
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
			EndView.messageView("수정하고자 하는 영화 정보가 무효합니다, 재 확인 해 주세요");
		}
	}
	
	
	/** 
	 * 존재하는 Reservation 삭제 
	 * 예약자 이름으로 검색해서 해당하는 예약 삭제
	 * 
	 * @param name
	 */
	public void deleteReservation2(String name) {
		if(name != null) {
			try {
				service.reservationDelete(name);
				EndView.messageView(name + "님의 예약이 삭제되었습니다.");
			}catch(NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}	
		}else {
			EndView.messageView("삭제하고자 하는 예약의 예약자명이 무효합니다. 재 확인 해 주세요");
		}
	}
	
}
