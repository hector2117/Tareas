/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.backend.pojo.VehicleSubModel;
import ni.uni.edu.programacion.views.panels.PnlTableVehicle;
import ni.uni.edu.programacion.views.panels.PnlVehicle;

/**
 *
 * @author Sistemas-05
 */
public class PnlVehicleController {
    private PnlVehicle pnlVehicle;
    private PnlTableVehicle pnlTableVehicle;
    private Gson gson;
    private List<VehicleSubModel> vehicleSubModels;
    private DefaultComboBoxModel cmbModelMake;
    private DefaultComboBoxModel cmbModelmodel;
    private DefaultComboBoxModel cmbModelYear;
    private DefaultComboBoxModel cmbModelIColor;
    private DefaultComboBoxModel cmbModelEColor;
    private DefaultComboBoxModel cmbModelStatus;
    private JFileChooser fileChooser;
    private JComboBox cmbBuscar;
    
    private JsonVehicleDaoImpl jvDao;
    private Border stockBorder;
    
    public PnlVehicleController(PnlVehicle pnlVehicle) throws FileNotFoundException {
        this.pnlVehicle = pnlVehicle;
        initComponent();
    }
    
    public PnlVehicleController(PnlTableVehicle pnlTableVehicle) throws IOException{
        this.pnlTableVehicle = pnlTableVehicle;
        initComponenTable();
      
    }
    
