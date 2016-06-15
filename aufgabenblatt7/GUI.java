package aufgabenblatt7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hash");
		GridPane root = new GridPane();
		Hash ht = new Hash();
		ht.initHt();
		Weblog.erstelleWeblog("weblog.txt", (int)(5E6));
		ht.erstelleHashTabelle("weblog.txt");
		
		//Tabelle fuer Ip Adresse
		ObservableList<String> ipList = FXCollections.<String> observableArrayList();
		ipList.addAll(ht.getIps());
		final ListView<String> ipView = new ListView<String>(ipList);
		ipView.setPrefHeight(500);
		ipView.setPrefWidth(200);
		ipView.setItems(ipList);
		
		//Tabele fuer Data Information
		ObservableList<String> dataList = FXCollections.<String> observableArrayList();
		final ListView<String>dataView = new ListView<String>(ipList);
		dataView.setPrefHeight(500);
		dataView.setPrefWidth(600);
		dataView.setItems(dataList);
		
		//Clicke auf die Ip Addresse und Daten werden angezeigt
		ipView.setOnMouseClicked(value->{
			String key = ipView.getSelectionModel().getSelectedItem();
      if (key != null) {
          dataList.clear();
          dataList.addAll(ht.sucheDaten(key));
          dataView.getSelectionModel().clearSelection();
      }
		});
		
		Label ip = new Label("IP Adressen");
		ip.setPadding(new Insets(5));
		Label data = new Label("Daten");
		data.setPadding(new Insets(5));
		
		root.add(ip, 1, 1);
		root.add(data, 2, 1);
		
		root.add(ipView, 1, 2);
		root.add(dataView, 2, 2);
		
		primaryStage.setScene(new Scene(root,800,500));
		primaryStage.show();
	}

}
