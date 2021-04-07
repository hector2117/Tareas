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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.backend.pojo.VehicleSubModel;
import ni.uni.edu.programacion.views.panels.PnlVehicle;

/**
 *
 * @author Sistemas-05
 */
public class PnlVehicleController {
    private PnlVehicle pnlVehicle;
    private Gson gson;
    private List<VehicleSubModel> vehicleSubModels;
    private DefaultComboBoxModel cmbModelMake;
    private DefaultComboBoxModel cmbModelmodel;
    private DefaultComboBoxModel cmbModelYear;
    private DefaultComboBoxModel cmbModelIColor;
    private DefaultComboBoxModel cmbModelEColor;
    private DefaultComboBoxModel cmbModelStatus;
    private JFileChooser fileChooser;
    
    private JsonVehicleDaoImpl jvDao;
    private Border stockBorder;
    
    public PnlVehicleController(PnlVehicle pnlVehicle) throws FileNotFoundException {
        this.pnlVehicle = pnlVehicle;
        initComponent();
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
    
    private void btnBrowseActionListener(ActionEvent e){
            fileChooser = new JFileChooser();
        
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
        
        Vehicle v = new Vehicle(stock, year, make, model, style, vin, icolor, icolor, miles, price, transmission, engine, image, status);
        vehicleValidation(v);
        
        jvDao.create(v);
        JOptionPane.showMessageDialog(null, "Vehicle saved successfully.","Information message",JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    private void vehicleValidation(Vehicle v) throws Exception{
        if (v.getStockNumber() <= 0){
        throw  new Exception("Stock Number not valid.");
        }
        
        if (v.getVin().isEmpty() || v.getVin().isBlank()){
        throw new Exception("Vin number invalidad.");
        }
        
        if (v.getEngine().isBlank() || v.getEngine().isBlank()){
        throw new Exception("Engine cannot be empty.");
        }
        
    }
        
}
