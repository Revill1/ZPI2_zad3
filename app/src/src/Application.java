package src;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import src.ApiChecksum;
import src.ApiCyphering;
import Library.FileLibrary;
import Http.ApiHttp;
import ZipArchive.*;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		while (true) 
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
				System.out.println("podaj adres url z kt�ego chcesz pobra� plik");
				String url = in.next();
				ApiHttp http = new ApiHttp(url);
				System.out.println("podaj �cie�k� zapisu pliku");
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
				System.out.println("Wybierz czy chcesz wypakowa� lub spakowa� plik (s)pakowa�/(w)ypakowa�");
				String choose = in.next();
				
				if(choose.toLowerCase().equals("s"))
				{
					System.out.println("Podaj sciezke do pliku:");
					String zipFilePath  = in.next();
					System.out.println("Podaj sciezke docelow� gdzie plik zostanie zapisany po spakowaniu:");
					String targetFilePath  = in.next();
					System.out.println("Podaj nazwe pliku:");
					String fileToZipName  = in.next();
					zipApi.Zip(zipFilePath, targetFilePath, fileToZipName);
				}
				else if(choose.toLowerCase().equals("w"))
				{
					System.out.println("Podaj sciezke pliku do rozpakowania:");
					String zipFile  = in.next();
					System.out.println("Podaj sciezke docelow� gdzie plik zostanie wypakowany:");
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
				System.out.println("Wybierz czy chcesz zaszyfrowa� czy odszyfrowa�? s/o");
				String choose = in.next();
				
				if(choose.toLowerCase().equals("s"))
				{
					System.out.println("Podaj tre�� kt�ra zostanie zaszyfrowana:");
					String strToEncrypt  = in.next();
					KeyGenerator kGen;
					try {
						kGen = KeyGenerator.getInstance("AES");
						kGen.init(128);
						SecretKey sKey = kGen.generateKey();
						byte[] key = sKey.getEncoded();
						byte[] cipher;
						cipher = ApiCyphering.encrypt(strToEncrypt, key, "AES");
						System.out.println("wygenerowany hash: " + cipher.toString());
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(choose.toLowerCase().equals("o"))
				{
					System.out.println("Podaj tre�� kt�ra zostanie zaszyfrowana:");
					
					KeyGenerator kGen;
					try {
						kGen = KeyGenerator.getInstance("AES");
						kGen.init(128);
						SecretKey sKey = kGen.generateKey();
						byte[] rawKeys = sKey.getEncoded();
						String encryptString = "string do szyfrowania";
						String algorythmType = "AES";
						byte[] toDecrypt = ApiCyphering.encrypt(encryptString, rawKeys, algorythmType);
						String afterDecrypt;
						
						afterDecrypt = ApiCyphering.decrypt(toDecrypt, rawKeys, algorythmType);
						System.out.println("po rozszyfrowaniu: " + afterDecrypt);
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			break;
			case 4:
			{
				System.out.println("Wybierz czy chcesz wykreowa� sum� kontroln� czy przetestowa�? g/t");
				String choose = in.next();
				
				if(choose.toLowerCase().equals("g"))
				{
					System.out.println("Podaj tre�� z kt�rej zostanie wygenerowana suma kontrolna:");
					String input  = in.next();
					System.out.println("Wybierz algorytm: SHA/MD5");
					String algorithm  = in.next();
					String sum = "";
					try {
						sum = ApiChecksum.createSum(input, algorithm.toUpperCase());
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("wygenerowana suma: " + sum);
				}
				else if(choose.toLowerCase().equals("t"))
				{
					System.out.println("Podaj nazwe pliku do rozpakowania:");
					String file  = in.next();
					System.out.println("Podaj sum� kontroln� jaka ma zosta� por�wnana:");
					String testChecksum  = in.next();
					System.out.println("Wybierz algorytm: SHA/MD5");
					String algorithm  = in.next();
					try {
						boolean sum = ApiChecksum.testChecksum(file, testChecksum, algorithm);
						if(sum)
						{
							System.out.println("suma kontrolna " + testChecksum + " jest zgodna");
						}
						else
						{
							System.out.println("suma kontrolna " + testChecksum + " nie jest zgodna");
						}
						
					} catch (NoSuchAlgorithmException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					break;
				}
				
			}
				break;
			case 5:
				in.close();
				System.exit(0);
			}

		}

	}

}
