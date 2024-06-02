package flea.store.dao;

import java.util.ArrayList;
import java.util.List;

import flea.store.pojos.Cart;
import flea.store.pojos.SellBook;

public interface BookDao {
          List<SellBook> buyBook();
          SellBook saveBook(int id);
          List<Cart> addToCart(ArrayList<Cart> cartList);
}
