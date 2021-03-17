
package ni.edu.uni.programacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import ni.edu.uni.programacion.views.panels.PnlConvertionTemplate;


public class PnlTemperatureController {
    private PnlConvertionTemplate pnlconvertionTemplate;
    private DefaultComboBoxModel <String> fromcmbModel;
    private DefaultComboBoxModel <String> tocmbModel;
    private final String TEMPERATURE[]=new String[]{"Celcius","Fahrenheit"};

    public PnlTemperatureController(PnlConvertionTemplate pnlconvertionTemplate) {
        this.pnlconvertionTemplate = pnlconvertionTemplate;
        initComponent();
    }
    
    private void initComponent(){
        fromcmbModel=new DefaultComboBoxModel<>(TEMPERATURE);
        tocmbModel=new DefaultComboBoxModel<>(TEMPERATURE);
        
        pnlconvertionTemplate.getCmbFrom().setModel(fromcmbModel);
        pnlconvertionTemplate.getCmbTo().setModel(tocmbModel);
        
        pnlconvertionTemplate.getBtnConv().addActionListener(
                (ActionEvent e) -> {
                    btnConvActionPerformed(e);
                    
        });
    }
    
    private void btnConvActionPerformed(ActionEvent e){
        int indexFrom=pnlconvertionTemplate.getCmbFrom().getSelectedIndex();
        int indexTo=pnlconvertionTemplate.getCmbTo().getSelectedIndex();
        double value=Double.parseDouble(pnlconvertionTemplate.getTxtValue().getText());
        
        double result=convertirTemperature(value,indexFrom,indexTo);
        pnlconvertionTemplate.getLblResult().setText("Resultado: "+result);
    }
    
    private double convertirTemperature(double value, int from, int to){
        switch(from){
            case 0:
                switch (to){
                    case 0:
                        return value;
                    case 1:
                        return celciusToFahrenheit( value);
                }
            case 1:
                switch (to){
                    case 0:
                        return fahrenheitToCelcius(value);
                    case 1:
                        return value;
                }
        }
        return value;
    }
    
    private double celciusToFahrenheit(double value){
        return (((double)9/5*value)+32);
    }
    private double fahrenheitToCelcius(double value){
        return ((double)5/9*(value-32));
    }
}
