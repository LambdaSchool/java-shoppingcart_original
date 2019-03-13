package com.abrahambueno.javashoppingcart.controllers;

import com.abrahambueno.javashoppingcart.models.Cart;
import com.abrahambueno.javashoppingcart.models.CartItems;
import com.abrahambueno.javashoppingcart.models.ProductList;
import com.abrahambueno.javashoppingcart.repositories.CartItemsRepository;
import com.abrahambueno.javashoppingcart.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/cart/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartController {
    @Autowired
    public CartRepository cartrepos;
    @Autowired
    public CartItemsRepository cartitems;

    // might not allow it
    @GetMapping("/items")
    public List<Cart> getAllItems() {
        return cartrepos.findAll();
    }
    @GetMapping("/{cartid}")
    public Cart getCartById(@PathVariable long cartid) throws URISyntaxException {
        return cartrepos.findById(cartid).get();
    }
    @GetMapping("/shopper/{shopperid}")
    public Cart getCartByShopperId(@PathVariable long shopperid) throws URISyntaxException {
        return cartrepos.findByShopperid(shopperid);
    }
    @PostMapping("/createcart/{shopperid}")
    public Cart createCart(@PathVariable long shopperid) throws URISyntaxException {
        Cart newCart = new Cart();
        newCart.setShopperid(shopperid);
        return cartrepos.save(newCart);
    }
    @PostMapping("/add/{cartid}/{shopperid}/{productid}/{quantity}")
    public Set<ProductList> addProductToCart(@PathVariable long cartid, @PathVariable long shopperid, @PathVariable long productid, @PathVariable int quantity) throws URISyntaxException {
        // the cart to add the items
        var addToCart = cartrepos.findById(cartid);
        // check if the cart exists
        if (addToCart.isPresent()) {
            // check the productid to the database
            var productPresent = cartitems.checkValuePair(productid);
            // check if the product is present in the cart
            if (productPresent != null) {
                // get productid
                long productidTwo = cartitems.returnCartItem(productid).getCartitemsid();
                // get the cartitem
                var updateCartItems = cartitems.findById(productidTwo);
                // update quantity on CartItems
                updateCartItems.get().setQuantity(updateCartItems.get().getQuantity() + quantity);
                // save cart changes
                cartitems.save(updateCartItems.get());
            } else {
                // initiate new Object
                CartItems newCartItem = new CartItems();
                // set required variables, data
                newCartItem.setQuantity(quantity);
                newCartItem.setProductid(productid);
                newCartItem.setCartidinsert(cartid);
                newCartItem.setAsdf(addToCart.get());
                newCartItem.setShopperid(shopperid);
                // save CartItesm object
                cartitems.save(newCartItem);
            }
            // update quantity on Cart
            addToCart.get().setQuantity(addToCart.get().getQuantity() + quantity);
            // save changes on Cart
            cartrepos.save(addToCart.get());
            Object productInCart = cartrepos.checkValue(cartid, productid);
            if (productInCart == null) {
                cartrepos.addProductToCart(cartid, productid);
            }
            return cartrepos.findById(cartid).get().getProducts();
        } else {
            return null;
        }
    }
    @PutMapping("/update/{cartid}/{shopperid}/{productid}/{quantity}")
    public Set<ProductList> changeProductToCart(@PathVariable long cartid, @PathVariable long shopperid, @PathVariable long productid, @PathVariable int quantity) throws URISyntaxException {
        // the cart to add the items
        var addToCart = cartrepos.findById(cartid);
        // check if the cart exists
        if (addToCart.isPresent()) {
            // check the productid to the database
            var productPresent = cartitems.checkValuePair(productid);
            // check if the product is present in the cart
            if (productPresent != null) {
                // get productid
                long productidTwo = cartitems.returnCartItem(productid).getCartitemsid();
                // get the cartitem
                var updateCartItems = cartitems.findById(productidTwo);
                // update quantity on CartItems
                int olderQuantityOfProduct = updateCartItems.get().getQuantity();
                // update the quantity of the cart
                if (olderQuantityOfProduct > quantity) {
                    // quantity went down
                    int subtract = olderQuantityOfProduct - quantity;
                    // updating cart
                    addToCart.get().setQuantity(addToCart.get().getQuantity() - subtract);
                    cartrepos.save(addToCart.get());
                    // updating item in cart
                    updateCartItems.get().setQuantity(updateCartItems.get().getQuantity() - subtract);
                    cartitems.save(updateCartItems.get());
                } else if (olderQuantityOfProduct < quantity) {
                    // quantity went up
                    int add = quantity - olderQuantityOfProduct;
                    // update cart
                    addToCart.get().setQuantity(addToCart.get().getQuantity() + add);
                    cartrepos.save(addToCart.get());
                    // update item in cart
                    updateCartItems.get().setQuantity(updateCartItems.get().getQuantity() + add);
                    cartitems.save(updateCartItems.get());
                } else {
                    // no change in quantity, odd
                }
//                updateCartItems.get().setQuantity(quantity);
//                // save cart changes
//                cartitems.save(updateCartItems.get());
            } else {
                // initiate new Object
                CartItems newCartItem = new CartItems();
                // set required variables, data
                newCartItem.setQuantity(quantity);
                newCartItem.setProductid(productid);
                newCartItem.setCartidinsert(cartid);
                newCartItem.setAsdf(addToCart.get());
                newCartItem.setShopperid(shopperid);
                // save CartItesm object
                cartitems.save(newCartItem);
                // update quantity on Cart
                addToCart.get().setQuantity(addToCart.get().getQuantity() + quantity);
                // save changes on Cart
                cartrepos.save(addToCart.get());
            }
            Object productInCart = cartrepos.checkValue(cartid, productid);
            if (productInCart == null) {
                cartrepos.addProductToCart(cartid, productid);
            }
            return cartrepos.findById(cartid).get().getProducts();
        } else {
            return null;
        }
    }


    // deletes all items from specific cart
    @DeleteMapping("/delete/cart/{cartid}")
    public Cart deleteCartById(@PathVariable long cartid) throws URISyntaxException {
        var deleteCart = cartrepos.findById(cartid);
        if (deleteCart.isPresent()) {
            cartrepos.deleteById(cartid);
            cartrepos.deleteAllProductsFromCart(cartid);
            return deleteCart.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/product/{cartid}/{productid}")
    public String deleteProductFromCart(@PathVariable long cartid, @PathVariable long productid) {
        var updateCart = cartrepos.findById(cartid);
        if (updateCart.isPresent()) {
            cartrepos.deleteProductFromCart(cartid, productid);
            updateCart.get().setQuantity(updateCart.get().getQuantity() - 1);
        } else {
            return null;
        }

        return "Success";
    }

    // update quantity of an item in the cart?
//    @PutMapping("/update/{cartid}")
//    public Cart changeCartById(@RequestBody Cart cart, @PathVariable long cartid) throws URISyntaxException {
//        var updateCart = cartrepos.findById(cartid);
//        if (updateCart.isPresent()) {
//            if (cart.getProducts() == null) {
//                cart.setProducts(updateCart.get().getProducts());
//            }
//            cart.setCartid(cartid);
//            cartrepos.save(cart);
//            return cart;
//        } else {
//            return null;
//        }
//    }
}
