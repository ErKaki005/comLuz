package shared.comLuz.infraestructure.config;

public final class ParameterNotExist extends Throwable {
    public ParameterNotExist(String key) {
        super(String.format("The parameter <%s> does not exist in the environment file", key));
    }
}