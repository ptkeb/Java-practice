package movie.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import movie.controller.MovieController;
import movie.model.dto.Reservation;

public class StartView {
	
	static Logger logger = Logger.getLogger("movie.view.Log4j");
	
	public static void reservationCheck(String crud) {
		System.out.println("\n---------- �α� ���� ----------");
		if(crud == "�߰�") { //������ �߰�
			logger.info("info - ������ �߰�!");
		} else if (crud == "����") {
			logger.info("info - ������ ����!");
		} else if (crud == "����") {
			logger.info("info - ������ ����!");
		} else {
			logger.info("info - ������ ��ȸ");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MovieController controller = MovieController.getInstance();
		
		System.out.println("-------- �����ϰ� ���� �޴��� �������ּ���. --------");
		System.out.println("1) �˻� \t 2) �߰� \t 3) ���� \t 4) ���� \t 5) �� ���� �� ����");
		int input = Integer.parseInt(br.readLine());
		
		// �˻�
		if(input == 1) {
			System.out.println("---------------- ������ �˻� ----------------");
			System.out.println("1) ��ü ����Ʈ �˻� \t 2) ���� �׸� �˻�");
			int subInput = Integer.parseInt(br.readLine());

			// ��ü ����Ʈ �˻�
			if(subInput == 1) {
				System.out.println("\n*** 01-1. ��� Movie �˻� ***");
				controller.getMovieList();	

				System.out.println("\n*** 01-2. ��� Theater �˻� ***");
				controller.getTheaterList();	

				System.out.println("\n*** 01-3. ��� Reservation �˻� ***");
				controller.getReservationList();
			}

			// ���� �׸� �˻�
			else if(subInput == 2) {

				System.out.println("\n*** 01-1. ��ȭ �������� Movie ���� �˻� ***");

				System.out.println("��ȭ ������ �Է����ּ���.");
				String movieTitle = br.readLine();
				controller.getMovie(movieTitle);

				System.out.println("\n*** 01-2. �󿵰� �̸����� Theater ���� �˻� ***");

				System.out.println("�󿵰� �̸��� �Է����ּ���.");
				String theaterName = br.readLine();
				controller.getTheater(theaterName);

				System.out.println("\n*** 01-3. ������ �̸����� Reservation ���� �˻� ***");

				System.out.println("������ �̸��� �Է����ּ���.");
				String name = br.readLine();
				controller.getReservation(name);
			}
		}
				
	
//		--------------------------------------------------------------------------
		
		// �߰�
		else if(input == 2) {
			System.out.println("---------------- ������ �߰� ----------------");
			
			// ���ο� ���� ���� �߰�
			System.out.println("\n*** 02. ������ ���� �߰� ***");
			System.out.println("02-1. �߰� �� ��� ������ �˻�");
			controller.getReservationList();
			
			// �ڵ����� ���� ��ȣ �ߺ����� �ʰ� �����Ͽ� �ν��Ͻ� ����
			Reservation newReservation = new Reservation("������", "�𰡵�", "�ް��ڽ�", "2021-07-28", 121, "2021-08-05");
			
			controller.insertReservation(newReservation);
			reservationCheck("�߰�");
			
			System.out.println("\n02-2. �߰� �� ��� ������ �˻�");
			controller.getReservationList();
			
			System.out.println("\n02-3. ���� ��ȣ�� �ߺ��Ǵ� ������ �߰�");
			// �������� �ߺ��Ǵ� ���� ��ȣ �Ҵ��Ͽ� �ν��Ͻ� ����
			Reservation newReservation2 = new Reservation(1, "������", "�𰡵�", "�ް��ڽ�", "2021-07-28", 121, "2021-08-05");
			controller.insertReservation(newReservation2);
			
			System.out.println("\n02-4. �߰� �� ��� ������ �˻�");
			controller.getReservationList();
			
			//������ ������ �Է��Ͽ� �߰� ����
			System.out.println("\n02-5. Ű����� ����");
			System.out.println("�� ���ο� ���� �ۼ��� �ּ���");
			System.out.println("�����ڸ�:��ȭ��:�󿵰��̸�:�󿵳�¥:����Ÿ��:���೯¥");
			Reservation newrev = controller.startReservation();
			controller.insertReservation(newrev);
			controller.getReservationList();
			reservationCheck("�߰�");
			System.out.println("\n02-6. �߰� �� ��� ������ �˻�");
			controller.getReservationList();
		}
		
//		--------------------------------------------------------------------------
		
		else if(input == 3) {
			System.out.println("---------------- ������ ���� ----------------");
			
			// ������ ���� �̸����� �˻� �� ���� / ���� �� �˻� / ���� �� �˻�
			System.out.println("\n*** 03. ������ ���� �̸����� �˻� �� ����, ���� �� ������Ʈ �˻� ***");
			System.out.println("03-1. ���� �� ������ �˻�");
			controller.getReservation("�÷���");
			
			controller.updateReservation("�÷���", "�� �Ҽ�");
			reservationCheck("����");
			
			System.out.println("\n03-2. ���� �� ������ �˻�");
			controller.getReservation("�÷���");
			
		}
		
//		--------------------------------------------------------------------------
		
		else if(input == 4) {
			System.out.println("---------------- ������ ���� ----------------");
			
			// ������ ���� �̸����� �˻� �� ���� / ���� �� �˻� / ���� �� �˻�
			System.out.println("\n*** 04. ȫ�浿 ������ ���� �� ������ ������ �˻� ***");
			System.out.println("04-1. ���� �� ������ �˻�");
			controller.getReservation("ȫ�浿");
		
			controller.deleteReservation("ȫ�浿");
			reservationCheck("����");
			
			System.out.println("\n04-2. ���� �� ������ �˻� ");
			controller.getReservation("ȫ�浿");
		}
		
//		--------------------------------------------------------------------------
		
		else if(input == 5) {
			System.out.println("---------------- �� ���� �� ���� ----------------");
			
			// ��ü �˻�
			System.out.println("\n*** 01-1. ��� Movie �˻� ***");
			controller.getMovieList();	

			System.out.println("\n*** 01-2. ��� Theater �˻� ***");
			controller.getTheaterList();	

			System.out.println("\n*** 01-3. ��� Reservation �˻� ***");
			controller.getReservationList();
			
			// ���� �׸� �˻�
			System.out.println("\n*** 01-1. ��ȭ �������� Movie ���� �˻� ***");
			controller.getMovie("�� ������");

			System.out.println("\n*** 01-2. �󿵰� �̸����� Theater ���� �˻� ***");
			controller.getTheater("�Ե��ó׸�");

			System.out.println("\n*** 01-3. ������ �̸����� Reservation ���� �˻� ***");
			controller.getReservation("���ھ�");
			
			// ���ο� ���� ���� �߰�
			System.out.println("\n*** 02. ������ ���� �߰� ***");
			System.out.println("02-1. �߰� �� ��� ������ �˻�");
			controller.getReservationList();

			// �ڵ����� ���� ��ȣ �ߺ����� �ʰ� �����Ͽ� �ν��Ͻ� ����
			Reservation newReservation = new Reservation("������", "�𰡵�", "�ް��ڽ�", "2021-07-28", 121, "2021-08-05");

			controller.insertReservation(newReservation);
			reservationCheck("�߰�");

			System.out.println("\n02-2. �߰� �� ��� ������ �˻�");
			controller.getReservationList();

			System.out.println("\n02-3. ���� ��ȣ�� �ߺ��Ǵ� ������ �߰�");
			// �������� �ߺ��Ǵ� ���� ��ȣ �Ҵ��Ͽ� �ν��Ͻ� ����
			Reservation newReservation2 = new Reservation(1, "������", "�𰡵�", "�ް��ڽ�", "2021-07-28", 121, "2021-08-05");
			controller.insertReservation(newReservation2);

			System.out.println("\n02-4. �߰� �� ��� ������ �˻�");
			controller.getReservationList();
			
			//������ ������ �Է��Ͽ� �߰� ����
			System.out.println("\n02-5. Ű����� ����");
			System.out.println("�� ���ο� ���� �ۼ��� �ּ���");
			System.out.println("�����ڸ�:��ȭ��:�󿵰��̸�:�󿵳�¥:����Ÿ��:���೯¥");
			Reservation newrev = controller.startReservation();
			controller.insertReservation(newrev);
			controller.getReservationList();
			reservationCheck("�߰�");
			
			System.out.println("\n02-6. �߰� �� ��� ������ �˻�");
			controller.getReservationList();

			// ������ ���� �̸����� �˻� �� ���� / ���� �� �˻� / ���� �� �˻�
			System.out.println("\n*** 03. ������ ���� �̸����� �˻� �� ����, ���� �� ������Ʈ �˻� ***");
			System.out.println("03-1. ���� �� ������ �˻�");
			controller.getReservation("�÷���");

			controller.updateReservation("�÷���", "�� �Ҽ�");
			reservationCheck("����");

			System.out.println("\n03-2. ���� �� ������ �˻�");
			controller.getReservation("�÷���");

			// ������ ���� �̸����� �˻� �� ���� / ���� �� �˻� / ���� �� �˻�
			System.out.println("\n*** 04. ȫ�浿 ������ ���� �� ������ ������ �˻� ***");
			System.out.println("04-1. ���� �� ������ �˻�");
			controller.getReservation("ȫ�浿");

			controller.deleteReservation("ȫ�浿");
			reservationCheck("����");

			System.out.println("\n04-2. ���� �� ������ �˻� ");
			controller.getReservation("ȫ�浿");

		}
		
		br.close();
	}
}
