package org.lockedme.virtualkey.application.services;

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class DirectoryOperation {

	public static final String name = "file/directory/";
	private ArrayList<File> files = new ArrayList<File>();

	Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();

	File Dfiles = path.toFile();

	public String getName() {
		return name;
	}

	public void print() {
		System.out.println("Existing Files: ");
		files.forEach(f -> System.out.println(f));
	}

	public ArrayList<File> fillFiles() {

		File[] directoryFiles = Dfiles.listFiles();

		files.clear();
		for (int i = 0; i < directoryFiles.length; i++) {
			if (directoryFiles[i].isFile()) {
				files.add(directoryFiles[i]);
			}
		}

		Collections.sort(files);

		return files;
	}

	public ArrayList<File> getFiles() {

		fillFiles();
		return files;
	}

}
