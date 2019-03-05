import styled from "styled-components";
import { Menu, Dropdown, Button, Icon } from "antd";
const MeanCoffeeHeader = () => {
  return (
    <MeanCoffeeWrapper>
      <Title>
        Mean!
        <br /> <Emphasis>Mean! Coffee Beans</Emphasis>
      </Title>
      <Dropdown overlay={menu}>
        <MenuBtn>Menu</MenuBtn>
      </Dropdown>
    </MeanCoffeeWrapper>
  );
};
const menu = (
  <Menu>
    <Menu.Item key="1">
      <Icon type="user" />
      User Profile
    </Menu.Item>

    <Menu.Item key="2">
      <Icon type="alert" />
      Light/Dark
    </Menu.Item>
  </Menu>
);
const MeanCoffeeWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background: ${props => props.theme.black};
  padding: 0.5em;
`;
const Emphasis = styled.strong`
  font-size: 1.6rem;
`;
const Title = styled.h1`
  color: ${props => props.theme.white};
  font-weight: 500;
  font-size: 1.4rem;
  line-height: 1.3;
  margin-bottom: 0;
`;

const MenuBtn = styled(Button)`
  display: flex;
  justify-content: center;
  align-items: center;
  background: ${props => props.theme.orange};
  color: ${props => props.theme.white};
  padding: 0.1em 0.5em;
  font-size: 1.4rem;
  border: none;
`;

export default MeanCoffeeHeader;
