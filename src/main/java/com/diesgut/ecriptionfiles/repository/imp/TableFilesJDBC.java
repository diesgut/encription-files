package com.diesgut.ecriptionfiles.repository.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diesgut.ecriptionfiles.model.TableFiles;
import com.diesgut.ecriptionfiles.repository.ITableFilesDAO;

@Repository
public class TableFilesJDBC implements ITableFilesDAO {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
    public List<TableFiles> all() {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        StringBuilder sQuery=new StringBuilder();
        sQuery.append(" SELECT  ");
        sQuery.append(" 	bi.ID_BANK_INTERFACE_PK,   ");
        sQuery.append(" 	bi.FILENAME,   ");
        sQuery.append(" 	bi.INTERFACE_FILE   ");
        sQuery.append(" FROM	  ");
        sQuery.append(" 	BANK_INTERFACE bi   ");
        sQuery.append(" WHERE	  ");
        sQuery.append(" 1=1	  ");
        sQuery.append(" and 	bi.INTERFACE_FILE is not null  ");
        

      
        List<TableFiles> tablesFiles=new ArrayList<>();
        List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(sQuery.toString(), mapSqlParameterSource);
        for (Map row : rows) {
        	TableFiles tablesFile= new TableFiles();
        	tablesFile.setIdTable( (Long)row.get( "ID_BANK_INTERFACE_PK" )  );
        	tablesFile.setFileName((String) row.get( "FILENAME" )   );
        	tablesFile.setFile( (byte[]) row.get( "INTERFACE_FILE" )   );
        	tablesFiles.add(tablesFile);
        }
        return tablesFiles;
        
    }
	
}
