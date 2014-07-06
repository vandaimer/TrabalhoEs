package modelo.persistencia;

import java.sql.Connection;

public interface FabricaFerramentasPersistencia
{
    public Connection obterConexao();
    public MapeadorEntidadesDoJogo obterMapeador();
}