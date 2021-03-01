package sample.controllers;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.opencsv.CSVReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.connectiondb;
import sample.data.bourse;

import javax.swing.*;

public class affichecontroller implements Initializable{
    @FXML
    private Button affiche;

    @FXML
    private Button modifi;

    @FXML
    private Button impo;

    @FXML
    private Button imprime;

    @FXML
    private Button quitter;

    @FXML
    private ChoiceBox<?> choicy;

    @FXML
    private Button selec;

    @FXML
    private TextField recherche;
    // tableview data


    private ObservableList<bourse> data;
    @FXML
    private TableView<bourse> boutab;

    @FXML
    private TableColumn<bourse, Integer> bouanne;

    @FXML
    private TableColumn<bourse, String> boufac;

    @FXML
    private TableColumn<bourse, String> bouben;

    @FXML
    private TableColumn<bourse, String> bousex;

    @FXML
    private TableColumn<bourse, Date> boudatearr;

    @FXML
    private TableColumn<bourse, String> bouty;

    @FXML
    private TableColumn<bourse, String> bounompref;

    @FXML
    private TableColumn<bourse, Date> boudatd;

    @FXML
    private TableColumn<bourse, String> bounomprea;

    @FXML
    private TableColumn<bourse, Integer> bouallo;

    @FXML
    private TableColumn<bourse, String> boupays;

    @FXML
    private TableColumn<bourse, Date> boudatedepa;

    @FXML
    private TableColumn<bourse, String> bouet;

    @FXML
    private TableColumn<bourse, Integer> boubil;

    @FXML
    private TableColumn<bourse, Integer> boudurr;

    @FXML
    private TableColumn<bourse, String> boudom;

    @FXML
    private TableColumn<bourse, String> bouid;

    @FXML
    private TableColumn<bourse, String> bougrad;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection conn= connectiondb.conDB();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("select * from bourse");
            while (rs.next()){
                this.data.add(new bourse(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getDate(9),rs.getDate(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getInt(15),rs.getInt(16),rs.getInt(17),rs.getString(18)));
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        this.bouid.setCellValueFactory(new PropertyValueFactory<bourse, String>("id"));
        this.bouben.setCellValueFactory(new PropertyValueFactory<bourse, String>("Bénéficiaire"));
        this.bounompref.setCellValueFactory(new PropertyValueFactory<bourse, String>("nompref"));
        this.bounomprea.setCellValueFactory(new PropertyValueFactory<bourse, String>("nomprea"));
        this.boudatd.setCellValueFactory(new PropertyValueFactory<bourse, Date>("dated"));
        this.bousex.setCellValueFactory(new PropertyValueFactory<bourse, String>("sexe"));
        this.bougrad.setCellValueFactory(new PropertyValueFactory<bourse, String>("grade"));
        this.boudurr.setCellValueFactory(new PropertyValueFactory<bourse ,Integer>("durre"));
        this.boudatedepa.setCellValueFactory(new PropertyValueFactory<bourse, Date>("datedepart"));
        this.boudatearr.setCellValueFactory(new PropertyValueFactory<bourse, Date>("datedarriver"));
        this.boupays.setCellValueFactory(new PropertyValueFactory<bourse, String>("paysdacc"));
        this.bouet.setCellValueFactory(new PropertyValueFactory<bourse, String>("etabacc"));
        this.boudom.setCellValueFactory(new PropertyValueFactory<bourse, String>("domaine"));
        this.bouty.setCellValueFactory(new PropertyValueFactory<bourse, String>("typedestage"));
        this.bouallo.setCellValueFactory(new PropertyValueFactory<bourse ,Integer>("allocation"));
        this.boubil.setCellValueFactory(new PropertyValueFactory<bourse ,Integer>("billet"));
        this.bouanne.setCellValueFactory(new PropertyValueFactory<bourse ,Integer>("annefin"));
        this.boufac.setCellValueFactory(new PropertyValueFactory<bourse, String>("faculte"));

        this.boutab.setItems(null);
        this.boutab.setItems(this.data);

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
            String insertQuery = "Insert into bourse (id,Bénéficiaire, nompref,nomprea,dated,sexe,grade,billet,datedepart,datedarriver,paysdacc,etabacc,domaine,typedestage,allocation,billet,annefin,faculte) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);
            String[] rowData = null;
            int i = 0;
            while((rowData = reader.readNext()) != null)
            {
                for (String data : rowData)
                {
                    pstmt.setString((i % 7) + 1, data);

                    if (++i % 18 == 0)
                        pstmt.addBatch();// add batch

                    if (i % 180 == 0)// insert when the batch size is 10
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
