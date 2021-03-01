package sample.controllers;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.opencsv.CSVReader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.connectiondb;

import javax.swing.*;


public class mainframecontroller implements Initializable{
    @FXML
    private Button affiche;
    @FXML
    private Button selec;
    @FXML
    private Button modifi;
    @FXML
    private Button impo;
    @FXML
    private Button quitter;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void handleCloseButtonAction(javafx.event.ActionEvent event) throws IOException{
        Stage stage = (Stage) quitter.getScene().getWindow();
        stage.close();
    }
    public void handleaffiche(javafx.event.ActionEvent event) throws IOException{
        try {

            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/sample/fxml/afficheframe.fxml")));
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void handlemodifi(javafx.event.ActionEvent event) throws IOException {
        try {

            //add you loading or delays - ;-)
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/sample/fxml/modififrame.fxml")));
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void importerbutton (javafx.event.ActionEvent event) throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }

        try (CSVReader reader = new CSVReader(new FileReader("data.csv"), ',');
             Connection connection = connectiondb.conDB();)
        {
            String insertQuery = "Insert into bourse (id,cd1, cd2, fname,lname,datd,univ) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);
            String[] rowData = null;
            int i = 0;
            while((rowData = reader.readNext()) != null)
            {
                for (String data : rowData)
                {
                    pstmt.setString((i % 7) + 1, data);

                    if (++i % 7 == 0)
                        pstmt.addBatch();// add batch

                    if (i % 70 == 0)// insert when the batch size is 10
                        pstmt.executeBatch();
                }
            }
            System.out.println("Data Successfully Uploaded");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
