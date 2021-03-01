package sample.data;
import javafx.beans.property.*;

import java.sql.Date;

public class bourse {
   /*1*/ private StringProperty id;
    /*2*/  private StringProperty Bénéficiaire;
    /*3*/  private StringProperty nompref;
    /*4*/ private StringProperty nomprea;
    /*5*/ private ObjectProperty<Date> dated ;
    /*6*/ private StringProperty sexe;
    /*7*/ private StringProperty grade;
    /*8*/ private IntegerProperty durre;
    /*9*/private ObjectProperty<Date> datedepart ;
    /*10*/private ObjectProperty<Date> datedarriver ;
    /*11*/ private StringProperty paysdacc;
    /*12*/private StringProperty etabacc;
    /*13*/private StringProperty domaine;
    /*14*/private StringProperty typedestage;
    /*15*/private IntegerProperty allocation;
    /*16*/private IntegerProperty billet;
    /*17*/private IntegerProperty annefin;
    /*18*/private StringProperty faculte;


    public bourse(String bouid,String bouben,String bounompref,String bounomprea,Date boudatd,String bousex,String bougrad,Integer boudurr,Date boudatedepa,Date boudatearr,String boupays,String bouet,String boudom,String bouty,Integer bouallo,Integer boubil,Integer bouanne,String boufac){
        this.id=new SimpleStringProperty(bouid);
        this.Bénéficiaire=new SimpleStringProperty(bouben);
        this.nompref=new SimpleStringProperty(bounompref);
        this.nomprea=new SimpleStringProperty(bounomprea);
        this.dated=new SimpleObjectProperty<>(boudatd);
        this.sexe=new SimpleStringProperty(bousex);
        this.grade=new SimpleStringProperty(bougrad);
        this.durre= new SimpleIntegerProperty(boudurr);
        this.datedepart=new SimpleObjectProperty<>(boudatedepa);
        this.datedarriver=new SimpleObjectProperty<>(boudatearr);
        this.paysdacc=new SimpleStringProperty(boupays);
        this.etabacc=new SimpleStringProperty(bouet);
        this.domaine=new SimpleStringProperty(boudom);
        this.typedestage=new SimpleStringProperty(bouty);
        this.allocation= new SimpleIntegerProperty(bouallo);
        this.billet= new SimpleIntegerProperty(boubil);
        this.annefin= new SimpleIntegerProperty(bouanne);
        this.faculte=new SimpleStringProperty(boufac);
    }


    public String getId() {
        return this.id.get();
    }

    public StringProperty idProperty() {
        return this.id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getBénéficiaire() {
        return this.Bénéficiaire.get();
    }

    public StringProperty bénéficiaireProperty() {
        return this.Bénéficiaire;
    }

    public void setBénéficiaire(String bénéficiaire) {
        this.Bénéficiaire.set(bénéficiaire);
    }

    public String getNompref() {
        return this.nompref.get();
    }

    public StringProperty nomprefProperty() {
        return this.nompref;
    }

    public void setNompref(String nompref) {
        this.nompref.set(nompref);
    }

    public String getNomprea() {
        return this.nomprea.get();
    }

    public StringProperty nompreaProperty() {
        return this.nomprea;
    }

    public void setNomprea(String nomprea) {
        this.nomprea.set(nomprea);
    }

    public Date getDated() {
        return this.dated.get();
    }

    public ObjectProperty<Date> datedProperty() {
        return this.dated;
    }

    public void setDated(Date dated) {
        this.dated.set(dated);
    }

    public String getSexe() {
        return this.sexe.get();
    }

    public StringProperty sexeProperty() {
        return this.sexe;
    }

    public void setSexe(String sexe) {
        this.sexe.set(sexe);
    }

    public String getGrade() {
        return this.grade.get();
    }

    public StringProperty gradeProperty() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public int getDurre() {
        return this.durre.get();
    }

    public IntegerProperty durreProperty() {
        return this.durre;
    }

    public void setDurre(int durre) {
        this.durre.set(durre);
    }

    public Date getDatedepart() {
        return this.datedepart.get();
    }

    public ObjectProperty<Date> datedepartProperty() {
        return this.datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart.set(datedepart);
    }

    public Date getDatedarriver() {
        return this.datedarriver.get();
    }

    public ObjectProperty<Date> datedarriverProperty() {
        return this.datedarriver;
    }

    public void setDatedarriver(Date datedarriver) {
        this.datedarriver.set(datedarriver);
    }

    public String getPaysdacc() {
        return this.paysdacc.get();
    }

    public StringProperty paysdaccProperty() {
        return this.paysdacc;
    }

    public void setPaysdacc(String paysdacc) {
        this.paysdacc.set(paysdacc);
    }

    public String getEtabacc() {
        return this.etabacc.get();
    }

    public StringProperty etabaccProperty() {
        return this.etabacc;
    }

    public void setEtabacc(String etabacc) {
        this.etabacc.set(etabacc);
    }

    public String getDomaine() {
        return this.domaine.get();
    }

    public StringProperty domaineProperty() {
        return this.domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine.set(domaine);
    }

    public String getTypedestage() {
        return this.typedestage.get();
    }

    public StringProperty typedestageProperty() {
        return this.typedestage;
    }

    public void setTypedestage(String typedestage) {
        this.typedestage.set(typedestage);
    }

    public int getAllocation() {
        return this.allocation.get();
    }

    public IntegerProperty allocationProperty() {
        return this.allocation;
    }

    public void setAllocation(int allocation) {
        this.allocation.set(allocation);
    }

    public int getBillet() {
        return this.billet.get();
    }

    public IntegerProperty billetProperty() {
        return this.billet;
    }

    public void setBillet(int billet) {
        this.billet.set(billet);
    }

    public int getAnnefin() {
        return this.annefin.get();
    }

    public IntegerProperty annefinProperty() {
        return this.annefin;
    }

    public void setAnnefin(int annefin) {
        this.annefin.set(annefin);
    }

    public String getFaculte() {
        return this.faculte.get();
    }

    public StringProperty faculteProperty() {
        return this.faculte;
    }

    public void setFaculte(String faculte) {
        this.faculte.set(faculte);
    }
}
