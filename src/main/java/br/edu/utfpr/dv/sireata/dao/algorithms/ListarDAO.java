package br.edu.utfpr.dv.sireata.dao.algorithms;

import br.edu.utfpr.dv.sireata.dao.DAOEntity;
import java.util.List;

public interface ListarDAO {
    
    public List<? extends DAOEntity> listar(int id) throws Exception;
}
