package com.diesgut.ecriptionfiles.service.imp;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.cert.X509Certificate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.diesgut.ecriptionfiles.PgpcaseApplication;
import com.diesgut.ecriptionfiles.misc.pgp.PGPFileProcessor;
import com.diesgut.ecriptionfiles.model.TableFiles;
import com.diesgut.ecriptionfiles.repository.ITableFilesDAO;
import com.diesgut.ecriptionfiles.service.IPGPService;

@Service
public class PGPServiceImp implements IPGPService {

	private static final Logger log = LoggerFactory.getLogger(PGPServiceImp.class);

	@Autowired
	ITableFilesDAO iTableFilesDAO;

	@Value("${credentialsPath}")
	private String credentialsPath;

	@Value("${keyPGPEncrypt}")
	private String keyPGPEncrypt;

	@Value("${keyPGPDecrypt}")
	private String keyPGPDecrypt;

	@Override
	public void encryptFiles()  {
		log.debug("encryptFiles");
		List<TableFiles> files = iTableFilesDAO.all();
		String encryptKey = credentialsPath + keyPGPEncrypt;
		X509Certificate certificate =null;


		PGPFileProcessor pGPFileProcessor = null;
		for (TableFiles file : files) {
			try {
				log.debug("File {}, Size {}", file.getFileName(), file.getFile().length);

				//File to encrypt
//				File fileToEncrypt = File.createTempFile(file.getFileName(), ".tmp");
//		    	Path path = Paths.get(fileToEncrypt.getAbsolutePath());
//		    	Files.write(path, file.getFile());
		    	//Encrypted file
				File encriptedFile = new File( PgpcaseApplication.FOLDER_ENCRYPT
						+ file.getFileName() + ".pgp");
	
				pGPFileProcessor = new PGPFileProcessor();
				pGPFileProcessor.setKeyFile(encryptKey);
				pGPFileProcessor.setInputFile(file.getFile());
				pGPFileProcessor.setOutputFile(encriptedFile);
				pGPFileProcessor.encrypt();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
