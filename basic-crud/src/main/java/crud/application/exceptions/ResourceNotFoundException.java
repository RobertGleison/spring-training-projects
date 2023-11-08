package crud.application.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Integer id){
        super("Resource with id = " + id +" not found in database. ");
    }
}
