/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bilal
 */
public class ExchangeRates {
    double USDEGP ,USDEUR,USDSAR,USDQAR,USDGBP;

    public ExchangeRates(double USDEGP, double USDEUR, double USDSAR, double USDQAR, double USDGBP) {
        this.USDEGP = USDEGP;
        this.USDEUR = USDEUR;
        this.USDSAR = USDSAR;
        this.USDQAR = USDQAR;
        this.USDGBP = USDGBP;
    }

    public double getUSDEGP() {
        return USDEGP;
    }

    public void setUSDEGP(double USDEGP) {
        this.USDEGP = USDEGP;
    }

    public double getUSDEUR() {
        return USDEUR;
    }

    public void setUSDEUR(double USDEUR) {
        this.USDEUR = USDEUR;
    }

    public double getUSDSAR() {
        return USDSAR;
    }

    public void setUSDSAR(double USDSAR) {
        this.USDSAR = USDSAR;
    }

    public double getUSDQAR() {
        return USDQAR;
    }

    public void setUSDQAR(double USDQAR) {
        this.USDQAR = USDQAR;
    }

    public double getUSDGBP() {
        return USDGBP;
    }

    public void setUSDGBP(double USDGBP) {
        this.USDGBP = USDGBP;
    }
    
    
}
