package com.example.w7_p2;

public class Model {

    private String cst;
    private String csf;

    public String getCst(){

        return cst;
    }
    public void setCst(String cst){

        this.cst = cst;
    }
    public String getCsf(){

        return csf;
    }
    public void setCsf(String csf){

        this.cst = csf;
    }

    public Model(String cst, String csf){
        this.cst = cst;
        this.csf = csf;
    }


}
