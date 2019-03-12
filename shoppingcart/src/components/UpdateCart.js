import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import {
  createNewUser,
  loginUser,
  setShopperId,
  getUserInfo
} from "../actions/userCredentials";
import { getProductList, createNewProduct } from "../actions/productList";
import { getShopperCart, createCart, addItemToCart } from "../actions/cart";

export class UpdateCart extends Component {
  constructor(props) {
    super(props);

    this.state = {
      items: new Map(),
      url: []
    };
  }

  componentDidMount = () => {
    this.props.getProductList();
    this.props.getUserInfo();
  };

  handleAdd = index => {
    const productid = this.props.product_list[index].productid;
    const update = this.state.items;
    // create cart if there's none
    if (this.props.shopper_cart === null) {
      this.props.createCart(this.props.set_user_info.shopperxyz.shopperid);
    }
    // map productid to quantity
    if (update.get(productid) === undefined) {
      update.set(productid, 1);
    } else {
      update.set(productid, update.get(productid) + 1);
    }
    this.setState({ items: update });
  };

  sendOrder = () => {
    // Go over map object to get productid and quantity
    // Add the products to the cart
    // Send this as an order
    const shopperid = localStorage.getItem("shopperid");
    const baseURL = "http://localhost:2019/cart/";
    const url = [];
    // if (this.state.url[0] === undefined) {
    const mapObject = this.state.items;
    for (let [k, v] of this.state.items) {
      url.push(
        `${baseURL}add/${this.props.shopper_cart.cartid}/${shopperid}/${k}/${v}`
      );
      mapObject.delete(k);
    }
    // }
    if (url[0] !== undefined) {
      this.props.addItemToCart(url.shift());
      this.setState({ url: url });
    }
  };
  iterateUrl = () => {
    const url = this.state.url;
    console.log("Lenght:", url.length);
    const value = url.shift();
    this.setState({ url: url });
    this.props.addItemToCart(value);
    // url.shift();
  };
  componentDidUpdate(prevProps, prevState) {
    if (this.state.url[0] !== undefined) {
      this.iterateUrl();
    }
    if (prevProps.set_user_info !== this.props.set_user_info) {
      console.log("FIring getShopperCart");
      this.props.getShopperCart(this.props.set_user_info.shopperxyz.shopperid);
    }
    if (prevProps.cart !== this.props.cart) {
      this.props.getShopperCart(this.props.set_user_info.shopperxyz.shopperid);
    }
  }

  render() {
    if (this.props.product_list === null) {
      return (
        <div>
          <h3>Test</h3>
        </div>
      );
    } else {
      console.log("State: ", this.state.items);

      return (
        <div>
          {this.props.product_list.map((each, i) => {
            return (
              <div
                style={{
                  width: "50%",
                  marginLeft: "25%",
                  border: "2px solid red",
                  display: "inline-flex"
                }}
                key={each + i}
              >
                <div>
                  <h3>{each.name}</h3>
                  <h3>{each.description}</h3>
                  <h3>{each.price}</h3>
                  <h3>{each.quantity}</h3>
                </div>
                <button onClick={() => this.handleAdd(i)}>Add Item</button>
              </div>
            );
          })}
          <button onClick={this.sendOrder}>Send Order </button>
        </div>
      );
    }
  }
}

const mapStateToProps = state => ({
  product_list: state.productList.product_list,
  new_product: state.productList.new_product,
  shopper_cart: state.cart.shopper_cart,
  set_user_info: state.userCredentials.set_user_info,
  cart: state.cart.cart
});

const mapDispatchToProps = state => {};

export default connect(
  mapStateToProps,
  {
    getProductList,
    createNewProduct,
    getUserInfo,
    createCart,
    addItemToCart,
    getShopperCart
  }
)(UpdateCart);