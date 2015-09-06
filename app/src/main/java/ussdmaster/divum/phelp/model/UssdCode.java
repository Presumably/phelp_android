package ussdmaster.divum.phelp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UssdCode {

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Code")
    @Expose
    private String code;

    @SerializedName("Language")
    @Expose
    private String language;


    public UssdCode() {

    }

    public UssdCode(String name, String code, String language) {
        this.name = name;
        this.code = code;
        this.language = language;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
