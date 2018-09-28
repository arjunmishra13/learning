def insertIntoStatements(initialRoleId, initialRoleNameId, numberOfRoles):
	f = open('/Users/amishra/Scripts/output/insertIntoStatements.sql', 'w')
	for i in range(numberOfRoles):
		f.write(("INSERT INTO SENTRY_ROLE VALUES ({}, 'role{}', UNIX_TIMESTAMP());\n").format(initialRoleId + i, initialRoleNameId + i))
		f.write(("INSERT INTO SENTRY_ROLE_GROUP_MAP VALUES ({}, 1, NULL);\n").format(initialRoleId + i))
	f.close()


if __name__ == "__main__":
	initialRoleId = 4690
	initialRoleNameId = 4682
	numberOfRoles = 3500
	insertIntoStatements(initialRoleId, initialRoleNameId, numberOfRoles)
