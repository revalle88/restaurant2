import React, { Component } from 'react';

import './App.css';

import Kitchen from './components/Kitchen';
import Supply from './components/Supply';
import Storage from './components/Storage';


import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';

const App = () => (
   <Router>
        <div>
            <ul>
              <li><Link to  = "/">Kitchen Interface</Link></li>
              <li><Link to  = "/supply">Supply Interface</Link></li>
              <li><Link to  = "/storage">Storage Interface</Link></li>
   
            </ul>
            <Route exact path = "/" component = {Kitchen}/>
            <Route path = "/supply" component = {Supply}/>
            <Route path = "/storage" component = {Storage}/>
 

        </div>
        
      </Router>
);

export default App;
