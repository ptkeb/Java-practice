package movie.view;

import movie.controller.MovieController;

public class StartView {

	public static void main(String[] args) {
		
		MovieController controller = MovieController.getInstance();
		
//		��� Movie, Theater, Reservation List �˻�
		System.out.println("\n*** 01. ��� Movie �˻� ***");
		controller.getMovieList();	
		
		System.out.println("\n*** 01. ��� Theater �˻� ***");
		controller.getTheaterList();	
		
		System.out.println("\n*** 01. ��� Reservation �˻� ***");
		controller.getReservationList();	
	
//		--------------------------------------------------------------------------
		
//		Ư�� ������ �ϳ��� Movie, Theater, Reservation �˻�
		System.out.println("\n*** 02. ��ȭ �������� Movie �˻� ***");
		controller.getMovie("�� ������");
		
		System.out.println("\n*** 02. �󿵰� �̸����� Theater �˻� ***");
		controller.getTheater("CGV");
		
		System.out.println("\n*** 02. ������ �̸����� Reservation �˻� ***");
		controller.getReservation("���ھ�");
		
		System.out.println("\n*** 03. �������ϴ� Movie �˻� ***");
		controller.getMovie("Ű�ٸ�������");
		
		System.out.println("\n*** 03. �������ϴ� Theater �˻� ***");
		controller.getTheater("CGV����");
		
		System.out.println("\n*** 03. �������ϴ� Reservation �˻� ***");
		controller.getReservation("�Ȼ�");
		
//		--------------------------------------------------------------------------
		
//		������ ���� �̸����� �˻� �� ���� / ���� �� �˻� / ���� �� �˻�
		System.out.println("\n*** 04. ������ ���� �̸����� �˻� �� ����, ���� �� ������Ʈ �˻� ***");
		System.out.println("04-1. ���� �� ������ �˻�");
		controller.getReservation("�÷���");
		
		controller.updateReservation2("�÷���", "�� �Ҽ�");
		
		System.out.println("\n04-2. ���� �� ������ �˻�");
		controller.getReservation("�÷���");


//		--------------------------------------------------------------------------
		
//		������ ���� �̸����� �˻� �� ���� / ���� �� �˻� / ���� �� �˻�
		System.out.println("\n*** 08. ȫ�浿 ������ ���� �� ������ ������ �˻� ***");
		System.out.println("08-1. ������ ������ �˻�");
		controller.getReservation("ȫ�浿");
		
		controller.deleteReservation2("ȫ�浿");
		
		System.out.println("\n08-2. ���� �� ������ �˻� ");
		controller.getReservation("ȫ�浿");
	}
}
