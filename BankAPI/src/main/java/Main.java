

import com.sun.net.httpserver.HttpServer;
import model.entity.Account;
import model.dao.AccountRepository;
import model.logic.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {

		String url = "http://www.google.com/";

		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

		connection.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println("##########################################");
		System.out.println(response.toString());
		System.out.println("##########################################");




//		Service service = new Service();
//		AccountRepository accountRepository = new AccountRepository();
//		accountRepository.createIfNotExists();
//
//		Account account = new Account();
//		account.setFirstName("Ivan");
//		account.setLastName("Ivanov");
//		account.setBalance(7777);
//		account.setAccountNumber(1);
//		accountRepository.add(account);
//
//
//		int serverPort = 8000;
//		HttpServer server = null;
//		try {
//			server = HttpServer.create(new InetSocketAddress(serverPort), 0);
//
//			server.createContext("/getBalance", (exchange -> {
//				if ("GET".equals(exchange.getRequestMethod())) {
//
//
//					String respText = Long.toString(service.getBalance(account).getBalance());
//					exchange.sendResponseHeaders(200, respText.getBytes().length);
//					OutputStream output = exchange.getResponseBody();
//					output.write(respText.getBytes());
//					output.flush();
//				} else {
//					exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
//				}
//				exchange.close();
//			}));
//			server.setExecutor(null); // creates a default executor
//			server.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

}