    private void initComponent() throws FileNotFoundException{
        gson = new Gson();
        jvDao = new JsonVehicleDaoImpl();
        
        JsonReader jreader = new JsonReader( new BufferedReader(
                new InputStreamReader(getClass()
                        .getResourceAsStream("/jsons/vehicleData.json"))
        ));
        
        Type listType = new TypeToken<ArrayList<VehicleSubModel>>(){}.getType();
        
        vehicleSubModels = gson.fromJson(jreader,listType);
        
        List<String> makes = vehicleSubModels.stream()
                .map(VehicleSubModel::getMake).sorted().collect(Collectors.toList());
        
        List<String> model = vehicleSubModels.stream().map(VehicleSubModel::getModel)
                .sorted().collect(Collectors.toList());
        
        List<String> year = vehicleSubModels.stream().map(VehicleSubModel::getYear)
                .sorted().collect(Collectors.toList());
        
        List<String> color = vehicleSubModels.stream().map(VehicleSubModel::getColor)
                .sorted().collect(Collectors.toList());
        
        List<String> status = vehicleSubModels.stream().map(VehicleSubModel::getStatus)
                .sorted().collect(Collectors.toList());
        
        cmbModelMake = new DefaultComboBoxModel(makes.toArray());
        cmbModelmodel = new DefaultComboBoxModel(model.toArray());
        cmbModelYear = new DefaultComboBoxModel(year.toArray());
        cmbModelIColor = new DefaultComboBoxModel(color.toArray());
        cmbModelEColor = new DefaultComboBoxModel(color.toArray());
        cmbModelStatus = new DefaultComboBoxModel(status.toArray());

        pnlVehicle.getCmbMake().setModel(cmbModelMake);
        pnlVehicle.getCmbModel().setModel(cmbModelmodel);
        pnlVehicle.getCmbYear().setModel(cmbModelYear);
        pnlVehicle.getCmbEColor().setModel(cmbModelEColor);
        pnlVehicle.getCmbIColor().setModel(cmbModelIColor);
        pnlVehicle.getCmbStatus().setModel(cmbModelStatus);
        
        pnlVehicle.getBtnBrowse().addActionListener(((e) ->{
            btnBrowseActionListener(e);
        }));
        
        pnlVehicle.getBtnSave().addActionListener(((e) ->{
            try {
                btnSaveActionListener(e);
            } catch (Exception ex) {
                Logger.getLogger(PnlVehicleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
        
        pnlVehicle.getTxtStock().addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyTyped(KeyEvent e){
            char code = e.getKeyChar();
            
            if(!Character.isDigit(code)){
               e.consume();
               }
            }
        });
        
        pnlVehicle.getTxtStock().addFocusListener(new FocusAdapter() { //Se activa cuando sobrepasa el campot de texto
            @Override
            public void focusLost(FocusEvent f){
                stockBorder = pnlVehicle.getTxtStock().getBorder();                 
                if(pnlVehicle.getTxtStock().getText().isEmpty()){
                    pnlVehicle.getTxtStock().requestFocus();
                    pnlVehicle.getTxtStock().setBorder(new LineBorder(Color.RED,1));
                    return;
                }
            }
        });
        
    }
    
    private void initComponenTable() throws IOException {

        jvDao = new JsonVehicleDaoImpl();
        List<Vehicle> listVehicles = (List<Vehicle>) jvDao.getAll(); // Se coloca la coleccion en una Lista
        String[][] tableVehicles = new String[jvDao.getNumberVehicle()][15]; //Creacion de una matriz de tipo String
        
        setMatrizForTable(tableVehicles, listVehicles); //Se coloca todos los datos del vehiculo en una matriz tipo String
        
        setTable(tableVehicles); //Con la matriz, se coloca en la tabla y se muestra en el panel al inicializarse
        
        
    }

    private void setTable(String[][] tableVehicles) {
        pnlTableVehicle.getTblTableVehicle().setModel(new DefaultTableModel( //La matriz se coloca en la table
                tableVehicles,
                new String[]{ //Encabezados de cada columna
                    " ID "," Stock number ","  Year","  Make","  Model",
                    "  Style","  VIN","  Exterior color",
                    "  Interior color","  Miles","  Price",
                    "  Transmission","  Engine","  Image", "  Status"
                }
        ));
    }

    private void setMatrizForTable(String[][] tableVehicles, List<Vehicle> listVehicles) throws IOException {
        for (int i=0 ; i < jvDao.getNumberVehicle() ; i++){
            tableVehicles[i][0] = Integer.toString(i+1);
            tableVehicles[i][1] = Integer.toString(listVehicles.get(i).getStockNumber());
            tableVehicles[i][2] = Integer.toString(listVehicles.get(i).getYear());
            tableVehicles[i][3] = listVehicles.get(i).getMake();
            tableVehicles[i][4] = listVehicles.get(i).getModel();
            tableVehicles[i][5] = listVehicles.get(i).getStyle();
            tableVehicles[i][6] = listVehicles.get(i).getVin();
            tableVehicles[i][7] = listVehicles.get(i).getExteriorColor();
            tableVehicles[i][8] = listVehicles.get(i).getInteriorColor();
            tableVehicles[i][9] = listVehicles.get(i).getMiles();
            tableVehicles[i][10] = Float.toString(listVehicles.get(i).getPrice());
            tableVehicles[i][11] = listVehicles.get(i).getTransmission().toString();
            tableVehicles[i][12] = listVehicles.get(i).getEngine();
            tableVehicles[i][13] = listVehicles.get(i).getImage();
            tableVehicles[i][14] = listVehicles.get(i).getStatus();
            
        }
    }
   
    private void btnBrowseActionListener(ActionEvent e){
        fileChooser = new JFileChooser();

        int option = fileChooser.showOpenDialog(null);
        if (option == JFileChooser.CANCEL_OPTION) {
            return;
        }

        File file = fileChooser.getSelectedFile();
        if (!file.exists()) {
            return;
        }

        pnlVehicle.getTxtImage().setText(file.getPath());
        
        }

    private void btnSaveActionListener(ActionEvent e) throws IOException, Exception {
        int stock, year;
        String make,model,style,vin,ecolor,icolor,miles,engine,image,status;
        float price;
        Vehicle.Transmission transmission = Vehicle.Transmission.AUTOMATIC;
        
        if(pnlVehicle.getTxtStock().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Stock number can not be empty");
           return;
        }
        
        stock = Integer.parseInt(pnlVehicle.getTxtStock().getText());
        year = Integer.parseInt(pnlVehicle.getCmbYear().getSelectedItem().toString());
        make = pnlVehicle.getCmbMake().getSelectedItem().toString();
        model = pnlVehicle.getCmbModel().getSelectedItem().toString();
        style = pnlVehicle.getTxtStyle().getText();
        vin = pnlVehicle.getFmtVin().getText();
        ecolor = pnlVehicle.getCmbEColor().getSelectedItem().toString();
        icolor = pnlVehicle.getCmbIColor().getSelectedItem().toString();
        miles = pnlVehicle.getSpnMiles().getModel().getValue().toString();
        price = Float.parseFloat(pnlVehicle.getSpnPrice().getModel().getValue().toString());
        engine = pnlVehicle.getTxtEngine().getText();
        image = pnlVehicle.getTxtImage().getText();
        transmission = pnlVehicle.getRbtnAut().isSelected() ? transmission : Vehicle.Transmission.MANUAL;
        status = pnlVehicle.getCmbStatus().getSelectedItem().toString();
        
        Vehicle v = new Vehicle( stock, year, make, model, style, vin, icolor, icolor, miles, price, transmission, engine, image, status);
        vehicleValidation(v);
        
        jvDao.create(v);
        JOptionPane.showMessageDialog(null, "Vehicle saved successfully.","Information message",JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    private void vehicleValidation(Vehicle v) throws Exception{
        if (v.getStockNumber() <= 0){
        throw  new Exception("Stock Number not valid.");
        }
        
        if (v.getVin().isEmpty() || v.isBlank(v.getVin())){ // v.getVin().isBlank
        throw new Exception("Vin number invalidad.");
        }
        
        if (v.getEngine().isEmpty() || v.isBlank(v.getVin())){  // v.getVin().isBlank
        throw new Exception("Engine cannot be empty.");
        }
    }
    
  
}

