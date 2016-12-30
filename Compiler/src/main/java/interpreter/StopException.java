package interpreter;

/**
 * Created by kelei on 2016/12/28.
 */
public class StopException extends Exception {
    String errorMessage;

    public StopException(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String toString()
    {
        return errorMessage;
    }

    public String getMessage()
    {
        return errorMessage;
    }
    public StopException(Exception e)
    {
        this.errorMessage = "Fatal Error";
    }
}
