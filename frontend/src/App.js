// import logo from './logo.svg';
import './App.css';
import React from "react";
import AuthenticationPage from './authenticationPage';

export const headers = { 
  authorization: {
      'x-api-key': 'ROhDefLTvE9WkWAYyBULD86cNpB2HWKL4fTJL3WX'
  }

}

export function App() {  return <AuthenticationPage/>
}
