def grantRoleToDatabase(numberOfDatabases, roleName, action):
	f = open('/Users/amishra/Scripts/output/grantRoleToDatabase.txt', 'w')
	for i in range(numberOfDatabases):
		f.write(("GRANT {} ON DATABASE db{} TO ROLE {};\n").format(action, i, roleName))
	f.close()


if __name__ == "__main__": 
	numberOfDatabases = 10000
	roleName = "testrole"
	action = "ALL"
	grantRoleToDatabase(numberOfDatabases, roleName, action)