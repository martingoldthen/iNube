package es.upm.dit.isst.inube.dao;

public class Prueba {
	public static void main(String[] args) {
		
		/*for(int i=0;i<10000;i++) {
			int hora = (int)(Math.random()*(25-13))+13;
			double coef=0;
			switch(hora) {
				case 13:
					coef=0.7;
					break;
				case 14:
					coef=0.9;
					break;
				case 15:
					coef=1;
					break;
				case 16:
					coef=0.5;
					break;
				case 17:
					coef=0.1;
					break;
				case 18:
					coef=0;
					break;
				case 19:
					coef=0;
					break;
				case 20:
					coef=0.2;
					break;
				case 21:
					coef=0.7;
					break;
				case 22:
					coef=1;
					break;
				case 23:
					coef=0.8;
					break;
				case 24:
					coef=0.4;
					hora=0;
					break;
			}
			
			double precio = coef * Math.random()*(201-20)+20;
			int dia = (int)(Math.random()*(32-1))+1;
			int negocio = (int)(Math.random()*(100010-100000))+100000;
			//System.out.println(dia);
			
			System.out.println("INSERT INTO movimiento VALUES(0,{ts '2019-01-"+dia+" "+hora+":30:00'},127.24,103,'"+negocio+"A');");
		}*/
		int aux = 1;
		for(int i =1;i<900;i=i+3) {
			aux++;
			int dia = (int)(Math.random()*(32-1))+1;
			int hora = (int)(Math.random()*(25-13))+13;
			int edad = (int)(Math.random()*(81-11))+11;
			//System.out.println("INSERT INTO cliente VALUES("+(3368+i)+",28000,"+edad+");");
			System.out.println("INSERT INTO movimiento VALUES("+(13971+i)+",{ts '2019-01-"+dia+" "+hora+":30:00'},0,"+(3368+aux)+",'100002A');");
			System.out.println("INSERT INTO movimiento VALUES("+(13971+i+1)+",{ts '2019-01-"+dia+" "+hora+":30:00'},0,"+(3368+aux)+",'100002A');");
			System.out.println("INSERT INTO movimiento VALUES("+(13971+i+2)+",{ts '2019-01-"+dia+" "+hora+":30:00'},0,"+(3368+aux)+",'100002A');");
		}
	}	
}

