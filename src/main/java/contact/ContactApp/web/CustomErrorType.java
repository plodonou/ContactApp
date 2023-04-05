package contact.ContactApp.web;

public class CustomErrorType {

    private String errorMessage;
    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){ return this.errorMessage; }
    public void setErrorMessage(String errorMessage){ this.errorMessage = errorMessage; }

}
