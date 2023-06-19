package com.fjavmv.cpestados.cpestados.repository;

public class Sql {
    protected static  String SQL_SELECT = "SELECT  * FROM oaxacacps";
    protected static String SQL_INSERT = "INSERT INTO cp_oaxaca(asentamiento, municipio, estado, ciudad, cod_postal) VALUES(?,?,?,?,?)";
    protected static String SQL_UPDATE = "UPDATE cp_oaxaca SET asentamiento = ?, municipio = ?, estado = ?, ciudad = ?, cod_postal = ? WHERE id = ?";
    protected static String SQL_DELETE = "DELETE FROM cp_oaxaca WHERE id =?";
    protected  static String SQL_SEARCH_POSTAL_CODE = "SELECT d_mnpio, d_asenta, d_estado, d_ciudad FROM oaxacacps WHERE d_codigo = ? ";

}
