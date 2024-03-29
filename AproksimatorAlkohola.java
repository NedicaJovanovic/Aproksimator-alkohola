package alkohol;

public class AproksimatorAlkohola {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodo�li u alko aproksimator 9000!");
		
		System.out.print("Unsesite va�u te�inu (kg): ");
		double kg = sc.nextDouble();
		
		System.out.print("Unesite va� pol (M:0/�:1): ");
		int pol = sc.nextInt();
		
		while(pol!=0 && pol!=1) {
			System.err.print("Gre�ka u unosu, molim pokusajte ponovo: ");
			pol = sc.nextInt();
		}
		
		double r = 0.68;
		if(pol==1)
			r = 0.55;
		
		System.out.print("�ta ste i koliko popili (id_pica kolicina_u_ml): ");
		int id = sc.nextInt();
		double procenat, sum_alc_ml = 0;
		while(id!=-1) {
			switch(id) {
				case 0: procenat = sc.nextDouble() / 100; break;
				case 1: procenat = 0.5; break;
				case 2: procenat = 0.4; break;
				case 3: procenat = 0.047; break;
				case 4: procenat = 0.11; break;
				default: 
					System.err.println("Gre�ka, �eljeni id nije u bazi podataka. Poku�ajte ponovo");
					id=sc.nextInt();
					continue;
			}
			
			double kol = sc.nextDouble();
			sum_alc_ml += kol*procenat;
			id = sc.nextInt();
		}
		
		double BAC = sum_alc_ml / (kg*1000*r) * 1000;
		
		
		String naziv = "Dozvoljena alkoholisanost";
		String kazna = "Bez kazne";
		int poeni = 0;
		int zabrana = 0;
		
		if(BAC>0.2 && BAC<=0.5) {
			naziv = "Umerena alkoholisanost";
			kazna = "10.000din";
			poeni = 0;
			zabrana = 0;
		}else if(BAC>0.5 && BAC<=0.8) {
			naziv = "Srednja alkoholisanost";
			kazna = "10.000-20.000din";
			poeni = 6;
			zabrana = 3;
		}else if(BAC>0.8 && BAC<=1.2) {
			naziv = "Visoka alkoholisanost";
			kazna = "20.000-40.000din";
			poeni = 8;
			zabrana = 4;
		}else if(BAC>1.2 && BAC<=1.6) {
			naziv = "Te�ka alkoholisanost";
			kazna = "100.000-120.000din";
			poeni = 9;
			zabrana = 8;
		}else if(BAC>1.6 && BAC<=2.0) {
			naziv = "Te�ka alkoholisanost";
			kazna = "100.000-120.000din";
			poeni = 14;
			zabrana = 8;
		}else if(BAC>2.0) {
			naziv = "Potpuna alkoholisanost";
			kazna = "30-60 dana zatvora";
			poeni = 15;
			zabrana = 9;
		}
		
		
		System.out.println("-----------------------------");
		System.out.printf("BAC: %.2f - %s \n", BAC, naziv);
		System.out.println("-----------------------------");
		System.out.println("Kazna: " + kazna);
		System.out.println("Kazneni poeni: " + poeni);
		System.out.println("Zabrana vo�nje: " + zabrana + "meseci");
		System.out.println("-----------------------------");
		
		if(BAC>0.2)
			System.out.println("Uzmite autobus!");
	}
}

