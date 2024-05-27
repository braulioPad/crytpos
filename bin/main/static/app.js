let stompClient = null;
let intervalId = null;

const stompConfig = {
    brokerURL: 'ws://localhost:8080/crypto-websocket',
    onConnect: (frame) => {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/books', (message) => {
            try {
                showGreeting(message.body);
            } catch (error) {
                console.error('Error parsing JSON:', error);
            }
        });
    },
    onWebSocketError: (error) => {
        console.error('Error with websocket', error);
    },
    onStompError: (frame) => {
        console.error('Broker reported error: ' + frame.headers['message']);
        console.error('Additional details: ' + frame.body);
    }
};

stompClient = new StompJs.Client(stompConfig);

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    if (intervalId) {
        clearInterval(intervalId);
        intervalId = null;
    }
    console.log("Disconnected");
}

function sendName(symbol, limit) {
    console.log('Sending message with symbol:', symbol, 'and limit:', limit); // Debug log

    stompClient.publish({
        destination: "/app/crypto",
        body: JSON.stringify({
            'symbol': symbol,
            'limit': limit
        })
    });
}

function startSendingMessages() {
    if (intervalId) {
        clearInterval(intervalId);
    }
    sendName("BTCUSDT", 100); // Send the first message immediately
    sendName("ETHUSDT", 100); // Send the second message immediately
    intervalId = setInterval(() => {
        sendName("BTCUSDT", 100);
        sendName("ETHUSDT", 100);
    }, 10000); // Every 10 seconds
}

function showGreeting(message) {
    try {
        const data = JSON.parse(message);
        console.log('data: ', data);

        if (data) {
            const symbol = data.symbol;
            const volumeChange = data.volumeChange;
            const volume = data.volume;
            const time = new Date().toLocaleTimeString();

            // Check if table header is already present, if not add it
            if ($("#cryptoInfo thead").length === 0) {
                $("#cryptoInfo").append(`
                    <thead>
                        <tr>
                            <th>Time</th>
                            <th>Symbol</th>
                            <th>Volume Change</th>
                            <th>Volume</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                `);
            }

            // Add the data to the table body
            $("#cryptoInfo tbody").append(`
                <tr>
                    <td>${time}</td>
                    <td>${symbol}</td>
                    <td>${volumeChange}</td>
                    <td>${volume}</td>
                </tr>
            `);
        } else {
            console.error('Data is missing required properties:', data);
        }
    } catch (error) {
        console.error('Error parsing JSON:', error);
    }
}

$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $("#connect").click(() => connect());
    $("#disconnect").click(() => disconnect());
    $("#send").click(() => startSendingMessages());
});