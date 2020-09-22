package util;

public class calculator {
    // Atributos da classe
    private double valorX;
    private double valorY;
    private String operacao;
    private String message = ""; // para tratamento de erros

    public double getValorX() {
        return valorX;
    }
    
    // Seta o valor X verificando se é um valor válido
    public void setValorX(String valueX) {
        try{
            this.valorX = Double.parseDouble(valueX);
        } catch (NumberFormatException e) {
            this.message += "<br> Valor X inválido!";
        }
    }

    public double getValorY() {
        return valorY;
    }

    // Seta o valor Y verificando se é um valor válido
    public void setValorY(String valueY) {
        try{
            this.valorY = Double.parseDouble(valueY);
        } catch (NumberFormatException e) {
            this.message += "<br> Valor Y inválido!";
        }
    }

    public String getOperation() {
        return operacao;
    }

    public void setOperation(String operation) {
        this.operacao = operation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean validate() {
        return !message.equals("");
    }
    
    public double calculate() {
        double result = 0.0;
        
        if(operacao.equals("adicao")) {
            result = (valorX + valorY);
        }
        if(operacao.equals("subtracao")) {
            result = (valorX - valorY); 
        }
        if(operacao.equals("multiplicacao")) {
            result = (valorX * valorY); 
        }
        if(operacao.equals("divisao")) {
            result = (valorX / valorY); 
        }                
        return result;
    }
}
