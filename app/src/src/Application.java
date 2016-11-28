package src;

import java.io.IOException;
import java.util.Scanner;

import src.ApiChecksum;
import src.ApiCyphering;
import Library.FileLibrary;
import Http.ApiHttp;
import ZipArchive.*;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean end = true;
		Scanner in = new Scanner(System.in);
		while (end) 
		{
			System.out.println("Witaj, wybierz jedna z opcji:");
			System.out.println("1) Sciaganiae plikow z wykorzystaniem protokolu HTTP");
			System.out.println("2) Kompresja i dekompresja plikow ZIP");
			System.out.println("3) Szyfrowanie i deszyfrowanie plikow z pomoca algorytmu AES");
			System.out.println("4) Obliczanie sum kontrolnych plikow z wykorzystaniem algorytmow MD5 i SHA");
			System.out.println("5) Wyjscie z programu");

			int choosed = in.nextInt();

			switch (choosed)
			{
			case 1:
			{
				System.out.println("podaj adres url z któego chcesz pobraæ plik");
				String url = in.next();
				ApiHttp http = new ApiHttp(url);
				System.out.println("podaj œcie¿kê zapisu pliku");
				String path = in.next();
				try {
					http.DowloadFile(path);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			case 2:
			{

			}
			break;
			case 3:
			{

			}
			break;
			case 4:
			{

			}
				break;
			case 5:
				System.exit(0);
			}

		}

	}

}
