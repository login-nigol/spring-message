import React, { useEffect, useState } from 'react';
import axios from 'axios';

// Этот компонент получает список сообщений с сервера и отображает их в виде списка.
const MessageList = () => {
    const [messages, setMessages] = useState([]);

    useEffect(() => {
        axios.get('/api/messages')
            .then(response => setMessages(response.data))
            .catch(error => console.error(error));
    }, []);

    return (
        <div className="container mt-5">
            <h2>Received Messages</h2>
            <ul className="list-group">
                {messages.map(message => (
                    <li className="list-group-item" key={message.id}>
                        <strong>From:</strong> {message.fromEmail} <br />
                        <strong>Text:</strong> {message.text} <br />
                        <strong>Date:</strong> {new Date(message.sentDate).toLocaleString()}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default MessageList;
