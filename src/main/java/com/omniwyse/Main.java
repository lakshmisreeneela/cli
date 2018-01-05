package com.omniwyse;

import java.util.Collection;

import org.apache.commons.cli.*;

public class Main {

	public static void main(String[] args) {
		Options options = new Options();
		options.addOption("myCmd", "myCommand", false, "will run myCommand()");
		options.addOption("hw", "helloWorld", true, "display hello world the number of time specified");
		options.addOption("opt", "optional", false, "no need to specify");
		options.addOption("help",false, "list all options");
		OptionBuilder.withArgName("");
		OptionBuilder
                .hasArgs(2);
		OptionBuilder
                .withValueSeparator();
		OptionBuilder
                .withDescription("merg two things");
		Option property  = OptionBuilder
                .create( "merg");
		
		options.addOption(property);
		try {
			CommandLine line = new BasicParser().parse(options, args);

			if (line.hasOption("myCmd")) {
				myCommand();
				
			}
			else if (line.hasOption("help")) {
			Collection c = options.getOptions();
			for(Object object:c)
				System.out.println(object.toString());
			}
				
			else if(line.hasOption("merg"))
			{
				String[] searchArgs = line.getOptionValues("merg");
				if(searchArgs.length<2)
				{
					System.out.println("must have two arguments");
					return ;
				}
				System.out.println(searchArgs[0]);
				System.out.println(searchArgs[1]);
				
			}
			else if (line.hasOption("helloWorld")) {
				String repeat = line.getOptionValue("helloWorld");
				helloWorld(repeat);

			}
			else if (line.hasOption("optional")) {
				option();
			}

		} catch (ParseException exp) {
			System.out.println("Unexpected exception:" + exp.getMessage());
		}
		return;
	}

	public static void myCommand() {
		System.out.println("myCommand() just get called");
	}

	private static void helloWorld(String repeat) {
		Integer repeatInt = new Integer(repeat);
		for (int i = 0; i < repeatInt; i++) {
			System.out.println("welcome to first cli programme");
		}
	}

	private static void option() {
		System.out.println("option method called");
	}
	

}
