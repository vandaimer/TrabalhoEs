package modelo.util;

public interface Observador
{
    public void notificar( Object fonte, Object msg);
}