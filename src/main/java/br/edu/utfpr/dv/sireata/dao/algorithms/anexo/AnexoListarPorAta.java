package br.edu.utfpr.dv.sireata.dao.algorithms.anexo;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.DAOEntity;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnexoListarPorAta implements ListarDAO {

    @Override
    public List<? extends DAOEntity> listar(int idAta) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = ConnectionDAO.getInstance().getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT anexos.* FROM anexos " +
                    "WHERE idAta=" + String.valueOf(idAta) + " ORDER BY anexos.ordem");

            List<Anexo> list = new ArrayList<Anexo>();

            while(rs.next()){
                list.add(this.carregarObjeto(rs));
            }

            return list;
        }finally{
            if((rs != null) && !rs.isClosed())
                rs.close();
            if((stmt != null) && !stmt.isClosed())
                stmt.close();
            if((conn != null) && !conn.isClosed())
                conn.close();
        }
    }
    
    private Anexo carregarObjeto(ResultSet rs) throws SQLException{
        Anexo anexo = new Anexo();

        anexo.setIdAnexo(rs.getInt("idAnexo"));
        anexo.getAta().setIdAta(rs.getInt("idAta"));
        anexo.setDescricao(rs.getString("descricao"));
        anexo.setOrdem(rs.getInt("ordem"));
        anexo.setArquivo(rs.getBytes("arquivo"));

        return anexo;
    } 
}
