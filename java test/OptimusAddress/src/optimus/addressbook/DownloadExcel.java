package optimus.addressbook;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class DownloadExcel
 */
@WebServlet("/downloadexcel")
public class DownloadExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 * Used for downloading file in csv format
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger log =  Logger.getLogger(DownloadExcel.class);
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		HttpSession session = request.getSession();
		Address address;
		address =(Address) session.getAttribute("Address");
		FileWriter file = new FileWriter("address.csv");
		file.append(address.getFname()+","+address.getLname()+","+address.getPhoneNo()+","+address.getAddress()+","+address.getEmail());
		file.close();
		 response.setContentType("text/csv");
		 response.setHeader("Content-Disposition", "attachment; filename=\"address.csv\"");
		try{	
				log.info("Downloading");
		        OutputStream outputStream = response.getOutputStream();
		        BufferedReader in = new BufferedReader(new FileReader("address.csv"));
		        String input;
		        StringBuffer out = new StringBuffer();
		        while((input = in.readLine()) != null){
		        	out.append(input);
		        }
		        outputStream.write(input.getBytes());
		        outputStream.flush();
		        outputStream.close();
		        log.info("Downloaded");
		} catch(Exception exception) {
		     log.error("Download failed. "+exception.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
	}

}
