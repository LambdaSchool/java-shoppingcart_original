import styled from "styled-components";
import MeanCoffeeHeader from "../components/shop-components/MeanCoffeeHeader";
import CartFooter from "../components/shop-components/CartFooter";

const ShopPage = () => {
  return (
    <ShopWrapper>
      <MeanCoffeeHeader />
      <CartFooter />
    </ShopWrapper>
  );
};

const ShopWrapper = styled.div``;
export default ShopPage;
