/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import ni.uni.edu.programacion.views.panels.PnlConversionTemplate;

/**
 *
 * @author JADPA02
 */
public class pnlTemperatureController implements ActionListener {

    private PnlConversionTemplate pnlConversionTemplate;
    private final String TEMPERATURES[] = new String[]{"Celcius", "Fahrenheit"};
    private DefaultComboBoxModel temperatureCmbModel;

    public pnlTemperatureController(PnlConversionTemplate pnlConversionTemplate) {
        this.pnlConversionTemplate = pnlConversionTemplate;
    }

    private void initComponent() {
        temperatureCmbModel = new DefaultComboBoxModel(TEMPERATURES);
        pnlConversionTemplate.getCmbFrom().setModel(temperatureCmbModel);
        pnlConversionTemplate.getCmbTu().setModel(temperatureCmbModel);

        pnlConversionTemplate.getBtnCalcular().addActionListener(this);
        pnlConversionTemplate.getBntNew().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Convertir")) {
            int cmbFromIndex = pnlConversionTemplate.getCmbFrom().getSelectedIndex();
            int cmbFromTu = pnlConversionTemplate.getCmbFrom().getSelectedIndex();
            double value = Double.parseDouble(pnlConversionTemplate.getTxtValue().getText());

        }
    }

    private double convertidorTemperature(double value, int from, int tu) {
        switch (from) {
            case 0:
                switch (tu) {
                    case 0:
                        return value;
                    case 1:

                }
            case 1:
                switch (tu) {
                    case 0:
                        return fahrenheitToCelcius(value);
                    case 1:
                        return value;
                }
        }
        return 0;
    }

    private double celciusToFahrenheit(double value) {
        return (((double)9 / 5 * value) + 32);
    }

    private double fahrenheitToCelcius(double value) {
        return ((double)5 / 9 * (value - 32));

    }
}
