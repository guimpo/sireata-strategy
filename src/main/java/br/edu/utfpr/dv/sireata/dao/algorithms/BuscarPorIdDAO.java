package br.edu.utfpr.dv.sireata.dao.algorithms;

import br.edu.utfpr.dv.sireata.dao.DAOEntity;

public interface BuscarPorIdDAO {
    
    public DAOEntity buscarPorId(int id) throws Exception;
}
