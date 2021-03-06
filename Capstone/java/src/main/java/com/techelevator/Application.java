package com.techelevator;

import com.techelevator.reports.SalesReport;
import com.techelevator.reports.VMLog;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.view.BasicUI;
import com.techelevator.view.MenuDrivenCLI;

import java.math.BigDecimal;
import java.util.Scanner;

public class Application {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SALES_REPORT};

	private static final String SUB_MENU_FEED_MONEY = "Feed Money";
	private static final String SUB_MENU_SELECT_PRODUCT = "Select Product";
	private static final String SUB_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_FEED_MONEY, SUB_MENU_SELECT_PRODUCT, SUB_MENU_FINISH_TRANSACTION};

	VendingMachine vM = new VendingMachine();

	private final BasicUI ui;

	public Application(BasicUI ui) {
		this.ui = ui;
	}

	public static void main(String[] args) {
		BasicUI cli = new MenuDrivenCLI();
		Application application = new Application(cli);
		application.run();
	}

	public void run() {

		boolean finished = false;
		while (!finished) {
			String selection = ui.promptForSelection(MAIN_MENU_OPTIONS);

			if (selection.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				ui.output(vM.displayProducts());
			} else if (selection.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				purchaseItemsSubmenu();
			} else if (selection.equals(MAIN_MENU_OPTION_EXIT)) {
				finished = true;
			} else if (selection.equals(MAIN_MENU_OPTION_SALES_REPORT)) {
				SalesReport.salesReport();
			}
		}
	}

	private void purchaseItemsSubmenu() {
		boolean finished = false;
		while (!finished) {

			String selection = ui.promptForSelection(SUB_MENU_OPTIONS);

			if (selection.equals(SUB_MENU_FEED_MONEY)) {
				//deposit money to account
				//ui.promptForInput("Money to be added")
				Scanner input = new Scanner(System.in);
				ui.output("Enter amount to insert: ");
				try {
					double moneyAmount = Double.parseDouble(input.nextLine());
					ui.output(vM.addMoney(BigDecimal.valueOf(moneyAmount)));
					VMLog.logGiveMoney(moneyAmount, vM.getBalance());
				} catch (NumberFormatException e) {
					ui.output("Please enter a numerical amount.");
				}
			} else if (selection.equals(SUB_MENU_SELECT_PRODUCT)) {
				//selects product
				Scanner input = new Scanner(System.in);
				ui.output("Please select an item location (example A1): ");
				String location = input.nextLine().toUpperCase();
				ui.output(vM.chooseProducts(location));
				VMLog.logPurchase(location, vM.getBalance());
			} else if (selection.equals(SUB_MENU_FINISH_TRANSACTION)) {
				//ends transaction and returns change
				BigDecimal beforeBalance = vM.getBalance();
				ui.output(vM.returnMoney());
				VMLog.logReturnMoney(beforeBalance, vM.getBalance());
				finished = true;
			}
		}
	}


}
