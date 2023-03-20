package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {
        refIhm.afficheResultatCircle(null);
        refIhm.afficheMessage(null);
        double valueDouble = 0;
        boolean exceptionDetected = false;
        try {
            valueDouble = Double.parseDouble(value);
            if (valueDouble < 0 || valueDouble > (Double.MAX_VALUE + 1) || valueDouble < (Double.MIN_VALUE - 1)) {
                throw new NumberFormatException();
            }
        } catch (Exception NumberFormatExceptio) {
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'air du cercle (" + value + ")");
            exceptionDetected = true;
        }
        if (exceptionDetected == false) {
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
        }
    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {
        refIhm.afficheResultatRectangle(null);
        refIhm.afficheMessage(null);
        double valueAreaDouble = 0;
        double valueLongueurDouble = 0;
        boolean exceptionDetected = false;

        try {
            valueAreaDouble = Double.parseDouble(valueArea);
            if (valueAreaDouble < 0 || valueAreaDouble > (Double.MAX_VALUE + 1) || valueAreaDouble < (Double.MIN_VALUE - 1)) {
                throw new NumberFormatException();
            }
        } catch (Exception NumberFormatExceptio) {
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'air du rectangle (" + valueArea + ")");
            exceptionDetected = true;
        }

        try {
            valueLongueurDouble = Double.parseDouble(valueLongueur);
            if (valueLongueurDouble < 0 || valueLongueurDouble > (Double.MAX_VALUE + 1) || valueLongueurDouble < (Double.MIN_VALUE - 1)) {
                throw new NumberFormatException();
            }
        } catch (Exception NumberFormatExceptio) {
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour la longueur du rectangle (" + valueLongueur + ")");
            exceptionDetected = true;
        }

        if (exceptionDetected == false) {
            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
        }

    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
