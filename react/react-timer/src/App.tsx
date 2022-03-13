import React from 'react';
import { Route, Routes } from 'react-router';
import './App.scss';
import { ClickCounter } from './ClickCounter';
import { FunctionsProvider } from './FunctionsProvider';
import { Timer } from './Timer';

function App() {
  return (
    <div className="App">
        <Routes>
            <Route path="/" element={<FunctionsProvider />}></Route>
            <Route path="click-counter" element={<ClickCounter initial={0}/>}></Route>
            <Route path="timer" element={<Timer />}></Route>
        </Routes>
    </div>
  );
}

export default App;
