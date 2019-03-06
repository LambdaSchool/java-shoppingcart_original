import Router from "next/router";
import styled from "styled-components";
import { Menu, Dropdown, Button, Icon, Badge, Avatar } from "antd";

const CartFooter = () => {
  return (
    <CartFooterWrapper>
      <TotalDisplay>$55.55</TotalDisplay>
      <ItemsQueueContainer>
        <Avatar shape="circle" size="small" icon="user" />
        <Avatar shape="circle" size="small" icon="user" />
      </ItemsQueueContainer>
      <CartBtn
        onClick={() =>
          Router.push({
            pathname: "/cart"
          })
        }
      >
        <Badge offset={[16, 6]} count={5} showZero={false}>
          Cart
        </Badge>
      </CartBtn>
    </CartFooterWrapper>
  );
};

const CartFooterWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  background: ${props => props.theme.black};
  padding: 0.2em;
`;
const TotalDisplay = styled.div`
  display: flex;
  justify-content: center;
  width: 7rem;
  color: ${props => props.theme.white};
`;
const ItemsQueueContainer = styled.div`
  display: flex;
  margin-right: 12px;
  background: ${props => props.theme.white};
  width: 100%;
`;

const CartBtn = styled(Button)`
  color: ${props => props.theme.white};
  background: ${props => props.theme.black};
  padding: 0.5em;
  padding-right: 2em;
  border: none;
  border-radius: 0;
  margin: 0;
  height: 100%;
`;
const CartBadge = styled(Badge)`
  background: ${props => props.theme.orange};
`;

export default CartFooter;
