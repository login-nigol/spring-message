import React from 'react';
import MessageList from './components/MessageList';
import SendMessage from './components/SendMessage';


// Подключение компонетнов MessageList и SendMessage.
const App = () => {
  return (
      <div>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <a className="navbar-brand" href="/">Message Service</a>
        </nav>
        <div className="container mt-4">
          <SendMessage />
          <hr />
          <MessageList />
        </div>
      </div>
  );
};

export default App;

