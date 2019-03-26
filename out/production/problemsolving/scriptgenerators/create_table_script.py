def createTable(numberOfTables):
	f = open('/Users/amishra/Scripts/output/createTableOutput.txt', 'w')
	for i in range(numberOfTables):
		f.write(("CREATE TABLE table{}(x INT, y INT);\n").format(i))
	f.close()


if __name__ == "__main__": 
	numberOfTables = 10000
	createTable(numberOfTables)