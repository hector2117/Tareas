/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
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
    
    public PnlVehicleController(PnlVehicle pnlVehicle) {
        this.pnlVehicle = pnlVehicle;
        initComponent();
    }
    
    private void initComponent(){
        gson = new Gson();
        
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
        
        
        
    }
}
