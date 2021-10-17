package org.lockedme.virtualkey.application.consolescreen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.lockedme.virtualkey.application.services.DirectoryService;
import org.lockedme.virtualkey.application.services.ScreenService;

public class StartScreen implements ScreenInterface {

	private String welcomeText = "Welcome to VirtualKey Project";
	private String developerText = "Developer: Anupam Tiwari";
	private String projectVersion = "Version: 1.0.0";
	private String about = "About :It's starting phase product where client can organize the file in a such way like- Add, Delete, Search operation can be performed.";

	private ArrayList<String> options = new ArrayList<>();

	public StartScreen() {
		options.add("1. Show Files Listing");
		options.add("2. Show File Options Menu");
		options.add("3. Quit the operation");

	}

	public void projectinfo() {
		System.out.println(welcomeText);
		System.out.println(developerText);
		System.out.println(projectVersion);
		System.out.println(about);
		System.out.println("\n");
		System.out.println("Please Choose below option 1->Show Listing of Files. 2->Show File Option Menu. 3->Quit the operation.");
		//System.out.println("\n");
		display();
	}

	@Override
	public void display() {
		System.out.println("Main Menu");
		for (String s : options) {
			System.out.println(s);
		}

	}

	public void getUserInput() {
		int selectedOption = 0;
		while ((selectedOption = this.getOption()) != 4) {
			this.showNavigateOption(selectedOption);
		}
	}

	@Override
	public void showNavigateOption(int option) {
		switch (option) {

		case 1: // Show All Files in Directory.
			this.ShowFiles();

			this.display();

			break;

		case 2: // Show File operation Options 
			ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
			ScreenService.getCurrentScreen().display();
			ScreenService.getCurrentScreen().getUserInput();

			this.display();
			break;
		
		case 3:
			System.out.println("Program exited successfully.");
			System.exit(1);

		default:
			System.out.println("Invalid Option");
			break;
		}

	}

	public void ShowFiles() {

		System.out.println("Listing Files in Ascending order : ");
		DirectoryService.PrintFiles();

	}

	private int getOption() {
		Scanner in = new Scanner(System.in);

		int returnOption = 0;
		try {
			returnOption = in.nextInt();
		} catch (InputMismatchException ex) {
			//System.out.println("please provide proper number.");

		}
		return returnOption;

	}
}
