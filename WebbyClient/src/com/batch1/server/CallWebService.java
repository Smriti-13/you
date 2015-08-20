package com.batch1.server;

import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

/**
 * Servlet implementation class CallWebService
 */
@WebServlet("/CallWebService")
public class CallWebService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallWebService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DispNameHandlerServiceLocator location=new DispNameHandlerServiceLocator();
		DispNameHandler dnH;
		try {
			dnH=location.getDispNameHandler();
			String output=dnH.displayMyName("Sushrut");
			System.out.println(output);
			PrintWriter out=response.getWriter();
			out.print(output);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}

}
