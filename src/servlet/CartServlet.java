package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.CartLogic;
import model.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログイン中のユーザーID取得
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");

		//Logicへ渡す
		CartLogic bo = new CartLogic();
		List<Cart> cartList = bo.findList(userId);

		//request scopeへ保存
		request.setAttribute("cartList", cartList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//商品個数を取得
		request.setCharacterEncoding("UTF-8");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		//userId,productIdをsession scopeから取得
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		Product product = (Product)session.getAttribute("product");
		int productId = product.getProductId();

		//Logicへ情報を渡す
		CartLogic bo = new CartLogic();
		boolean isAdd = bo.add(userId, productId, quantity);

		//正誤判定によりパス変更
		String forwardPass = "";
		if (isAdd) {
			forwardPass = "/WEB-INF/jsp/cart_add.jsp";
		}else{
			forwardPass = "/WEB-INF/jsp/cart_fail.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPass);
		dispatcher.forward(request, response);
	}

}
