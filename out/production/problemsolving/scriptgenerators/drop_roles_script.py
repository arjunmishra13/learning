def createTable(numberOfRoles):
	f = open('/Users/amishra/Scripts/output/dropRolesOutput.txt', 'w')
	for i in range(numberOfRoles):
		f.write(("DROP ROLE r_{};\n").format(i))
	f.close()


if __name__ == "__main__": 
	numberOfRoles = 100
	createTable(numberOfRoles)
