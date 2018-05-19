package br.edu.utfpr.dv.sireata.dao;

import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;
import java.util.List;

public abstract class CrudDAO {
    
    protected BuscarDAO buscar;
    protected ExcluirDAO excluir;
    protected ListarDAO listar;
    protected SalvarDAO salvar;
    
    public DAOEntity buscar(int id) throws Exception {
        return buscar.buscar(id);
    }
    
    public void excluir(int id) throws Exception {
        excluir.excluir(id);
    }
    
    public List<? extends DAOEntity> listar(int id) throws Exception {
        return listar.listar(id);
    }
    
    public int salvar (DAOEntity e) throws Exception {
        return salvar.salvar(e);
    }
}
