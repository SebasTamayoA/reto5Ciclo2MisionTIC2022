package com.mycompany.controller;

import com.mycompany.model.dao.ComprasProyectoDao;
import com.mycompany.model.dao.InfoLiderDao;
import com.mycompany.model.dao.InfoProyectoDao;
import com.mycompany.model.vo.ComprasProyectoVo;
import com.mycompany.model.vo.InfoLiderVo;
import com.mycompany.model.vo.InfoProyectoVo;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class ReportesController {
    private InfoLiderDao infoLiderDao;
    private InfoProyectoDao infoProyectoDao;
    private ComprasProyectoDao comprasProyectoDao;

    public ReportesController() {
        infoLiderDao = new InfoLiderDao();
        infoProyectoDao = new InfoProyectoDao();
        comprasProyectoDao = new ComprasProyectoDao();
    }

    // Informe 1: Listado de Líderes por Ciudad de Residencia
    public DefaultTableModel listarInfoLider() throws SQLException {
        return infoLiderDao.listar();
    }

    // Informe 2: Listado de Proyectos
    public DefaultTableModel listarInfoProyecto() throws SQLException{
        return null;
    }

    // Informe 3: Listado de Compras por Proyecto
    public DefaultTableModel listarComprasProyecto() throws SQLException {
        return comprasProyectoDao.listar();
    }


}
