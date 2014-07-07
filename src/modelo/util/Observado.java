package modelo.util;

import modelo.util.Observador;

public interface Observado
{
    public void registrar( Observador o );
    public void remover( Observador o );
    public void notificarObservadores( Object msg );
}