const { app, BrowserWindow, Menu } = require('electron');

var mainWindow = null;

async function createWindow() {
    mainWindow = new BrowserWindow({
        maximizable: true
    });

    await mainWindow.loadFile('src/pages/main.html');
    mainWindow.maximize();
    Menu.setApplicationMenu(null);  
    
}

app.whenReady().then(createWindow);

app.on('active', () => {
    if(BrowserWindow.getAllWindows.length() === 0){
        createWindow();
    }
});