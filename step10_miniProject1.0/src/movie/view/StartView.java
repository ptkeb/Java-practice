package movie.view;

import movie.controller.MovieController;

public class StartView {

	public static void main(String[] args) {
		
		MovieController controller = MovieController.getInstance();
		
//		모든 Movie, Theater, Reservation List 검색
		System.out.println("\n*** 01. 모든 Movie 검색 ***");
		controller.getMovieList();	
		
		System.out.println("\n*** 01. 모든 Theater 검색 ***");
		controller.getTheaterList();	
		
		System.out.println("\n*** 01. 모든 Reservation 검색 ***");
		controller.getReservationList();	
	
//		--------------------------------------------------------------------------
		
//		특정 값으로 하나의 Movie, Theater, Reservation 검색
		System.out.println("\n*** 02. 영화 제목으로 Movie 검색 ***");
		controller.getMovie("블랙 위도우");
		
		System.out.println("\n*** 02. 상영관 이름으로 Theater 검색 ***");
		controller.getTheater("CGV");
		
		System.out.println("\n*** 02. 예약자 이름으로 Reservation 검색 ***");
		controller.getReservation("엔코아");
		
		System.out.println("\n*** 03. 미존재하는 Movie 검색 ***");
		controller.getMovie("키다리아저씨");
		
		System.out.println("\n*** 03. 미존재하는 Theater 검색 ***");
		controller.getTheater("CGV연남");
		
		System.out.println("\n*** 03. 미존재하는 Reservation 검색 ***");
		controller.getReservation("안산");
		
//		--------------------------------------------------------------------------
		
//		예약자 정보 이름으로 검색 후 수정 / 수정 전 검색 / 수정 후 검색
		System.out.println("\n*** 04. 예약자 정보 이름으로 검색 및 수정, 수정 후 프로젝트 검색 ***");
		System.out.println("04-1. 수정 전 예약자 검색");
		controller.getReservation("플레이");
		
		controller.updateReservation2("플레이", "블랙 팬서");
		
		System.out.println("\n04-2. 수정 후 예약자 검색");
		controller.getReservation("플레이");


//		--------------------------------------------------------------------------
		
//		예약자 정보 이름으로 검색 후 삭제 / 수정 전 검색 / 수정 후 검색
		System.out.println("\n*** 08. 홍길동 예약자 삭제 후 삭제한 예약자 검색 ***");
		System.out.println("08-1. 삭제전 예약자 검색");
		controller.getReservation("홍길동");
		
		controller.deleteReservation2("홍길동");
		
		System.out.println("\n08-2. 삭제 후 예약자 검색 ");
		controller.getReservation("홍길동");
	}
}
