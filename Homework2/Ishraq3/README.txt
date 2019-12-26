2.	javapathfinder	https://github.com/javapathfinder/jpf-core.git

4. 	Firstly, we built this project
	Built time - 18 seconds (successful)
	Actionable tasks - 16 (All executed)

	Secondly, we we ran all the tests. 
	Totals number of tests - 889
	Passed - All of them
	Failed - None
	Skipped - None 
	Time it took to execute - 8 minutes and 23 seconds 
	
	At the end, it also displays how many actionable tasks were there. 
	It had 17 actionable tasks in which, 5 of them are executed 
	and rest of them are up-to-date.

	Note -  When run-tests.sh runs, it clones forked repository from 
		the original and puts everything inside a folder named homeworks2.
		Inside homework2 folder, it has jpf-core folder that holds all 
		files.



5.	Statement coverage - 47% (96,625 of 185,457)
	Branch coverage - 41% (11,318 of 19,425)

	Total time it took - 11 minutes 46 seconds

	Notes - When run-coverage.sh runs, it calls homework2 folder and jpf-core
		inside it. So, run-tests.sh needs to be run first to run run-coverage.sh.
		At the end it will create a folder called jacocoHtml. Inside this folder,
		it has test-coverage.html file. We tried to move this file outside per
		the instruction but it messes the html layout for some reason and it 
		won't be interactive anymore. So, to keep it interactive and proper 
		layout, we kept the file inside jacocoHtml folder.


6. 	Special Instruction - 
		When run-coverage.sh runs, it calls homework2 folder and jpf-core
		inside it. So, run-tests.sh needs to be run first to run run-coverage.sh.
		At the end it will create a folder called jacocoHtml. Inside this folder,
		it has test-coverage.html file. We tried to move this file outside per
		the instruction but it messes the html layout for some reason and it 
		won't be interactive anymore. So, to keep it interactive and proper layout, 
		we kept the file inside jacocoHtml folder. So, test-coverage.html file will 
		be found inside jacocoHtml folder.