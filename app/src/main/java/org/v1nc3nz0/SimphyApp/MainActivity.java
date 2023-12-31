package org.v1nc3nz0.SimphyApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.v1nc3nz0.SimphyApp.enums.AppPlaceholders;
import org.v1nc3nz0.SimphyApp.graphics.layout.HomeLayout;
import org.v1nc3nz0.SimphyApp.graphics.layout.WelcomeLayout;
import org.v1nc3nz0.SimphyApp.logs.Logger;
import org.v1nc3nz0.SimphyApp.managers.FileManager;
import org.v1nc3nz0.SimphyApp.utils.Placeholder;

public class MainActivity extends AppCompatActivity {

    /*
        Layouts
     */
    private HomeLayout homeLayout;
    private WelcomeLayout welcomeLayout;

    /*
        Variables
     */
    private static MainActivity instance;
    private FileManager file_manager;
    private Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_scroll_template);

        MainActivity.instance = this;
        logger = new Logger();
        file_manager = new FileManager();

        welcomeLayout = new WelcomeLayout();
        homeLayout = new HomeLayout();

        getWelcomeLayout().show();
        getWelcomeLayout().build();

        getLogger().send(
                Placeholder.replacePH(
                        MainActivity.getInstance().getString(R.string.application_start),
                        AppPlaceholders.APP_NAME.toString(),
                        MainActivity.getInstance().getString(R.string.app_name)
                )
        );
    }

    /*
        Ottieni il file manager
     */
    public FileManager getFileManager() { return file_manager; }

    /*
        Ottieni l'home layout
     */
    public HomeLayout getHomeLayout() { return homeLayout; }

    /*
        Ottieni il logger/debugger
     */
    public Logger getLogger() { return logger; }

    /*
        Ottieni il welcome layout
     */
    public WelcomeLayout getWelcomeLayout() { return welcomeLayout; }

    /*
        Ottieni il logger/debugger
     */
    public static Logger debug() { return MainActivity.getInstance().getLogger(); }

    /*
        Ritorna l'istanza dell'attività
     */
    public static MainActivity getInstance() { return MainActivity.instance; }

}