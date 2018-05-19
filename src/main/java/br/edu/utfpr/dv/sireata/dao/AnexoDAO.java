package br.edu.utfpr.dv.sireata.dao;

import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;

public class AnexoDAO extends CrudDAO {
    
    
    public AnexoDAO (BuscarDAO buscar,
                     ExcluirDAO excluir,
                     ListarDAO listar,
                     SalvarDAO salvar) {
        
        this.buscar = buscar;
        this.excluir = excluir;
        this.listar = listar;
        this.salvar = salvar;  
    }
}
