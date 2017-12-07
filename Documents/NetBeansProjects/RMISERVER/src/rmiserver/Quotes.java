
package rmiserver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quotes {

    @SerializedName("USDEUR")
    @Expose
    private Double uSDEUR;
    @SerializedName("USDEGP")
    @Expose
    private Double uSDEGP;
    @SerializedName("USDGBP")
    @Expose
    private Double uSDGBP;
    @SerializedName("USDSAR")
    @Expose
    private Double uSDSAR;
    @SerializedName("USDQAR")
    @Expose
    private Double uSDQAR;

    public Double getUSDEUR() {
        return uSDEUR;
    }

    public void setUSDEUR(Double uSDEUR) {
        this.uSDEUR = uSDEUR;
    }

    public Double getUSDEGP() {
        return uSDEGP;
    }

    public void setUSDEGP(Double uSDEGP) {
        this.uSDEGP = uSDEGP;
    }

    public Double getUSDGBP() {
        return uSDGBP;
    }

    public void setUSDGBP(Double uSDGBP) {
        this.uSDGBP = uSDGBP;
    }

    public Double getUSDSAR() {
        return uSDSAR;
    }

    public void setUSDSAR(Double uSDSAR) {
        this.uSDSAR = uSDSAR;
    }

    public Double getUSDQAR() {
        return uSDQAR;
    }

    public void setUSDQAR(Double uSDQAR) {
        this.uSDQAR = uSDQAR;
    }

}
