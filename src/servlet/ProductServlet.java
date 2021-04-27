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

import model.Product;
import model.ProductLogic;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//商品一覧取得
		ProductLogic bo = new ProductLogic();
		List<Product> productList = bo.findAll();
		//商品一覧保存
		HttpSession session = request.getSession();
		session.setAttribute("productList", productList);

		//画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメータ取得
		int productId = Integer.parseInt(request.getParameter("productId"));
		ProductLogic bo = new ProductLogic();
		Product product = bo.findOne(productId);

//		if (product.equals(null)){
//			forwardPass = "/WEB-INF/jsp/productFalse.jsp";
//		}else {
//			forwardPass = "/WEB-INF/jsp/product.jsp";
//		}
		//sessionパラメータ保存
		HttpSession session = request.getSession();
		session.setAttribute("product", product);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/product.jsp");
		dispatcher.forward(request, response);
	}

}
