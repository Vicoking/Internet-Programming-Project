package com.controller;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Shopping;

public class ShoppingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShoppingController() {

	}

	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);

		Vector buylist = (Vector) session.getAttribute("cart");

		String action = request.getParameter("action");

		if (action.equals("VIEW"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("/viewShopping.jsp");
			rd.forward(request, response);
			
				
		}else
			response.sendRedirect("emptyCart.jsp");


		if (action.equals("CHECKOUT")) {
			if (buylist != null && (buylist.size() > 0)) {
				float total = 0;

				for (int index = 0; index < buylist.size(); index++)

				{
					Shopping anOrder = (Shopping) buylist.elementAt(index);
					total = total + anOrder.getPrice() * anOrder.getQuantity();
				}

				total += 0.005;
				String amount = new Float(total).toString();
				int n = amount.indexOf('.');
				amount = amount.substring(0, n + 3);
				request.setAttribute("amount", amount);
				RequestDispatcher rd = request.getRequestDispatcher("/checkoutShopping.jsp");
				rd.forward(request, response);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/emptyCart.jsp");
				rd.forward(request, response);
			}
		}

		else if (action.equals("LOGOUT")) {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/logoutShopping.jsp");
			rd.forward(request, response);

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String action = request.getParameter("action");

		Vector buylist = (Vector) session.getAttribute("cart");

		boolean match = false;
		if (action.equals("ADD")) {
			Shopping vcd = getVCD(request);
			if (buylist == null) {
				// add first vcd to the cart
				buylist = new Vector();
				buylist.addElement(vcd);
			} else {
				for (int i = 0; i < buylist.size(); i++) {
					Shopping aVCD = (Shopping) buylist.elementAt(i);
					if (aVCD.getTitle().equals(vcd.getTitle())) {
						aVCD.setQuantity(aVCD.getQuantity() + vcd.getQuantity());
						buylist.setElementAt(aVCD, i);
						match = true;
					}
				}

				if (!match)
					buylist.addElement(vcd);
			}

			session.setAttribute("cart", buylist);
			RequestDispatcher rd = request.getRequestDispatcher("/addShopping.jsp");
			rd.forward(request, response);

		} else if (action.equals("DELETE")) {
			String del = request.getParameter("delindex");
			Shopping vcd = (Shopping) buylist.elementAt((new Integer(del)).intValue());
			String title = vcd.getTitle().trim();
			int d = (new Integer(del)).intValue();
			buylist.removeElementAt(d);
			RequestDispatcher rd = request.getRequestDispatcher("/deleteShopping.jsp");
			rd.forward(request, response);
		}

	}

	void sendPage(HttpServletRequest request, HttpServletResponse response, String fileName)
			throws ServletException, IOException {
		// Get the dispatcher; it gets the main page to the user
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(fileName);

		if (dispatcher == null) {
			System.out.println("There was no dispatcher");
			// No dispatcher means the html file could not be found.
			response.sendError(response.SC_NO_CONTENT);
		} else
			dispatcher.forward(request, response);
	}

	@SuppressWarnings("removal")
	Shopping getVCD(HttpServletRequest request) {
		String myVCD = request.getParameter("VCD");
		String qty = request.getParameter("qty");
		StringTokenizer t = new StringTokenizer(myVCD, "|");
		String title = t.nextToken();
		String actor = t.nextToken();

		String price = t.nextToken();
		// price = price.replace('$',' ').trim();
		price = price.replace('R', ' ').trim();
		price = price.replace('M', ' ').trim();

		Shopping vcd = new Shopping();
		vcd.setTitle(title);
		vcd.setActor(actor);
		vcd.setPrice((new Float(price)).floatValue());
		vcd.setQuantity((new Integer(qty)).intValue());
		return vcd;
	}

}
