const { app, BrowserWindow, Menu } = require('electron');

var mainWindow = null;

async function createWindow() {
    mainWindow = new BrowserWindow({
        width: 1920,
        height: 1000
    });

    await mainWindow.loadFile('src/pages/main.html');
    Menu.setApplicationMenu(null);  
}

app.whenReady().then(createWindow);

app.on('active', () => {
    if(BrowserWindow.getAllWindows.length() === 0){
        createWindow();
    }
});