# Crypto WebSocket Application

## Overview

This application connects to a WebSocket server to receive cryptocurrency order book updates. It displays the symbol, volume change, and volume in a table, updating every 10 seconds. The application is built using HTML, JavaScript, and jQuery, with the WebSocket connection managed by the STOMP.js library.

## Features

- Connect to a WebSocket server
- Subscribe to cryptocurrency order book updates
- Display order book updates in a tabular format
- Automatically update the table every 10 seconds
- Show the time of each update

## Prerequisites

- WebSocket server running at `ws://localhost:8080/crypto-websocket`
- STOMP.js library
- jQuery library
- Bootstrap CSS for styling

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/crypto-websocket-app.git
   cd crypto-websocket-app

Acknowledgments
STOMP.js for the WebSocket client library.
Bootstrap for the CSS framework.
jQuery for simplifying JavaScript code.
