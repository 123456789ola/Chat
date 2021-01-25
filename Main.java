package ua.kiev.prog;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String login = "";
		String parol = "";
		System.out.println("напиши 1 если хочешь зарегистрироваться и 2 если зарегистрирован");
		int choose = scanner.nextInt();
		try{
			if (choose == 1){
				System.out.println("введи логин");
				login = scanner.nextLine();
				System.out.println(login);
				System.out.println("введи пароль");
				parol = scanner.nextLine();
				Thread th = new Thread(new GetThread());
				th.setDaemon(true);
				th.start();
				Message m = new Message(login,parol);
				 int res = m.send(Utils.getURL()+"/login");
				if ( res != 200){
					System.out.println("Error");
				}





			}
			else if (choose==2){

				System.out.println("enter your login");
				login = scanner.nextLine();
				System.out.println("enter your parol");
				parol = scanner.nextLine();
				Thread th = new Thread(new GetThread());
				th.setDaemon(true);
				th.start();






			}
			 else {
			 	System.out.println("не верный ввод");
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}



		//try {
			//System.out.println("Enter your login: ");
			//String login = scanner.nextLine();
	
			//Thread th = new Thread(new GetThread());
			//th.setDaemon(true);
			//th.start();

            //System.out.println("Enter your message: ");
			//while (true) {
			//	String text = scanner.nextLine();
			//	if (text.isEmpty()) break;

			//	Message m = new Message(login, text);
			//	int res = m.send(Utils.getURL() + "/add");

			//	if (res != 200) { // 200 OK
			//		System.out.println("HTTP error occured: " + res);
			//		return;
			//	}
			//}
		//} catch (IOException ex) {
		//	ex.printStackTrace();
		//} finally {
		//	scanner.close();
		//}
	}

