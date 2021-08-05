package movie.view;

import org.apache.log4j.Logger;

import movie.controller.MovieController;
import movie.model.dto.Reservation;

public class StartView {
	
	static Logger logger = Logger.getLogger("movie.view.Log4j");
	
	public static void reservationCheck(String crud) {
		System.out.println("---------- 로그 실행 ----------");
		if(crud == "추가") { //예약자 추가
			logger.info("info - 예약자 추가!");
		} else if (crud == "수정") {
			logger.info("info - 예약자 수정!");
		} else if (crud == "삭제") {
			logger.info("info - 예약자 삭제!");
		} else {
			logger.info("info - 데이터 조회");
		}
	}

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
		
//		새로운 예약 정보 추가
		System.out.println("\n*** 04. 예약자 정보 추가 ***");
		System.out.println("04-1. 추가 전 모든 예약자 검색");
		controller.getReservationList();
		
		Reservation newReservation = new Reservation("김혜경", "모가디슈", "메가박스", "2021-07-28", 121, "2021-08-05");
		
		controller.insertReservation(newReservation);
		reservationCheck("추가");
		
		System.out.println("04-1. 추가 후 모든 예약자 검색");
		controller.getReservationList();
		
		
//		--------------------------------------------------------------------------
		
//		예약자 정보 이름으로 검색 후 수정 / 수정 전 검색 / 수정 후 검색
		System.out.println("\n*** 04. 예약자 정보 이름으로 검색 및 수정, 수정 후 프로젝트 검색 ***");
		System.out.println("04-1. 수정 전 예약자 검색");
		controller.getReservation("플레이");
		
		controller.updateReservation("플레이", "블랙 팬서");
		reservationCheck("수정");
		
		System.out.println("\n04-2. 수정 후 예약자 검색");
		controller.getReservation("플레이");


//		--------------------------------------------------------------------------
		
//		예약자 정보 이름으로 검색 후 삭제 / 수정 전 검색 / 수정 후 검색
		System.out.println("\n*** 08. 홍길동 예약자 삭제 후 삭제한 예약자 검색 ***");
		System.out.println("08-1. 삭제전 예약자 검색");
		controller.getReservation("홍길동");
	
		controller.deleteReservation("홍길동");
		reservationCheck("삭제");
		
		System.out.println("\n08-2. 삭제 후 예약자 검색 ");
		controller.getReservation("홍길동");
	}
}
