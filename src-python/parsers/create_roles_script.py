def createRole(numberOfRoles):
	f = open('/Users/amishra/Scripts/output/createRolesOutput.txt', 'w')
	for i in range(numberOfRoles):
		f.write(("CREATE ROLE role{};\n").format(i))
		f.write(("GRANT ROLE role{} TO GROUP hive;\n").format(i))
	f.close()


if __name__ == "__main__": 
	numberOfRoles = 5000
	createRole(numberOfRoles)
