package org.lockedme.virtualkey.application.services;

import java.io.File;

public class DirectoryService {

	private static DirectoryOperation fileDirectory = new DirectoryOperation();

	public static void PrintFiles() {
		if (fileDirectory.fillFiles().isEmpty()) {
			System.out.println("\tFile not Found.");
		} else {
			for (File file : DirectoryService.getFileDirectory().getFiles()) {
				System.out.println("\t" + file.getName());
			}
		}
	}

	public static DirectoryOperation getFileDirectory() {
		return fileDirectory;
	}

	public static void setFileDirectory(DirectoryOperation fileDirectory) {
		DirectoryService.fileDirectory = fileDirectory;
	}

}
