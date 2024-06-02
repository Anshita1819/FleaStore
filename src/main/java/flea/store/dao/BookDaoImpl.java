package flea.store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import flea.store.pojos.Cart;
import flea.store.pojos.SellBook;


public class BookDaoImpl implements BookDao {
	private final static String DRIVER="com.mysql.cj.jdbc.Driver";
	private final static String DB_URL="jdbc:mysql://localhost:3306/minor_project";
	private final static String USER="root";
	private final static String PASSWORD="Indore@123";
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		return DriverManager.getConnection(DB_URL,USER,PASSWORD);
		
	}

	@Override
	public List<SellBook> buyBook() {
		List<SellBook> bookList=new ArrayList<SellBook>();

		try(Connection con=getConnection();
				Statement stmt=con.createStatement();
				){
			ResultSet rSet=stmt.executeQuery("SELECT * FROM sell_book");
			while(rSet.next())
			{
				//`_id`, `book_name`, `author_name`, `book_edition_year`, `category`, `price`, `book_language`, `description`, `book_photo`
			    int id=rSet.getInt("_id");
				String name=rSet.getString("book_name");
			    String author=rSet.getString("author_name");
			    int date=rSet.getInt("book_edition_year");
			    String category=rSet.getString("category");
			    double price=rSet.getDouble("price");
			    String language=rSet.getString("book_language");
			    String description=rSet.getString("description");
			    byte[] img=rSet.getBytes("book_photo");
			    
			    SellBook sellBook=new SellBook(id,name,author,date,category,price,language,description,img);
			    bookList.add(sellBook);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bookList;
	}

	@Override
	public SellBook saveBook(int id) {
		SellBook sellBook=new SellBook();
		try(
				Connection con=getConnection();
				PreparedStatement pStmt=con.prepareStatement("SELECT * FROM sell_book WHERE _id=?");
				){
			pStmt.setInt(1, id);
			ResultSet rSet=pStmt.executeQuery();
			if(rSet.next()) {
				
				String name=rSet.getString("book_name");
			    String author=rSet.getString("author_name");
			    int date=rSet.getInt("book_edition_year");
			    String category=rSet.getString("category");
			    double price=rSet.getDouble("price");
			    String language=rSet.getString("book_language");
			    String description=rSet.getString("description");
			    byte[] img=rSet.getBytes("book_photo");
			    sellBook.setBookName(name);
			    sellBook.setAuthorName(author);
			    sellBook.setBookEditionYear(date);
			    sellBook.setBookLanguage(language);
			    sellBook.setCategory(category);
			    sellBook.setPrice(price);
			    sellBook.setDescription(description);
			    sellBook.setBookPhoto(img);
			
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sellBook;
}



	@Override
	public List<Cart> addToCart(ArrayList<Cart> cartList) {
		List<Cart> books=new ArrayList<Cart>();
        Cart cart= new Cart();
		try( Connection con=getConnection();
        	 PreparedStatement pStmt=con.prepareStatement("SELECT * FROM sell_book WHERE _id=?");	
        		)
        {
        	if(cartList.size()>0) {
        		for(Cart c:cartList) {
        			pStmt.setInt(1, c.getId());
        			ResultSet rSet=pStmt.executeQuery();
        			if(rSet.next()) {
        				int id=rSet.getInt("_id");
        				String name=rSet.getString("book_name");
        			    
        			    String category=rSet.getString("category");
        			    double price=rSet.getDouble("price");
        			    cart.setId(id);
        			    cart.setName(name);
        			    cart.setCategory(category);
        			    cart.setPrice(price*c.getQuantity());
        			    cart.setQuantity(c.getQuantity());
        			    books.add(cart);
        			    
        			
        			}
        		}
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return books;
	}
}

		
	


