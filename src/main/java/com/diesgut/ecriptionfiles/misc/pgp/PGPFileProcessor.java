
package com.diesgut.ecriptionfiles.misc.pgp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PGPFileProcessor {

	private String passphrase;

	private String keyFile;

	private File inputFile;

	private String outputFilePath;
	private File outputFile;

	private boolean asciiArmored = false;

	private boolean integrityCheck = true;

	public boolean encrypt() throws Exception {
		FileInputStream keyIn = new FileInputStream(keyFile);
//		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(keyFile);
		FileOutputStream out = new FileOutputStream(outputFile);
		PGPUtil.encryptFile(out, inputFile, PGPUtil.readPublicKey(keyIn), asciiArmored, integrityCheck);
	//	out.close();
//		inputStream.close();
		keyIn.close();
		return true;
	}

	public boolean decrypt() throws Exception {
//        FileInputStream in = new FileInputStream(inputFile);
//        FileInputStream keyIn = new FileInputStream(keyFile);
//        FileOutputStream out = new FileOutputStream(outputFile);
//        PGPUtil.decryptFile(in, out, keyIn, passphrase.toCharArray());
//        in.close();
//        out.close();
//        keyIn.close();
		return true;
	}

	public boolean isAsciiArmored() {
		return asciiArmored;
	}

	public void setAsciiArmored(boolean asciiArmored) {
		this.asciiArmored = asciiArmored;
	}

	public boolean isIntegrityCheck() {
		return integrityCheck;
	}

	public void setIntegrityCheck(boolean integrityCheck) {
		this.integrityCheck = integrityCheck;
	}

	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public String getKeyFile() {
		return keyFile;
	}

	public void setKeyFile(String keyFile) {
		this.keyFile = keyFile;
	}

	public File getInputFile() {
		return inputFile;
	}

	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	public void setInputFile(byte[] inputFile) {
		try {
			String timeInMillis = "" + System.currentTimeMillis();
			File fileToEncrypt = File.createTempFile(timeInMillis, ".tmp");
			Path path = Paths.get(fileToEncrypt.getAbsolutePath());
			Files.write(path, inputFile);
			fileToEncrypt = new File(fileToEncrypt.getAbsolutePath());
			this.inputFile = fileToEncrypt;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	public File getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}

}
