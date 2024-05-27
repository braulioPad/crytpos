Overview
This application connects to a WebSocket server to receive cryptocurrency order book updates. It displays the symbol, volume change, and volume in a table, updating every 10 seconds. The application is built using HTML, JavaScript, and jQuery, with the WebSocket connection managed by the STOMP.js library.

Features
Connect to a WebSocket server
Subscribe to cryptocurrency order book updates
Display order book updates in a tabular format
Automatically update the table every 10 seconds
Show the time of each update
Prerequisites
WebSocket server running at ws://localhost:8080/crypto-websocket
STOMP.js library
jQuery library
Bootstrap CSS for styling
Getting Started
Clone the Repository:

bash
Copy code
git clone https://github.com/yourusername/crypto-websocket-app.git
cd crypto-websocket-app
Set Up the WebSocket Server:
Ensure you have a WebSocket server running at ws://localhost:8080/crypto-websocket. You can use any WebSocket server that supports STOMP.

Add a Favicon (Optional):
Place a favicon.ico file in the root directory of your web server to avoid the favicon.ico not found error.

Run the Application:
Open the index.html file in your web browser.

Usage
Connect to the WebSocket Server
Click the Connect button to establish a WebSocket connection.
Once connected, the Connect button will be disabled, and the Disconnect button will be enabled.
Send Messages
Click the Send button to start sending subscription requests for BTCUSDT and ETHUSDT every 10 seconds.
The table will update with the latest order book data, including the symbol, volume change, volume, and the time of each update.
Disconnect from the WebSocket Server
Click the Disconnect button to terminate the WebSocket connection.
The Disconnect button will be disabled, and the Connect button will be enabled.
Code Overview
HTML (index.html)
Contains the structure of the webpage, including buttons for connecting and sending messages, and a table for displaying the order book data.
JavaScript (app.js)
Manages the WebSocket connection using STOMP.js.
Handles connecting, disconnecting, and sending messages.
Updates the table with the latest order book data every 10 seconds.
CSS (main.css)
Custom styles for the table and other elements.
Example
Below is an example of what the application looks like when running:


Troubleshooting
If you encounter a favicon.ico not found error, ensure that you have placed a favicon.ico file in the root directory of your web server.
Check the browser console for any error messages related to WebSocket connections or JSON parsing.
License
This project is licensed under the MIT License. See the LICENSE file for details.

Acknowledgments
STOMP.js for the WebSocket client library.
Bootstrap for the CSS framework.
jQuery for simplifying JavaScript code.
