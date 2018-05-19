package br.edu.utfpr.dv.sireata.dao.algorithms;

import br.edu.utfpr.dv.sireata.dao.DAOEntity;

public interface BuscarDAO {
    
    public DAOEntity buscar(int id) throws Exception;
}
