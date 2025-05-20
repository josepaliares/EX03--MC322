package lab03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import lab03.model.*;
import lab03.ui.SistemaFacade;

/**
 * Classe principal que inicia a aplicação JavaFX.
 * 
 * @author [Seu Nome] [Seu RA]
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Inicializa o sistema e cria dados de exemplo
        SistemaFacade sistema = SistemaFacade.getInstance();
        sistema.inicializarDadosExemplo();
        
        // Carrega o FXML da tela principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
        Parent root = loader.load();
        
        // Configura a cena
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setTitle("Sistema de Eventos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Método principal que inicia a aplicação.
     * 
     * @param args Argumentos de linha de comando
     */
    public static void main(String[] args) {
        launch(args);
    }
}