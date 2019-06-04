def createTable(numberOfTables):
	f = open('/Users/amishra/Scripts/output/dropTableOutput.txt', 'w')
	for i in range(numberOfTables):
		f.write(("DROP TABLE table{};\n").format(i))
	f.close()


if __name__ == "__main__": 
	numberOfTables = 10000
	createTable(numberOfTables)