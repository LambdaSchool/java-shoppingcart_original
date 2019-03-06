import styled from "styled-components";
import ItemCard from "./ItemCard";

const ItemCardList = () => {
  return (
    <ItemsWrapper>
      <ItemCard />
      <ItemCard />
    </ItemsWrapper>
  );
};
const ItemsWrapper = styled.div`
  display: flex;
  flex-direction: column;
  position: relative;
  width: 100%;
  z-index: -1;
  margin: 100px 0 0 0;
`;
export default ItemCardList;
