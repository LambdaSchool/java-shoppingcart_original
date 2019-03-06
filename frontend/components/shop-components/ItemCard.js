import styled from "styled-components";
import { Card, Button } from "antd";

const ItemCard = ({ title, description, price }) => {
  return (
    <StyledCard>
      <ItemImage src={"https://via.placeholder.com/16"} />
      <ItemTextContainer>
        <ItemTitle>Green Bean</ItemTitle>
        <ItemDescription>This bean is green.</ItemDescription>
        <BuyBtn type="primary" onClick={() => console.log("bought")}>
          Buy: 19.99
        </BuyBtn>
      </ItemTextContainer>
    </StyledCard>
  );
};
const StyledCard = styled.div`
  display: flex;
  background: ${props => props.theme.white};
  width: 100%;
  padding: 0;
  margin-bottom: 24px;
`;
const ItemTextContainer = styled.div`
  width: 100%;
  height: 100%;
  padding-left: 14px;
`;

const ItemTitle = styled.h2`
  font-size: 1.6rem;
  margin-bottom: 0;
`;
const ItemDescription = styled.p`
  font-size: 1.2rem;
  margin-top: 0;
  line-height: 1.3;
`;
const ItemImage = styled.img`
  height: 100%;
  width: 35%;
`;
const BuyBtn = styled(Button)``;
export default ItemCard;
