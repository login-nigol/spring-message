import React, { useState } from 'react';
import axios from 'axios';

// Этот компонент отвечает за отправку нового сообщения. Он использует axios для отправки данных на сервер.
const SendMessage = () => {
    const [toEmail, setToEmail] = useState('');
    const [text, setText] = useState('');

    const sendMessage = () => {
        axios.post('/api/messages', { toEmail, text })
            .then(() => {
                setToEmail('');
                setText('');
                alert('Message sent!');
            })
            .catch(error => console.error(error));
    };

    return (
        <div className="container mt-5">
            <h2>Send Message</h2>
            <div className="form-group">
                <label>Recipient Email</label>
                <input type="email" className="form-control" value={toEmail} onChange={e => setToEmail(e.target.value)} />
            </div>
            <div className="form-group">
                <label>Message</label>
                <textarea className="form-control" value={text} onChange={e => setText(e.target.value)} />
            </div>
            <button className="btn btn-primary mt-3" onClick={sendMessage}>Send</button>
        </div>
    );
};

export default SendMessage;
