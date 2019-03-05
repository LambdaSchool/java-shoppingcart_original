import { Card, Button, Radio } from "antd";
import { useState } from "react";
import styled from "styled-components";
import LoginForm from "../components/LoginForm";
import SignupForm from "../components/SignupForm";
const AuthenticationPage = () => {
  const SIGNUP = "signup";
  const LOGIN = "login";
  const [tab, setTab] = useState(SIGNUP);
  console.log(tab);
  return (
    <AuthWrapper>
      {(() => {
        if (tab === SIGNUP) {
          return <SignupForm />;
        } else {
          return <LoginForm />;
        }
      })()}
      <Radio.Group value={tab}>
        <Radio.Button value={SIGNUP} onClick={() => setTab(SIGNUP)}>
          Signup
        </Radio.Button>
        <Radio.Button value={LOGIN} onClick={() => setTab(LOGIN)}>
          Login
        </Radio.Button>
      </Radio.Group>
    </AuthWrapper>
  );
};

const AuthWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  max-width: 800px;
  width: 100%;
  margin: 0 auto;
`;
export default AuthenticationPage;
