package org.lockedme.virtualkey.application.consolescreen;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.lockedme.virtualkey.application.services.DirectoryOperation;

public class FileOperation implements ScreenInterface {

	private DirectoryOperation dir = new DirectoryOperation();

	private ArrayList<String> options = new ArrayList<>();

	public FileOperation() {

		options.add("1. Add a File.");
		options.add("2. Delete A File.");
		options.add("3. Search A File.");
		options.add("4. Return to Menu.");

	}

	@Override
	public void display() {
		System.out.println("File Options Menu");
		for (String s : options) {
			System.out.println(s);
		}

	}

	public void getUserInput() {
		int selectedOption;
		while ((selectedOption = this.getOption()) != 4) {
			this.showNavigateOption(selectedOption);
		}
	}

	@Override
	public void showNavigateOption(int option) {

		switch (option) {

		case 1: // Add File
			this.AddFile();

			this.display();
			break;
		case 2: // Delete File
			this.DeleteFile();

			this.display();
			break;
		case 3: // Search File
			this.SearchFile();
			this.display();
			break;

		default:
			System.out.println("Print correct value and retry.");
			break;

		}

	}

	public void AddFile() {
		System.out.println("Please Enter the Filename:");

		String fileName = this.getInputString();

		System.out.println("You are adding a file named: " + fileName);

		try {
			File file = new File(dir.getName() + fileName);

			if (file.createNewFile()) {
				System.out.println("\tFile created: " + file.getName()+" successfully");
				dir.getFiles().add(file);

			} else {
				System.out.println("This File Already Exist");
			}
		} catch (IOException e) {
			System.out.println("bla");
		}
	}

	public void DeleteFile() {

		System.out.println("Please Enter the Filename:");

		String fileName = this.getInputString();

		System.out.println("You are deleting a file named: " + fileName);

		Path path = FileSystems.getDefault().getPath(DirectoryOperation.name + fileName).toAbsolutePath();
		File file = path.toFile();
		if (file.delete()) {
			System.out.println("Deleted File: " + file.getName());
			dir.getFiles().remove(file);
		} else {
			System.out.println("Failed to delete file:" + fileName + ", file was not found.");
		}
	}

	public void SearchFile() {

		Boolean found = false;
		
		System.out.println("Please Enter the Filename:");

		String fileName = this.getInputString();
		Path path = FileSystems.getDefault().getPath(DirectoryOperation.name + fileName).toAbsolutePath();
		System.out.println("\tFile name EXIST in directory: " + path);

		ArrayList<File> files = dir.getFiles();

		for (int i = 0; i < files.size(); i++) {
			if (files.get(i).getName().equals(fileName)) {
				System.out.println("\tFound " + fileName);
				found = true;
			}
		}
		if (found == false) {
			System.out.println("File not found.");
		}
	}

	private String getInputString() {

		Scanner in = new Scanner(System.in);
		return (in.nextLine());

	}

	private int getOption() {
		Scanner in = new Scanner(System.in);

		int returnOption = 0;
		try {
			returnOption = in.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("Invalid input");
		}
		return returnOption;

	}

}
