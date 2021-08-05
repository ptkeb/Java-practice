package movie.model;

import java.util.ArrayList;
import java.util.HashMap;

import movie.model.dto.Movie;
import movie.model.dto.Theater;
import movie.model.dto.Reservation;


public class MovieModel {
	private static MovieModel instance = new MovieModel();
	
	private static ArrayList<Movie> movieList = new ArrayList<Movie>();
	private static ArrayList<Theater> theaterList = new ArrayList<Theater>();
	private static ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	
	private static HashMap<Theater, Movie>movieInfo = new HashMap<>();
	
	static{
		
		// ������ �̸�, ��ȭ ����, �󿵰� �̸�, �� ��¥, ����Ÿ��, ���� ��¥ 
		Reservation reservLis1= new Reservation("ȫ�浿", "�𰡵�", "�ް��ڽ�", "2021-07-28", 121, "2021-08-27");
		Reservation reservLis2 = new Reservation("���ھ�", "���� ���̺�2", "CGV", "2021-07-21", 107, "2021-08-15");
		Reservation reservLis3 = new Reservation("�÷���", "�� ������", "�Ե��ó׸�", "2021-07-07", 134, "2021-08-26");
		Reservation reservLis4 = new Reservation("����", "����", "����Q", "2021-07-14", 131, "2021-07-30");
		Reservation reservLis5 = new Reservation("�����", "���� ũ����", "���ѱ���", "2021-07-28", 127, "2021-08-04");
		Reservation reservLis6 = new Reservation("����", "�츮, ��", "���̾ؽó׸�", "2021-07-28", 95, "2021-08-06");
		Reservation reservLis7 = new Reservation("���ϳ�", "���̽� �ε�", "�Ƹ����ó׼���", "2021-07-21", 110, "2021-08-15");
		Reservation reservLis8 = new Reservation("��س�", "�ɴٹ� ���� ����� �ߴ�", "��ȭ�����־�", "2021-07-14", 123, "2021-08-31");
		Reservation reservLis9 = new Reservation("������", "�Ǵн�", "��ȭ������", "2021-07-22", 98, "2021-08-16");
		Reservation reservLis10 = new Reservation("��Ź��", "���:������", "���ֽó׸�Ÿ��", "2021-07-28", 109, "2021-08-31");
		reservationList.add(reservLis1);
		reservationList.add(reservLis2);
		reservationList.add(reservLis3);
		reservationList.add(reservLis4);
		reservationList.add(reservLis5);
		reservationList.add(reservLis6);
		reservationList.add(reservLis7);
		reservationList.add(reservLis8);
		reservationList.add(reservLis9);
		
		//��ȭ�� �̸�, ��ȭ�� ��ġ, �¼��� 
		Theater theaterList1 = new Theater("�ް��ڽ�" , "û��", 110);
		Theater theaterList2 = new Theater("CGV", "�Ż絿", 123);
		Theater theaterList3 = new Theater("�Ե��ó׸�", "��ġ1��", 123);
		Theater theaterList4 = new Theater("����Q", "�б�����", 65);
		Theater theaterList5 = new Theater("���ѱ���", "����2��", 854);
		Theater theaterList6 = new Theater("���̾ؽó׸�", "������", 110);
		Theater theaterList7 = new Theater("�Ƹ����ó׼���", "���", 641);
		Theater theaterList8 = new Theater("��ȭ�����־�", "����1��", 1324);
		Theater theaterList9 = new Theater("��ȭ������", "�Ͽ�2��", 341);
		Theater theaterList10 = new Theater("���ֽó׸�Ÿ��", "���ϵ�", 653);
		theaterList.add(theaterList1);
		theaterList.add(theaterList2);
		theaterList.add(theaterList3);
		theaterList.add(theaterList4);
		theaterList.add(theaterList5);
		theaterList.add(theaterList6);
		theaterList.add(theaterList7);
		theaterList.add(theaterList8);
		theaterList.add(theaterList9);
		theaterList.add(theaterList10);
		
		// ��ȭ����, ����, ���ΰ�, �帣, ������, �������, ����Ÿ��
		Movie movieList1 = new Movie("�𰡵�", "���¿�", "������", "�׼�,���", "2021-07-28", "15�� ������" , 121);
		Movie movieList2 = new Movie("���� ���̺�2" , "�� �Ʊ׶�", "�˷� ������", "�ִϸ��̼�,�ڹ̵�,����",  "2021-07-21", "��ü ������" , 107);
		Movie movieList3 = new Movie("�� ������","����Ʈ ��Ʈ����", "��Į�� ���ڽ�", "�׼�, ����, SF", "2021-07-07",  "12�� ������" , 134);
		Movie movieList4 = new Movie("����", "���� �ǻ�ٳ���", "������ ��������", "����, ������, ���", "2021-07-14", "û�ҳ� �����Ұ�", 131);
		Movie movieList5 = new Movie("���� ũ����", "�ڿ� �ݷ� ����", "����� ����", "�׼�, ����", "2021-07-28", "12�� ������", 127);
		Movie movieList6 = new Movie("�츮, ��", "�ʸ��� �޳װ�Ƽ", "�ٹٶ� ���ڹ�", "���,���/�θǽ�", "2021-07-28", "12�� ������", 95);
		Movie movieList7 = new Movie("���̽� �ε�", "������ �����", "���� �Ͻ�", "������", "2021-07-21", "12�� ������", 110);
		Movie movieList8 = new Movie("�ɴٹ� ���� ����� �ߴ�", "���� �������", "�Ƹ����� ī����", "���/�θǽ�", "2021-07-14", "12�� ������", 123);
		Movie movieList9 = new Movie("�Ǵн�",  "ũ����Ƽ�� ����Ʈ", "�ϳ� ȣ��", "���/�θǽ�/���", "2021-07-22", "12�� ������", 98);
		Movie movieList10= new Movie("���:������","����", "������", "�̽��͸�,������",  "2021-07-28", "15�� ������" , 109);
		movieList.add(movieList1);
		movieList.add(movieList2);
		movieList.add(movieList3);
		movieList.add(movieList4);
		movieList.add(movieList5);
		movieList.add(movieList6);
		movieList.add(movieList7);
		movieList.add(movieList8);
		movieList.add(movieList9);
		movieList.add(movieList10);
		
		
		// ���Ƿ� �����߽��ϴ�. movieList �� theaterList�� �߰� ���� �����մϴ�.
		movieInfo.put(theaterList1, movieList1);
		movieInfo.put(theaterList2, movieList2);
		movieInfo.put(theaterList3, movieList3);
		movieInfo.put(theaterList4, movieList4);
		movieInfo.put(theaterList5, movieList5);
		movieInfo.put(theaterList6, movieList6);
		movieInfo.put(theaterList7, movieList7);
		movieInfo.put(theaterList8, movieList8);
		movieInfo.put(theaterList9, movieList9);
		movieInfo.put(theaterList10, movieList10);
		
	}
	
