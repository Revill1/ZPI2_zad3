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
				ApiZipArchive zipApi = new ApiZipArchive();
				System.out.println("Wybierz czy chcesz wypakowaæ lub spakowaæ plik (s)pakowaæ/(w)ypakowaæ");
				String choose = in.next();
				
				if(choose.toLowerCase().equals("s"))
				{
					System.out.println("Podaj sciezke do pliku:");
					String zipFilePath  = in.next();
					System.out.println("Podaj sciezke docelow¹ gdzie plik zostanie zapisany po spakowaniu:");
					String targetFilePath  = in.next();
					System.out.println("Podaj nazwe pliku:");
					String fileToZipName  = in.next();
					zipApi.Zip(zipFilePath, targetFilePath, fileToZipName);
				}
				else if(choose.toLowerCase().equals("w"))
				{
					System.out.println("Podaj sciezke pliku do rozpakowania:");
					String zipFile  = in.next();
					System.out.println("Podaj sciezke docelow¹ gdzie plik zostanie wypakowany:");
					String outputFolder  = in.next();
					zipApi.Unzip(zipFile, outputFolder);
				}
				else
				{
					break;
				}
				
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
