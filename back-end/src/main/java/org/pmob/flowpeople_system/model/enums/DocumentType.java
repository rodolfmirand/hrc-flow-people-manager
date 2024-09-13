package org.pmob.flowpeople_system.model.enums;

public enum DocumentType {

    CNH("cnh"),
    CPF("cpf"),
    RG("rg");

    private String type;

    DocumentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