	public static HashMap<Theater, Movie> movieAll()
	{
		return movieInfo;
	}
	
	public static Movie listMovies(Theater searchTheater) throws Exception
	{
		Movie movie = movieInfo.get(searchTheater);
		if (movie == null)
		{
			throw new Exception("ã���� �ϴ� ������� �����ϴ�.");
		}
		else {
			return movie;
		}

	}
	
	public static MovieModel getInstance()
	{
		return instance;
	}
	
//	public void InsertTheater(Theater newTheater)
//	{
//		theaterList.add(newTheater);
//	}
//	
//	public void InsertMovie(Movie newMovie)
//	{
//		movieList.add(newMovie);
//	}

	
	// getter, setter
	public static ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public static void setMovieList(ArrayList<Movie> movieList) {
		MovieModel.movieList = movieList;
	}

	public static ArrayList<Theater> getTheaterList() {
		return theaterList;
	}

	public static void setTheaterList(ArrayList<Theater> theaterList) {
		MovieModel.theaterList = theaterList;
	}

	public static ArrayList<Reservation> getReservationList() {
		return reservationList;
	}

	public static void setRevervationList(ArrayList<Reservation> revervationList) {
		MovieModel.reservationList = revervationList;
	}

	public static HashMap<Theater, Movie> getMovieInfo() {
		return movieInfo;
	}

	public static void setMovieInfo(HashMap<Theater, Movie> movieInfo) {
		MovieModel.movieInfo = movieInfo;
	}

	public static void setInstance(MovieModel instance) {
		MovieModel.instance = instance;
	}
}
