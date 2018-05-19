package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoBuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoSalvarDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoBO {

	public Anexo buscarPorId(int id) throws Exception{
		try{
			AnexoDAO dao = new AnexoDAO(
                                new AnexoBuscarPorIdDAO(),
                                new AnexoExcluirDAO(),
                                new AnexoListarPorAtaDAO(),
                                new AnexoSalvarDAO()
                        );
			
			return (Anexo) dao.buscar(id);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Anexo> listarPorAta(int idAta) throws Exception{
		try{
                    AnexoDAO dao = new AnexoDAO(
                                new AnexoBuscarPorIdDAO(),
                                new AnexoExcluirDAO(),
                                new AnexoListarPorAtaDAO(),
                                new AnexoSalvarDAO()
                        );
			
			return (List<Anexo>) dao.listar(idAta);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public void validarDados(Anexo anexo) throws Exception{
		if(anexo.getArquivo() == null){
			throw new Exception("Efetue o envio do arquivo.");
		}
		if(anexo.getDescricao().isEmpty()){
			throw new Exception("Informe a descrição do anexo.");
		}
	}
	
	public int salvar(Anexo anexo) throws Exception{
		try{
			if((anexo.getAta() == null) || (anexo.getAta().getIdAta() == 0)){
				throw new Exception("Informe a ata.");
			}
			
			this.validarDados(anexo);
			
			AnexoDAO dao = new AnexoDAO(
                                new AnexoBuscarPorIdDAO(),
                                new AnexoExcluirDAO(),
                                new AnexoListarPorAtaDAO(),
                                new AnexoSalvarDAO()
                        );
			
			return dao.salvar(anexo);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public void excluir(Anexo anexo) throws Exception{
		this.excluir(anexo.getIdAnexo());
	}
	
	public void excluir(int id) throws Exception{
		try{
			AnexoDAO dao = new AnexoDAO(
                                new AnexoBuscarPorIdDAO(),
                                new AnexoExcluirDAO(),
                                new AnexoListarPorAtaDAO(),
                                new AnexoSalvarDAO()
                        );
			
			dao.excluir(id);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
}
