package hello;

/**
 * Created by sridharyadav on 9/23/16.
 */
public class JsonResponse {

    private String status = "";
    private String errorMessage = "";

    public JsonResponse(String status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
