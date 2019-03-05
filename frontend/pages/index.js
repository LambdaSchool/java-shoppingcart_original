import styled from "styled-components";
import { Button } from "antd";
const Home = () => {
  return (
    <PageWrapper>
      <BackgroundImage src={"../static/jumbotron-image.jpg"} />
      <MainContent>
        <Title>Mean! Mean! Coffee Beans</Title>
        <GetStartedBtn type="primary">Login / Signup</GetStartedBtn>
      </MainContent>
    </PageWrapper>
  );
};
const PageWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;
const MainContent = styled.main`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  position: absolute;
  top: 30%;
`;
const GetStartedBtn = styled(Button)`
  display: flex;
  justify-content: center;
  align-items: center;
  background: ${props => props.theme.orange};
  color: ${props => props.theme.white};
  padding: 1em;
  font-size: 3rem;
  border: none;
`;
const Title = styled.h1`
  color: ${props => props.theme.white};
  font-weight: 600;
  text-align: center;
  width: 30rem;
  margin-bottom: 5rem;
`;
const BackgroundImage = styled.img`
  filter: brightness(70%);
  /* Set rules to fill background */
  min-height: 100%;
  /* min-width: 1024px; */
  /* Set up proportionate scaling */
  width: 100%;
  height: auto;
  /* Set up positioning */
  position: fixed;
  z-index: -1000;
  top: 0;
  left: 0;
`;
export default Home;
