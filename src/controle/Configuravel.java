

package controle;


public interface Configuravel<T> {
    
    public void aplicarConfiguracao(Configurador<T> conf);
}
