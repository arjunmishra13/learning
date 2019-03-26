def createRole(initial, numberOfRoles):
	f = open('/Users/amishra/Scripts/output/createRolesOutput.hql', 'w')
	for i in range(numberOfRoles):
		f.write(("CREATE ROLE role{};\n").format(initial + i))
		f.write(("GRANT ROLE role{} TO GROUP hive;\n").format(initial + i))
	f.close()


if __name__ == "__main__": 
	numberOfRoles = 5000
	initial = 3001
	createRole(initial, numberOfRoles)
